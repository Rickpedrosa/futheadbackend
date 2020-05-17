package com.example.futheadbackend.dto.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
        @Id val username: String,
        @Column(name = "registration_date") val registrationDate: String,
        val email: String,
        val password: String
)