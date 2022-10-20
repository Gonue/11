package com.example.server.controller;

import com.example.server.dto.MusicDto;
import com.example.server.dto.OrderDto;
import com.example.server.entity.Like;
import com.example.server.entity.Music;
import com.example.server.entity.Order;
import com.example.server.repository.CartRepository;
import com.example.server.repository.LikeRepository;
import com.example.server.repository.MusicRepository;
import com.example.server.repository.OrderRepository;
import com.example.server.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class MusicController {

    @Autowired
    JwtService jwtService;

    @Autowired
    MusicRepository musicRepository;
    @Autowired
    LikeRepository likeRepository;

    @GetMapping("/api/music")
    public ResponseEntity getOrder(
            @CookieValue(value = "token", required = false) String token
    ){
        if(!jwtService.isValid(token)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);//
        }
        int memberId = jwtService.getId(token);
        List<Music> music = musicRepository.findAll();
        return new ResponseEntity<>(music,HttpStatus.OK);

    }
    @Transactional
    @PostMapping("/api/music")
   public ResponseEntity pushOrder(
           @RequestBody MusicDto dto,
           @CookieValue(value = "token", required = false) String token
    ){
        if(!jwtService.isValid(token)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);//
        }

        Music newMusic = new Music();
        int memberId = jwtService.getId(token);
        newMusic.setMemberId(memberId);
        newMusic.setName(dto.getName());
        newMusic.setSong_name(dto.getSongName());
        newMusic.setFile(dto.getFile());
        newMusic.setItems(dto.getItems());

        musicRepository.save(newMusic);

        return new ResponseEntity<>(HttpStatus.OK);
   }

}

