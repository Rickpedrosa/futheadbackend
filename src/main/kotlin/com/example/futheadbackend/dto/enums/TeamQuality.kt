package com.example.futheadbackend.dto.enums

enum class TeamQuality(val potential: String) {
    GOLDEN("quality BETWEEN 5 AND 4"),
    SILVER("quality BETWEEN 5 AND 3.5"),
    BRONZE("quality < 3.5")
}