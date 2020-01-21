package com.example.futheadbackend

import com.example.futheadbackend.repository.PlayerRepository
import com.example.futheadbackend.repository.TeamRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.Specification.*

@SpringBootTest
class TeamServiceTest(@Autowired private val teamRepository: TeamRepository,
                      @Autowired private val playerRepository: PlayerRepository) {
    @Test
    fun testAPICall() {
        val id = "%wakandaksdkadka%"
        println("${teamRepository.getClubsFilteredByText(id = id)}")
    }

    @Test
    fun testPlayerCall() {
        println("${playerRepository.findPlayerById(20801)}")
    }

    fun xd() {
//        playerRepository.findAll(where(wit))
    }
}
