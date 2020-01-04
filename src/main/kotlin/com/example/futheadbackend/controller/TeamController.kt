package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/teams"])
class TeamController(@Autowired private val teamService: TeamService) {
    @GetMapping
    @ResponseBody
    fun getClubsFilteredByText(@RequestParam("club") clubx: String): List<Team> {
        val club = "'%$clubx%'"
        return teamService.getTeamsByText(club)
    }
}