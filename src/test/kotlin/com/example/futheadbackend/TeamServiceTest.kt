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
        val spec = PlayerSpecifications(SearchCriteria(
                "potential",
                ">",
                "85"))
                .and(PlayerSpecifications(SearchCriteria(
                        "nationality",
                        ":",
                        "Spain")))
                ?.and(PlayerSpecifications(SearchCriteria(
                        "age",
                        ">",
                        "30")))
        val players = playerRepository.findAll(where(spec))

        println("${players.size}")
        players.forEach(::println)
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
