package org.ll.lab5_2.model

import org.ll.lab5_2.data.AlphabetData

class ABRepositoryImpl(
    private val alphabetData: List<Pair<Char,String>>
): ABRepository {
    override fun getAlphabet(): List<Pair<Char, String>> =
        alphabetData


    override fun getNextAlphabeth(currentAlphabeth: Pair<Char, String>): Pair<Char, String> {
        val data = alphabetData
        val currentIndex = data.indexOf(currentAlphabeth)
        return data.get((currentIndex +1)% data.size)
    }
}