package com.example.futheadbackend

import com.example.futheadbackend.dto.pojo.SearchCriteria
import com.example.futheadbackend.repository.PlayerRepository
import com.example.futheadbackend.repository.TeamRepository
import com.example.futheadbackend.specifications.PlayerSpecifications
//import com.example.futheadbackend.specifications.withPosition
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
    fun trySpecifications() {
        val players = playerRepository.findAll(
                PlayerSpecifications(
                        SearchCriteria(
                                "potential",
                                ">",
                                "messi")))

        println("${players.size}")
    }
//    @Test
//    fun testPlayerCall() {
//        println("${playerRepository.findPlayerById(20801)}")
//    }

//    @Test
//    fun xd() {
//        playerRepository.findAll(where(withPosition("GK"))).forEach(::println)
//    }
}
