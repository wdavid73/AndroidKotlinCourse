package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout(
                        modifier = Modifier
                            .fillMaxSize()

                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var artImage by remember { mutableIntStateOf(R.drawable.img_one) }
    var artTitle by remember { mutableIntStateOf(R.string.rick_and_morty) }
    val artArtist by remember { mutableIntStateOf(R.string.any_artist) }
    var artYear by remember { mutableIntStateOf(R.string.year_2020) }

    var currentStep by remember { mutableIntStateOf(1) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .padding(WindowInsets.statusBars.asPaddingValues())

    ) {
        ArtImage(
                painter = artImage
        )
        Spacer(modifier = Modifier.height(10.dp))
        ArtInformation(
            artTitle = artTitle,
            artArtist = artArtist,
            artYear = artYear
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                          when(currentStep) {
                              1 -> {
                                  currentStep = 3
                                  artImage = R.drawable.img_three
                                  artTitle = R.string.ahora_si_viene_lo_chido
                                  artYear = R.string.year_2016
                              }
                              2 -> {
                                  currentStep = 1
                                  artImage = R.drawable.img_one
                                  artTitle = R.string.rick_and_morty
                                  artYear = R.string.year_2020
                              }
                              else -> {
                                  currentStep = 2
                                  artImage = R.drawable.img_two
                                  artTitle = R.string.adios_mocosos
                                  artYear = R.string.year_2010
                              }
                          }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    when (currentStep) {
                        1 -> {
                            currentStep = 2
                            artImage = R.drawable.img_two
                            artTitle = R.string.adios_mocosos
                            artYear = R.string.year_2010
                        }
                        2 -> {
                            currentStep = 3
                            artImage = R.drawable.img_three
                            artTitle = R.string.ahora_si_viene_lo_chido
                            artYear = R.string.year_2016
                        }
                        3 -> {
                            currentStep = 1
                            artImage = R.drawable.img_one
                            artTitle = R.string.rick_and_morty
                            artYear = R.string.year_2020
                        }
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ArtImage(
    @DrawableRes painter : Int,
) {
    Surface(
        shadowElevation = 10.dp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = null,
            modifier= Modifier.padding(10.dp)
        )
    }
}

@Composable
fun ArtInformation(
    @StringRes artTitle: Int,
    @StringRes artArtist: Int,
    @StringRes artYear: Int,

) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.LightGray)
            .padding(10.dp)

    ){
        Text(
            text = stringResource(id = artTitle),
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "${stringResource(id = artArtist)} (${stringResource(id = artYear)})",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}