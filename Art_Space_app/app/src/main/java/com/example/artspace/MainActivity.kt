package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // - - - Default Code - - -
            /*
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            } */
            // - - - Default Code - - -
            
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp() {
    var currentArt by remember {
        mutableStateOf(1)
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Electronic Arts",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when(currentArt) {
                1 -> {
                    ArtTextImageAndButton(
                        currentArt = currentArt,
                        textLabelResourceId = R.string.robomaster_car_drone_title,
                        textLabelYear = "2017",
                        drawableResourceId = R.drawable.robomaster_car_drone,
                        contentDescriptionResourceId = R.string.robomaster_car_drone_title,
                        onPreviousButtonClick = {
                            if(currentArt > 1) {
                                currentArt--
                            }
                        },
                        onNextButtonClick = {
                            if(currentArt < 6) {
                                currentArt++
                            }
                        })
                }
                2 -> {
                    ArtTextImageAndButton(
                        currentArt = currentArt,
                        textLabelResourceId = R.string.qr_code_title,
                        textLabelYear = "2018",
                        drawableResourceId = R.drawable.qr_code,
                        contentDescriptionResourceId = R.string.qr_code_title,
                        onPreviousButtonClick = {
                                                if(currentArt > 1) {
                                                    currentArt--
                                                }
                        },
                        onNextButtonClick = {
                            if(currentArt < 6) {
                                currentArt++
                            }
                        })
                }
                3 -> {
                    ArtTextImageAndButton(
                        currentArt = currentArt,
                        textLabelResourceId = R.string.arduino_nano_quadcopter_title,
                        textLabelYear = "2019",
                        drawableResourceId = R.drawable.arduino_nano_quadcopter,
                        contentDescriptionResourceId = R.string.arduino_nano_quadcopter_title,
                        onPreviousButtonClick = {
                            if(currentArt > 1) {
                                currentArt--
                            }
                        },
                        onNextButtonClick = {
                            if(currentArt < 6) {
                                currentArt++
                            }
                        })
                }
                4 -> {
                    ArtTextImageAndButton(
                        currentArt = currentArt,
                        textLabelResourceId = R.string.electronic_flower_title,
                        textLabelYear = "2020",
                        drawableResourceId = R.drawable.electronic_flower,
                        contentDescriptionResourceId = R.string.electronic_flower_title,
                        onPreviousButtonClick = {
                            if(currentArt > 1) {
                                currentArt--
                            }
                        },
                        onNextButtonClick = {
                            if(currentArt < 6) {
                                currentArt++
                            }
                        })
                }
                5 -> {
                    ArtTextImageAndButton(
                        currentArt = currentArt,
                        textLabelResourceId = R.string.smart_pocket_printer_title,
                        textLabelYear = "2021",
                        drawableResourceId = R.drawable.smart_pocket_printer,
                        contentDescriptionResourceId = R.string.smart_pocket_printer_title,
                        onPreviousButtonClick = {
                            if(currentArt > 1) {
                                currentArt--
                            }
                        },
                        onNextButtonClick = {
                            if(currentArt < 6) {
                                currentArt++
                            }
                        })
                }
                6 -> {
                    ArtTextImageAndButton(
                        currentArt = currentArt,
                        textLabelResourceId = R.string.tiny_cube_satallite,
                        textLabelYear = "2022",
                        drawableResourceId = R.drawable.tiny_cube_sat,
                        contentDescriptionResourceId = R.string.tiny_cube_satallite,
                        onPreviousButtonClick = {
                            if(currentArt > 1) {
                                currentArt--
                            }
                        },
                        onNextButtonClick = {
                            if(currentArt < 6) {
                                currentArt++
                            }
                        })
                }
            }
        }
    }
}

@Composable
fun ArtTextImageAndButton(
    currentArt: Int,
    textLabelResourceId: Int,
    textLabelYear: String,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onPreviousButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = textLabelYear,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = drawableResourceId), contentDescription = stringResource(
                id = contentDescriptionResourceId
            ))
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onPreviousButtonClick,
                    enabled = currentArt > 1,
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Previous")
                }
                Spacer(modifier = Modifier.width(32.dp))
                Button(
                    onClick = onNextButtonClick,
                    enabled = currentArt < 6,
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Next")
                }
            }
        }
    }
}

// - - - Default code - - -
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Greeting("Android")
    }
}
*/
// - - - Default code - - -


