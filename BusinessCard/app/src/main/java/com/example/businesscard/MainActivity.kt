package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFd2e8d4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        PersonContent()
        InformationContent()
    }
}

@Composable
fun PersonContent(modifier: Modifier = Modifier) {
    val androidLogo = painterResource(id = R.drawable.android_logo)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = androidLogo,
            contentDescription = "Android Logo",
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .background(color = Color(0xFF073042))
        )
        Text(
            text="Wilson Padilla",
            fontSize = 26.sp,
        )
        Text(
            text="Android Developer Extraordinaire",
            fontSize = 14.sp,
            color = Color(0xFF278053),
            fontWeight = FontWeight.Bold,
        )
    }
}


@Composable
fun InformationContent(modifier: Modifier = Modifier) {
    val spaceVertical = Modifier.height(10.dp)
    val spaceHorizontal = Modifier.width(20.dp)
    Column {
        Row {
            Icon(Icons.Rounded.Call, contentDescription = null, tint = Color(0xFF278053))
            Spacer(modifier = spaceHorizontal)
            Text(text = "+11 (123) 444 555 666")
        }
        Spacer(modifier = spaceVertical)
        Row {
            Icon(Icons.Rounded.Share, contentDescription = null, tint = Color(0xFF278053))
            Spacer(modifier = spaceHorizontal)
            Text(text = "@Guicho73")
        }
        Spacer(modifier = spaceVertical)
        Row {
            Icon(Icons.Rounded.Email, contentDescription = null, tint = Color(0xFF278053))
            Spacer(modifier = spaceHorizontal)
            Text(text = "wilson@padilla.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}