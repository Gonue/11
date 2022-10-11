package com.example.server.controller;

import com.example.server.entity.Item;
import com.example.server.entity.Like;
import com.example.server.repository.ItemRepository;
import com.example.server.repository.LikeRepository;
import com.example.server.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LikeController {

    @Autowired
    JwtService jwtService;
    @Autowired
    LikeRepository likeRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/api/like/items")
    public ResponseEntity getLikeItems(@CookieValue(value = "token",required = false)String token){
        if(!jwtService.isValid(token)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);//
        }

        int memberId = jwtService.getId(token);
        List<Like> likes = likeRepository.findByMemberId(memberId);
        List<Integer> itemIds = likes.stream().map(Like::getItemId).collect(Collectors.toList());
        List<Item> items = itemRepository.findByIdIn(itemIds);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/api/like/items/{itemId}")
   public ResponseEntity pushLikeItem(
           @PathVariable("itemId") int itemId,
           @CookieValue(value = "token", required = false) String token
    ){
        if(!jwtService.isValid(token)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);//
        }

        int memberId = jwtService.getId(token);
        Like like = likeRepository.findByMemberIdAndItemId(memberId, itemId);

        if(like == null){
            Like newLike = new Like();
            newLike.setMemberId(memberId);
            newLike.setItemId(itemId);
            likeRepository.save(newLike);
        }

        return new ResponseEntity<>(HttpStatus.OK);
   }
    @DeleteMapping("/api/like/items/{itemId}")
    public ResponseEntity removeLikeItem(
            @PathVariable("itemId") int itemId,
            @CookieValue(value = "token", required = false) String token
    ){
        if(!jwtService.isValid(token)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);//
        }

        int memberId = jwtService.getId(token);
        Like like = likeRepository.findByMemberIdAndItemId(memberId, itemId);

        likeRepository.delete(like);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

