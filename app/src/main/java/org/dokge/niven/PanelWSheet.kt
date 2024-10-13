package org.dokge.niven

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.dokge.niven.ui.theme.LightGreen
import org.dokge.niven.ui.theme.LightRed
import org.dokge.niven.ui.theme.PurpleGrey40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun panelWSheet(){
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
//    val hideModalBottomSheet: () -> Unit = { scope.launch { sheetState.hide() }}
    var showBottomSheet by remember { mutableStateOf(false) }
    var fromNumber by remember { mutableStateOf("0") }
    var toNumber by remember { mutableStateOf("10") }


    Scaffold(

        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Edit") },
                icon = { Icon(Icons.Filled.Create, contentDescription = "") },
                onClick = {
                    scope.launch {
                        showBottomSheet = true
                        sheetState.show()
                    }
                }
            )
        },
        modifier = Modifier.background(Color.Red)
    ) { contentPadding ->
        // Screen content
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)){
            LazyColumn {
                item {
                    NivenCard("123", true)
                }
                items(20){ index ->
                    NivenCard("1")
                }
            }

        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxHeight(.5f)
                    .fillMaxWidth(1.0f)

            ) {
                Box() {

                    // Sheet content
                    Column(modifier = Modifier
                        .fillMaxWidth(1.0f)
                        .fillMaxHeight()) {
                        Column(modifier = Modifier.fillMaxHeight(0.6f)) {
                            TextField(
                                value = fromNumber,
                                onValueChange = { fromNumber = it },
                                label = { Text("From") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


                            )
                            TextField(
                                value = toNumber,
                                onValueChange = { toNumber = it },
                                label = { Text("to") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(1.0f)
                                .fillMaxHeight(0.4f)

                        ) {
                            FilledButtonInstance(
                                onClick = {
                                    scope.launch {
                                        sheetState.hide()
                                        delay(100L)
                                        showBottomSheet = false
                                    }
                                    var fromNumINT = fromNumber.toInt()
                                    var toNumINT = toNumber.toInt()
                                    val job = scope.launch {

                                    }



                                },
                                content = {
                                    Row {
                                        Icon(Icons.Filled.Search, contentDescription = "")
                                        Text("start searching")
                                    }
                                },
                                modifier = Modifier.fillMaxWidth(0.5f)
                            )
                            TonalButtonInstance(
                                onClick = {

                                },
                                content = {
                                    Row {
                                        Icon(Icons.Filled.Delete, contentDescription = "")
                                        Text("delete log")
                                    }
                                },
                                modifier = Modifier
                            )
                        }

                        Text(
                            text = "Damir Ospanov ASB-23E1",
                            modifier = Modifier
                                .fillMaxWidth(1.0f)


                        )
                    }


                }
            }
        }
    }




}

@Composable
fun TonalButtonInstance(onClick: () -> Unit, content: @Composable () -> Unit, modifier: Modifier = Modifier){
    FilledTonalButton(onClick = { onClick() }, modifier = modifier) {
        content()
    }
}


@Composable
fun FilledButtonInstance(onClick: () -> Unit, content: @Composable () -> Unit, modifier: Modifier = Modifier){
    Button(onClick = { onClick() }, modifier = modifier) {
        content()
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My preview")
@Composable
fun PreviewMy(){
    panelWSheet()
}
@Composable
fun NivenCard(number: String, isNivenB: Boolean = false){
    Box(Modifier
        .clip(shape = RoundedCornerShape(35.dp))
        .fillMaxWidth()
        .height(70.dp)
        .padding(2.dp)
        .background(color = if(isNivenB) {LightGreen} else {LightRed})
        ,
        contentAlignment = Alignment.CenterStart){
                Text(number, fontSize = 20.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(5.dp).offset(35.dp,0.dp))
    }
}
