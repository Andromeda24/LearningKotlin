package org.ll.lab9.feature.item.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.xr.compose.material3.BasicAlertDialog
import androidx.xr.compose.material3.ExperimentalMaterial3XrApi
import org.ll.lab9.core.database.InventoryDatabase
import org.ll.lab9.feature.item.data.ItemRepositoryImpl
import org.ll.lab9.feature.item.ui.viewmodel.ItemsViewModel

@OptIn(ExperimentalMaterial3XrApi::class)
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
    val detailDialog = rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold (
        floatingActionButton = {
            // A Column to stack the two FloatingActionButtons horizontally
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Spacing between FABs
            ) {
                // Login Button
                FloatingActionButton(
                    onClick = {
                        //detailDialog.value = true
                        itemListViewModel.addItem("a",
                            itemUiState.itemList.size,
                            price = 2.3 * itemUiState.itemList.size )

                    },
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Item"
                        )
                        Text ("Add Item")
                    }

                }
            }
        }
    ){ innerPadding ->



        LazyColumn(
            modifier = modifier.padding(innerPadding)
        ){
            item {
                Text(text = "${itemUiState.itemList.size} items found")
            }
            items(itemUiState.itemList){
                ListItem(headlineContent = {
                    //item title
                    Text(text = it.name)
                },
                    supportingContent = {
                        // other data
                        Text("${it.price}")

                    },
                    trailingContent = {
                        // action icons on the right

                        Row(){
                            Icon(imageVector = Icons.Default.Edit,
                                contentDescription = null,
                                modifier = Modifier.clickable{

                                }
                            )
                            Icon(imageVector = Icons.Default.Delete,
                                contentDescription = null,
                                modifier.clickable{

                                })

                        }
                    })
            }
        }
    }
    if (detailDialog.value) {
        BasicAlertDialog(
            onDismissRequest = { detailDialog.value = false },
        ){
            Surface (
                modifier = Modifier.wrapContentWidth().wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation

            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Add Item")
                    Spacer (modifier = Modifier.height(16.dp))
                    TextButton(
                        onClick = {
                            detailDialog.value = false
                        },
                        modifier = Modifier.align(Alignment.End)

                    ) {
                        Text(text = "Accept")

                    }
                }
            }
        }
    }
}