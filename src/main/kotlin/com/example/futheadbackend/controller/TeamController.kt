package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/teams"])
class TeamController(@Autowired private val teamService: TeamService) {
    @GetMapping
    @ResponseBody
    fun getClubsFilteredByText(@RequestParam("club") club: String): List<Team?> {
        return teamService.getClubsFilteredByText("%$club%")
    }

    @RequestMapping(value = ["/golden"])
    @ResponseBody
    fun getGoldenClubs(@RequestParam("page") page: Int): Page<Team> {
        return teamService.getFiveStarsClubs(PageRequest.of(
                page,
                30,
                Sort.by("average").descending()))
    }
}