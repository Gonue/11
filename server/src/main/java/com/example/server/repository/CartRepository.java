package com.example.server.repository;

import com.example.server.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByMemberId(int memberID);
    Cart findByMemberIdAndItemId(int memberId, int itemId);//사용자의 아이디값과 아디값이 있으면 가져오는 메서드
}
