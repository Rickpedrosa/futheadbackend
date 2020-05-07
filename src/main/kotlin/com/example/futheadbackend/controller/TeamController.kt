package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.dto.pojo.RandomTeam
import com.example.futheadbackend.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
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
        return teamService.getGoldenClubs(PageRequest.of(
                page,
                30,
                Sort.by("average").descending()))
    }

    @RequestMapping(value = ["/silver"])
    @ResponseBody
    fun getSilverClubs(@RequestParam("page") page: Int): Page<Team> {
        return teamService.getSilverClubs(PageRequest.of(
                page,
                30,
                Sort.by("average").descending()))
    }

    @RequestMapping(value = ["/bronze"])
    @ResponseBody
    fun getBronzeClubs(@RequestParam("page") page: Int): Page<Team> {
        return teamService.getBronzeClubs(PageRequest.of(
                page,
                30,
                Sort.by("average").descending()))
    }

    @RequestMapping(value = ["/random"])
    @ResponseBody
    fun getRandomTeams(@RequestParam("size") random: Int): List<RandomTeam> {
        return teamService.getRandomClubs(random)
    }
}