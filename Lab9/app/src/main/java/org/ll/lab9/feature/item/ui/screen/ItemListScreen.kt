package org.ll.lab9.feature.item.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ll.lab9.core.database.InventoryDatabase
import org.ll.lab9.feature.item.data.ItemRepositoryImpl
import org.ll.lab9.feature.item.ui.uistate.ItemListUiState
import org.ll.lab9.feature.item.ui.viewmodel.ItemsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemListScreen(modifier: Modifier = Modifier) {
// retrieve tne application context
    val context = LocalContext.current
    val applicationContext = context.applicationContext
    val database: InventoryDatabase = remember(applicationContext){
        InventoryDatabase.getDatabase(applicationContext)
    }
    // get dao instance
    val itemDao = remember { database.itemDao()}

    // using DI will avoid all that hardcode
    val itemListViewModel: ItemsViewModel = viewModel{
        ItemsViewModel(itemRepository = ItemRepositoryImpl(itemDao))
    }
    val itemUiState by itemListViewModel.itemUIState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding)
        ){
            items(itemUiState.itemList){
                ListItem(headlineContent = {
                    //item title
                    Text(text = it.name)
                },
                    supportingContent = {
                        // other data
                        Text("$it.price")

                    },
                    trailingContent = {
                        // action icons on the right

                        Row(){
                            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                            Icon(imageVector = Icons.Default.Delete, contentDescription = null)

                        }
                    })
            }
        }
    }
}