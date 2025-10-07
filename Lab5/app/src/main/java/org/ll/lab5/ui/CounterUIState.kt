package org.ll.lab5.ui

data class CounterUIState ( // it was created as DATA CLASS
    // UIState is inmutable (val) to get a new state , the view Model creates a new UIState
    val count:Int = 0,
    val isLoading:Boolean = false,
    val errorMessage: String? = null
)