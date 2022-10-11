package com.example.server.repository;

import com.example.server.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    List<Like> findByMemberId(int memberID);
    Like findByMemberIdAndItemId(int memberId, int itemId);//사용자의 아이디값과 아디값이 있으면 가져오는 메서드
}