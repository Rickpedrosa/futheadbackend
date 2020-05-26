package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "players")
data class Player(
        @ManyToOne
        @JoinColumn(name = "club")
        val club: Team,
        @Id @Column(name = "id") val playerId: Int,
        @Column(name = "name") val playerName: String,
        val image: String,
        val nationality: String,
        val age: Int,
        var value: Long,
        var wage: Long,
        val potential: Int,
        @ManyToMany(
                fetch = FetchType.LAZY,
                cascade = [CascadeType.PERSIST, CascadeType.MERGE]
        )
        @JoinTable(
                name = "playerpositions",
                joinColumns = [JoinColumn(name = "player_id")],
                inverseJoinColumns = [JoinColumn(name = "pos")]
        )
        val positions: MutableSet<Positions> = mutableSetOf()
) {
    override fun hashCode(): Int {
        return playerId.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        other as Player
        return other.playerId == this.playerId
    }
}

