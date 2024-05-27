package com.example.artspace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Rule
import org.junit.Test

class ArtSpaceUiTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun nextArt() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface {
                    ArtSpaceLayout(modifier =  Modifier.fillMaxSize())
                }
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()
        val expectedTitle = "Adios Mocosos"
        val expectedInfo = "Any Artist (2010)"

        composeTestRule.onNodeWithText(expectedTitle).assertExists(
            "No node with this text was found"
        )
        composeTestRule.onNodeWithText(expectedInfo).assertExists(
            "No node with this text was found"
        )

    }

    @Test
    fun previousArt() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface {
                    ArtSpaceLayout(modifier =  Modifier.fillMaxSize())
                }
            }
        }

        composeTestRule.onNodeWithText("Previous").performClick()
        val expectedTitle = "Ahora si viene lo chido"
        val expectedInfo = "Any Artist (2016)"

        composeTestRule.onNodeWithText(expectedTitle).assertExists(
            "No node with this text was found"
        )
        composeTestRule.onNodeWithText(expectedInfo).assertExists(
            "No node with this text was found"
        )

    }

    @Test
    fun nextThreeArts_And_BackTwoArts() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface {
                    ArtSpaceLayout(modifier =  Modifier.fillMaxSize())
                }
            }
        }
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()

        val expectedTitleOne = "Rick and Morty"
        val expectedInfoOne = "Any Artist (2020)"

        composeTestRule.onNodeWithText(expectedTitleOne).assertExists(
            "No node with this text was found"
        )
        composeTestRule.onNodeWithText(expectedInfoOne).assertExists(
            "No node with this text was found"
        )

        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText("Previous").performClick()

        val expectedTitleTwo = "Adios Mocosos"
        val expectedInfoTwo = "Any Artist (2010)"

        composeTestRule.onNodeWithText(expectedTitleTwo).assertExists(
            "No node with this text was found"
        )
        composeTestRule.onNodeWithText(expectedInfoTwo).assertExists(
            "No node with this text was found"
        )

    }
}