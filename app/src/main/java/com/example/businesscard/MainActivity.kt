package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF7cff4d)
                ) {
                    ReadySolution()
                }
            }
        }
    }
}

@Composable
fun ReadySolution(){
    Column(Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        InfoDeveloper()
        Column(
            modifier = Modifier
                .padding()
        ){
            MyLink(
                icon = Icons.Filled.Send,
                text = stringResource(id = R.string.tg_link),
            )
            MyLink(
                icon = Icons.Filled.Email,
                text = stringResource(R.string.email_link)
            )
        }
    }
}

@Composable
fun InfoDeveloper() {
    val img = painterResource(R.drawable.android_logo)
    Image(
        painter = img,
        contentDescription = null,
        colorFilter = ColorFilter.lighting(
            multiply = Color(16777215),
            add = Color(16777215)
        ),
    )
    Text(
        text = stringResource(R.string.name_developer),
        fontSize = 46.sp,
        modifier = Modifier.padding(bottom = 8.dp),
    )
    Text(
        text = stringResource(R.string.job_position),
        fontSize = 24.sp,
        modifier = Modifier.padding(bottom = 8.dp),
    )
}

@Composable
fun MyLink(icon: ImageVector, text: String){
    Row(modifier = Modifier) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(
            text = text,
        )
    }

}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 6750105)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        ReadySolution()
    }
}