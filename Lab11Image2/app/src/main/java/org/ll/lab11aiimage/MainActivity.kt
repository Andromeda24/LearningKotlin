package org.ll.lab11aiimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.ll.lab11aiimage.feature.ai.ui.screen.ImageDisplayScreen
import org.ll.lab11image2.ui.theme.Lab11Image2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab11Image2Theme {
                ImageDisplayScreen()
            }
        }
    }
}