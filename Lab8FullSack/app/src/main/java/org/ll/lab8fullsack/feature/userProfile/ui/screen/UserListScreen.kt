package org.ll.lab8fullsack.feature.userProfile.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ll.lab8fullsack.core.network.ApiProvider
import org.ll.lab8fullsack.feature.userProfile.remote.repository.UserRepositoryImpl
import org.ll.lab8fullsack.feature.userProfile.ui.state.UserListUiState
import org.ll.lab8fullsack.feature.userProfile.ui.viewModel.UserListViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen (modifier: Modifier = Modifier) {

        // modifier = modifier.padding(innerPadding)
        val userService = remember {
            ApiProvider.userApiService
        }
        var userListVM: UserListViewModel = viewModel {
            UserListViewModel(
                UserRepositoryImpl(userService)
            )
        }

        var userlistuistate: UserListUiState by userListVM.currentState.collectAsStateWithLifecycle()

        Scaffold(

        ){

            FloatingActionButton (
                onClick = {

                }
            ) {
                // include the icon (requires dependency of material Icons)
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = Color.Green,
                    contentDescription =  "Add"
                )

            }
            LazyColumn (

                modifier = modifier
                    .fillMaxSize()

            ){
                items(userlistuistate.users){
                    Text(text = it.username)
                }
            }

        }

    }



@Preview(
    showSystemUi = true
)
@Composable
fun UserListPreview(){
    UserListScreen()
}