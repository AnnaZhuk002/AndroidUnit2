package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Composable
fun LemonScreen(
    text: String,
    image: Int,
    contentDescription: Int,
    onClickLambda: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onClickLambda,
            modifier = modifier.border(3.dp, Color(105, 205, 216), RoundedCornerShape(50.dp)),
            shape = RoundedCornerShape(50.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(contentDescription),
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {

    var window: Int by remember {
        mutableStateOf(0)
    }
    var taps: Int by remember {
        mutableStateOf(0)
    }
    var onClickLambda = {
        if ( window == 1 ) {
            taps++
        }

        window += 1
        if (window == 4) {
            window = 0
        }
    }


    Column() {
        Surface (
            color= Color(255, 255, 102),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text= stringResource(R.string.app_name),
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 15.dp),
                fontWeight = FontWeight.Bold
            )

        }
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            when (window) {
                0 -> {
                    LemonScreen(
                        text = stringResource(id = R.string.lemon_tree),
                        image = R.drawable.lemon_tree,
                        contentDescription = R.string.lemonade_tap_to_select,
                        onClickLambda = onClickLambda
                    )
                }
                1 -> {
                    LemonScreen(
                        text = stringResource(id = R.string.lemon),
                        image = R.drawable.lemon_squeeze,
                        contentDescription = R.string.lemonade_keep_tapping,
                        onClickLambda = onClickLambda
                    )
                }
                2 -> {
                    LemonScreen(
                        text = stringResource(id = R.string.glass_of_lemonade),
                        image = R.drawable.lemon_drink,
                        contentDescription = R.string.lemonade_tap_to_drink,
                        onClickLambda = onClickLambda
                    )
                }
                3 -> {
                    LemonScreen(
                        text = stringResource(id = R.string.empty_glass),
                        image = R.drawable.lemon_restart,
                        contentDescription = R.string.lemonade_tap_the_empty,
                        onClickLambda = onClickLambda
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade()
    }
}