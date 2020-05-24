package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.User
import com.example.futheadbackend.dto.response.OnSaveUserResponse
import com.example.futheadbackend.repository.UserRepository
import com.example.futheadbackend.repository.impls.UserRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository) : UserRepositoryImpl {
    override fun registerUser(user: User): OnSaveUserResponse {
        val userSaved = userRepository.save(user)
        return OnSaveUserResponse(userSaved, "", 200)
    }

    override fun login(userName: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
