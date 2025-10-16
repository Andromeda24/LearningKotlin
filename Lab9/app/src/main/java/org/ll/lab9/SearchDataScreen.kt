package org.ll.lab9

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold

import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDataScreen (modifier: Modifier = Modifier) {
    var  text by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    Scaffold (
        topBar = {
            DockedSearchBar(
                modifier = modifier.padding(top = 50.dp),
                inputField = {
                    SearchBarDefaults.InputField(
                        query = text,
                        onQueryChange = { text = it },
                        onSearch = { expanded = false }, // hide the keyboar when the seearch
                        // buttton un the keyboard is pressed
                        expanded = expanded,// keyBOARD not EXPANDED
                        onExpandedChange = { expanded = it },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        // icon at the left and rigth
                        trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
                        placeholder = { Text(text = "Search Data") },
                    )
                },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                ){
                Text(text = "Search Data")
            }
        }
    )
    { innerPadding ->
        Text(text = "Search Data Screen", modifier = modifier.padding(innerPadding))

    }
    val usaPresidents = listOf(
        "Abraham Lincoln", "George Washington", "Thomas Jefferson", "James Madison",
        "James Monroe", "John Quincy Adams", "Andrew Jackson", "Martin Van Buren",
        "William Henry Harrison", "John Tyler", "James K. Polk", "Zachary Taylor",
        "Millard Fillmore", "Franklin Pierce", "James Buchanan"
    )
//    val filteredPresidents = usaPresidents.filter { it.contains(text, ignoreCase = true) }

}


@Preview(showBackground = true)
@Composable
fun SearchDataScreenPreview (modifier: Modifier = Modifier) {
    SearchDataScreen()
}