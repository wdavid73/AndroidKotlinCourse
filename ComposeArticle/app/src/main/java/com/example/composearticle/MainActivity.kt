package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(modifier: Modifier = Modifier) {
    ArticleCard(
        title = stringResource(R.string.title_jetpack_compose_tutorial),
        shortDescription = stringResource(R.string.compose_short_desc),
        longDescription = stringResource(R.string.compose_long_desc),
        imagePainter = painterResource(id = R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun TaskCompletedScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(painter = image, contentDescription = null)
        Text(
            text = stringResource(R.string.all_tasks_completed),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)){
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title : String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().background(backgroundColor).padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeQuadrantApp()
    }
}