package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.pojo.SearchCriteria
import com.example.futheadbackend.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.regex.Pattern

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping(value = ["/players"])
class PlayerController(@Autowired private val playerService: PlayerService) {
    @RequestMapping(value = ["/club/{club}"])
    @ResponseBody
    fun getPlayersFromClub(@PathVariable("club") club: String): List<PlayerWithPositions> {
        return playerService.findPlayerWithPositions(club)
    }

    @RequestMapping(value = ["/{id}"])
    @ResponseBody
    fun getPlayerById(@PathVariable("id") id: Int): Player? {
        return playerService.getPlayerById(id)
    }

    @RequestMapping(value = ["/query"])
    @ResponseBody
    fun getPlayersBySearchQuery(@RequestParam(value = "search", required = true) search: String): List<Player?> {
        val params: MutableList<SearchCriteria> = mutableListOf()
        val pattern = Pattern.compile("(\\w+?)([:<>])(\\w+?),")
        val matcher = pattern.matcher("$search,")
        while (matcher.find()) {
            params.add(SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)))
        }
        return playerService.getPlayersBySearchCriteria(params)
    }
}