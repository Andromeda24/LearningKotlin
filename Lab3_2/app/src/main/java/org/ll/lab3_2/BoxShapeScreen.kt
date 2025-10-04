package org.ll.lab3_2

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@Composable
fun BoxShapeScreen(modifier: Modifier = Modifier) {
    // shape boxes:
    // Draw Boxed with different shapes in a column layout

    // first shape= circle Shape  alinmebt Center
    //second shape = RoubdedCoirner Shape (size = 30) align bottom center
    //3rd align circle toop center
    // 4th cut bordershape

    // and allow scrolling in COl layout

    // all th ealignments defined in the text,a actually applies for the box Content of  the box that contains it
    // the child (ext) inheriths it's parent (Box) modifier
    Scaffold { innerPadding ->
        Column (
            modifier = modifier
             .padding (innerPadding)
                . verticalScroll(state = rememberScrollState())
            ) {
              Box (
                  modifier = Modifier
                      .border (
                          width = 2.dp,
                          color = Color.Red,
                      )
              )
            }
    }

}