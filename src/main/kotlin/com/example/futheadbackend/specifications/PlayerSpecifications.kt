package com.example.futheadbackend.specifications

import com.example.futheadbackend.dto.entity.Player
import org.springframework.data.jpa.domain.Specification

//fun withPosition(position: String?): Specification<Player>? {
//    return if (position == null) {
//        null
//    } else {
//        Specification { root, _, cb ->
//            cb.equal(root.join<Player, String>("positions").get(""), position)
//        }
//    }
//}