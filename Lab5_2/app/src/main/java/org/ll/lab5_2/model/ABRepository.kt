package org.ll.lab5_2.model

interface ABRepository {
    fun getAlphabet(): List<Pair<Char,String>>
    fun getNextAlphabeth(currentAlphabeth: Pair<Char, String>): Pair<Char,String>
}