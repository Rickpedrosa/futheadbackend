package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.User
import com.example.futheadbackend.dto.response.OnSaveUserResponse
import com.example.futheadbackend.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping(path = ["/user"])
class UserController(@Autowired val userService: UserService) {

    @RequestMapping(
            path = ["/register"],
            method = [RequestMethod.POST],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun registerUser(@RequestBody user: User): OnSaveUserResponse {
        return userService.registerUser(user)
    }

//    @RequestMapping(value = ["/{userName}/tournaments"])
//    fun getUserTournaments(@PathVariable("userName") userName: String): List<Tournament> {
//        return userService.getTournamentsPerUser(userName)
//    }
}