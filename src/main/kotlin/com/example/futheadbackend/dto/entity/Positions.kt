package com.example.futheadbackend.dto.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Positions(@Id val position: String) {
}