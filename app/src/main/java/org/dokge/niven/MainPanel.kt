package org.dokge.niven
//
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.filled.Create
//import androidx.compose.material.icons.filled.Done
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.KeyboardType
//import org.dokge.Utils.Niven
//
//@Composable
//fun MainPanel(){
//    var labelText by remember { mutableStateOf("0") }
//
//
//    Surface(modifier = Modifier.fillMaxSize()) {
//
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()){
//            Column {
//                Row {
//
//                    TextField(
//                        value = labelText,
//                        onValueChange = {
//                            labelText = it
//                            ResultIcon = Icons.Default.Create;
//                                        },
//                        label = { Text("Number")},
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//                    )
//                    Icon(imageVector = ResultIcon, contentDescription = "Check for niven")
//
//                }
//                Button(onClick = {
//
//                    if(labelText != "") {
//                        if (Niven.isValid(labelText.toInt())) {
//                            ResultIcon = Icons.Default.Done
//                        } else {
//                            ResultIcon = Icons.Default.Close
//                        }
//                    }
//                    else{
//                        ResultIcon = Icons.Default.Close
//                    }
//                }) {
//                    Text(text = "Check")
//                }
//            }
//        }
//
//    }
//}
//
