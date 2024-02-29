package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtAppLayout()
            }
        }
    }
}

@Composable
fun ArtAppLayout() {
    var currStep by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        when (currStep) {
            1 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtPanel(
                        resourceDrawable = R.drawable.macaca_nigra_self_portrait_large,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.macaca_text,
                        artist = R.string.macaca_name,
                        year = R.string.macaca_year
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        onBackwardClick = { currStep = 3 },
                        onForwardClick = { currStep = 2 }
                    )
                }
            }

            2 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtPanel(
                        resourceDrawable = R.drawable.jordan,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.jordan_text,
                        artist = R.string.jordan_name,
                        year = R.string.jordan_year
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        onBackwardClick = { currStep = 1 },
                        onForwardClick = { currStep = 3 })
                }
            }

            3 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtPanel(
                        resourceDrawable = R.drawable.pepe,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.pepe_text,
                        artist = R.string.pepe_name,
                        year = R.string.pepe_year
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        onBackwardClick = { currStep = 2 },
                        onForwardClick = { currStep = 1 })
                }
            }
//
//            4 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art4,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art4_text,
//                        artist = R.string.artist4_name,
//                        year = R.string.art4_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 3 },
//                        onForwardClick = { currStep = 5 })
//                }
//            }
//
//            5 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art5,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art5_text,
//                        artist = R.string.artist5_name,
//                        year = R.string.art5_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 4 },
//                        onForwardClick = { currStep = 6 })
//                }
//            }
//
//            6 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art6,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art6_text,
//                        artist = R.string.artist6_name,
//                        year = R.string.art6_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 5 },
//                        onForwardClick = { currStep = 7 })
//                }
//            }
//
//            7 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art7,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art7_text,
//                        artist = R.string.artist7_name,
//                        year = R.string.art7_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 6 },
//                        onForwardClick = { currStep = 8 })
//                }
//            }
//
//            8 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art8,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art8_text,
//                        artist = R.string.artist8_name,
//                        year = R.string.art8_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 7 },
//                        onForwardClick = { currStep = 9 })
//                }
//            }
//
//            9 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art9,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art9_text,
//                        artist = R.string.artist9_name,
//                        year = R.string.art9_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 8 },
//                        onForwardClick = { currStep = 10 })
//                }
//            }
//
//            10 -> {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp)
//                ) {
//                    ArtPanel(
//                        resourceDrawable = R.drawable.art10,
//                        contentDescription = R.string.art_content_description
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ArtDescription(
//                        title = R.string.art10_text,
//                        artist = R.string.artist10_name,
//                        year = R.string.art10_year
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    ButtonPanel(
//                        onBackwardClick = { currStep = 9 },
//                        onForwardClick = { currStep = 1 })
//                }
//            }

        }
    }
}


@Composable
fun ArtPanel(
    resourceDrawable: Int,
    contentDescription: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        shadowElevation = 10.dp
    ) {
        Image(
            painter = painterResource(
                id = resourceDrawable
            ),
            contentDescription = stringResource(id = contentDescription),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Composable
fun ArtDescription(
    title: Int,
    artist: Int,
    year: Int
) {
    Surface(
        shadowElevation = 20.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(title),
                fontSize = 20.sp
            )
            Column {
                Text(
                    text = stringResource(artist),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(year), fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun ButtonPanel(
    onBackwardClick: () -> Unit,
    onForwardClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = onBackwardClick,
        ) {
            Text(
                text = stringResource(id = R.string.previous_btn_text),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp),
                fontSize = 20.sp,
            )
        }
        Button(
            onClick = onForwardClick,

        ) {
            Text(
                text = stringResource(id = R.string.next_btn_text),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp),
                fontSize = 20.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtAppLayout()
    }
}