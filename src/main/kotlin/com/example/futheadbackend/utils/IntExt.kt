package com.example.futheadbackend.utils

fun Int.isOdd(): Boolean {
    return this % 2 == 1
}

fun MutableList<String>.reorderItemsForward(): MutableList<String> {
    val element = this[this.size - 1]
    val fixedPosition = if (this.size.isOdd()) 0 else 1
    this.removeAt(this.size - 1)
    this.add(fixedPosition, element)
    return this
}

fun MutableList<String>.getMapFromList(swapHomeForAway: Boolean = false): MutableList<Pair<String, String>> {
    val map = mutableListOf<Pair<String, String>>()
    val listOne = this.slice(0 until (this.size / 2)).toMutableList()
    val sizeForLoop = if (this.size.isOdd()) {
        listOne.add("-")
        listOne.size
    } else {
        (this.size / 2)
    }
    val listTwo = this.minus(listOne)
    for (i in 0 until sizeForLoop) {
        if (swapHomeForAway) {
            map.add(Pair(listTwo[i], listOne[i]))
        } else {
            map.add(Pair(listOne[i], listTwo[i]))
        }
    }
    return map
}