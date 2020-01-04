package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/players"])
class PlayerController(@Autowired private val playerService: PlayerService) {
    @RequestMapping(value = ["/club/{club}"])
    @ResponseBody
    fun getPlayersFromClub(@PathVariable("club") club: String): List<PlayerWithPositions> {
        return playerService.findPlayerWithPositions(club)
    }

    @GetMapping
    @ResponseBody
    fun getPlayerById(@RequestParam("id") id: Int): Player {
        return playerService.getPlayerById(id)
    }
}