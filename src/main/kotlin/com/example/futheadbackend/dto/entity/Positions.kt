package com.example.futheadbackend.dto.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "positions")
data class Positions(
        @Id val position: String,
        @ManyToMany(
                fetch = FetchType.LAZY,
                cascade = [CascadeType.PERSIST, CascadeType.MERGE],
                mappedBy = "positions"
        )
        @JsonIgnore
        val players: MutableSet<Player> = mutableSetOf()
) {
    override fun equals(other: Any?): Boolean {
        other as Positions
        return other.position == this.position
    }

    override fun hashCode(): Int {
        return position.hashCode()
    }
}