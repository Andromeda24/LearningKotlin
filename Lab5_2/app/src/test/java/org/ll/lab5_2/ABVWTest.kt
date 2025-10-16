package org.ll.lab5_2

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.ll.lab5_2.data.FakeRepository
import org.ll.lab5_2.ui.ABEViewModel

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ABVWTest {
    private lateinit var  ABviewModel :ABEViewModel

    @Before
    fun setup(){
        ABviewModel = ABEViewModel(FakeRepository())
    }
    @Test
    fun testInitielUIState() {
        val currentState = ABviewModel.currentState.value
        assertEquals(currentState.alphabet, 'A')
        assertEquals(currentState.word, "Alpha")
        assert(!currentState.isCompleted)

    }

    @Test
    fun testNextUIState() {
        repeat (2){
            ABviewModel.nextAlphabet()
        }
        val currentState = ABviewModel.currentState.value
        assertEquals(currentState.alphabet, 'C')
        assertEquals(currentState.word, "Charlie")
        assert(!currentState.isCompleted)

    }
}