package org.dokge.niven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.dokge.niven.ui.theme.NivenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NivenTheme {
                panelWSheet()
//                MainPanel()
            }
        }
    }
}




@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My preview")
@Composable
fun GreetingPreview() {
    NivenTheme {
        panelWSheet()
//        MainPanel()
    }
}