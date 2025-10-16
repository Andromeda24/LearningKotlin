package org.ll.lab5_2.data

import org.ll.lab5_2.data.AlphabetData
import org.ll.lab5_2.model.ABRepository
import org.ll.lab5_2.model.ABRepositoryImpl

class FakeRepository(
    alphabetData: List<Pair<Char, String>> = listOf(
        'A' to "Alpha",
        'B' to "Beta",
        'C' to "Charlie",
        'D' to "Delta"
    )
//            override fun getAlphabet(): List<Pair<Char, String>> =
//        alphabetData

): ABRepository by ABRepositoryImpl(alphabetData) {



//    override fun getNextAlphabeth(currentAlphabeth: Pair<Char, String>): Pair<Char, String> {
//
//        val currentIndex = alphabetData.indexOf(currentAlphabeth)
//        return alphabetData.get((currentIndex +1)% alphabetData.size)
//    }
}