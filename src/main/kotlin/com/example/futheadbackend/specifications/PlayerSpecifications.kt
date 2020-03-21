package com.example.futheadbackend.specifications

import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.pojo.SearchCriteria
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class PlayerSpecifications(private val criteria: SearchCriteria) : Specification<Player> {
    override fun toPredicate(root: Root<Player>, query: CriteriaQuery<*>, builder: CriteriaBuilder): Predicate? {
        return when (criteria.operation) {
            ":" -> return builder.like(root.get(criteria.key), "%${criteria.value}%")
            ">" -> return builder.greaterThan(root.get(criteria.key), "${criteria.value}")
            "<" -> return builder.lessThan(root.get(criteria.key), "${criteria.value}")
            ">=" -> return builder.greaterThanOrEqualTo(root.get(criteria.key), "${criteria.value}")
            "<=" -> return builder.lessThanOrEqualTo(root.get(criteria.key), "${criteria.value}")
            "lol" -> {
                return null
            }
            else -> null
        }
    }
}
