package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Match
import com.example.futheadbackend.dto.pojo.MatchUpdateRequest
import com.example.futheadbackend.service.MatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping(value = ["/match"])
class MatchController(@Autowired private val matchService: MatchService) {
    @RequestMapping(
            path = ["/update"],
            method = [RequestMethod.POST],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun updateMatch(@RequestBody matchUpdateRequest: MatchUpdateRequest): Match {
        return matchService.updateMatch(matchUpdateRequest)
    }
}