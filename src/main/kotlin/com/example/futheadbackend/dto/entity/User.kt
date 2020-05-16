package com.example.futheadbackend.dto.entity

import com.example.futheadbackend.dto.contract.UserContract
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
        override val username: String,
        @Column(name = "registration_date") override val registrationDate: String,
        override val email: String,
        override val password: String
) : UserContract