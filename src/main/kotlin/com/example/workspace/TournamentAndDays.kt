package com.example.workspace

import java.util.*

fun main() {
    tournament()
}

fun tournament() {
    val players = listOf(10, 20, 30, 40, 50, 60).toMutableList()
    val jornadasIdaOnly = players.size - 1
    val jornadasIdaVuelta = (players.size * 2) - 2
    var matchesPerJornada = players
    for (i in 0 until jornadasIdaVuelta) {
        println("Partidos de la jornada ${i + 1}")
        if (i < jornadasIdaVuelta / 2) {
            matchesPerJornada.getMapFromList().forEach(::println)
        } else {
            matchesPerJornada.getMapFromList(true).forEach(::println)
        }
        matchesPerJornada = matchesPerJornada.reorderItemsForward()
        println()
    }
}

fun MutableList<Int>.reorderItemsForward(): MutableList<Int> {
    val element = this[this.size - 1]
    this.removeAt(this.size - 1)
    this.add(1, element)
    return this
}

fun MutableList<Int>.getMapFromList(swapHomeForAway: Boolean = false): MutableList<Pair<Int, Int>> {
    val map = mutableListOf<Pair<Int, Int>>()
    val size = this.size
    val listOne = this.slice(0 until (size / 2))
    val listTwo = this.minus(listOne)
    for (i in 0 until size / 2) {
        if (swapHomeForAway) {
            map.add(Pair(listTwo[i], listOne[i]))
        } else {
            map.add(Pair(listOne[i], listTwo[i]))
        }
    }
    return map
}