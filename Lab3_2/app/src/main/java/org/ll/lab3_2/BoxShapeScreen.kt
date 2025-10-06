package org.ll.lab3_2


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxShapeScreen(modifier: Modifier = Modifier) {
    // shape boxes:
    // Draw Boxed with different shapes in a column layout

    // first shape= circle Shape  alinmebt Center
    //second shape = RoubdedCoirner Shape (size = 30) align bottom center
    //3rd align circle toop center
    // 4th cut bordershape

    // and allow scrolling in COl layout

    // all the alignments defined in the text,a actually applies for the box Content of  the box that contains it
    // the child (ext) inheriths it's parent (Box) modifier
    Scaffold { innerPadding ->
        Column (
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(state = rememberScrollState())
            ) {
              Column (
                  modifier = Modifier
                      .border (
                          width = 2.dp,
                          color = Color.Red,
                      )
              ) {
                  MyShape(
                      shape= RectangleShape,
                      text = "Rectangle",
                      Modifier.padding(innerPadding),
                      Color(0xFF005EB8)
                  )
                  MyShape(
                      shape= CircleShape,
                      text = "Circle",
                      Modifier.padding(innerPadding),
                      Color(0xFFFF9100)
                  )
                  MyShape(
                      shape = RoundedCornerShape(10.dp),
                      text = "RoundedCornerShape",
                      Modifier.padding(innerPadding),
                      Color(0xFF2A9723)
                  )
                  MyShape(
                      shape = CutCornerShape(20.dp),
                      text = "CutCornerShape",
                      Modifier.padding(innerPadding),
                      Color(0xFF29A1AF)
                  )
              }
            }
    }

}

@Composable
fun MyShape(shape: Shape, text: String, modifier: Modifier = Modifier, color: Color = Color.White) {
    Box(
        modifier = modifier
            .size(200.dp)
            .border(2.dp, color = Color.DarkGray, shape = shape)
            .clip(shape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}
@Preview  (
    showSystemUi = true
)

@Composable
fun BoxShapeScreenPreview(modifier: Modifier = Modifier) {
  BoxShapeScreen()
}