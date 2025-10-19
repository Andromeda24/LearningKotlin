package org.ll.lab11aiimage.feature.ai.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ll.lab11aiimage.core.ai.GenerativeModelService
import org.ll.lab11aiimage.feature.ai.data.repository.ImageRepositoryImpl
import org.ll.lab11aiimage.feature.ai.ui.viewmodel.ImageGenViewModel

@Composable
fun
        ImageDisplayScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column (
            modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            val myViewModel : ImageGenViewModel = viewModel{
                ImageGenViewModel(ImageRepositoryImpl(
                    GenerativeModelService.getImageGenModel()
                ))
        }
            val myState by myViewModel.currentState.collectAsStateWithLifecycle()

            OutlinedTextField(
                value = myState.prompt,
                onValueChange = { myViewModel.onPromptChange(it) },
//                value = "",
//                onValueChange = {},

                label = { Text("Prompt") }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = {
                    myViewModel.generateImage()
                }
            ) {
                Text("Generate Image")
            }
            Spacer(modifier = Modifier.padding(8.dp))


            when {
                myState.isLoading -> {
                    LinearProgressIndicator()
                }
                myState.myImages.isNotEmpty() -> {
                    LazyColumn {
                        items(myState.myImages) {
                            Image(
                                bitmap = it.asImageBitmap(),
                                contentDescription = "Generated Image"
                            )
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }

    }
}

@Preview()
@Composable
fun ScreenPreview(modifier: Modifier = Modifier) {
    ImageDisplayScreen()
}