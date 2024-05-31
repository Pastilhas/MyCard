package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCardTheme {
                Scaffold {
                    Surface(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        CardApp()
                    }
                }
            }
        }
    }
}

@Composable
fun Card(
    type: Int, updateType: (Int) -> Unit, modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize(),
    ) {
        Spacer(Modifier)

        Row {
            when (type) {
                0 -> Picture()
                1 -> CodeImage(id = R.drawable.code_whatsapp)
                2 -> CodeImage(id = R.drawable.code_github)
                else -> CodeImage(id = R.drawable.code_linkedin)
            }
        }

        Row(
            modifier = Modifier
                .padding(bottom = 48.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            ContactButton(
                active = (type == 1),
                icon = R.drawable.whatsapp,
                onClick = {
                    when (type) {
                        1 -> updateType(0)
                        else -> updateType(1)
                    }
                },
            )

            ContactButton(
                active = (type == 2),
                icon = R.drawable.github,
                onClick = {
                    when (type) {
                        2 -> updateType(0)
                        else -> updateType(2)
                    }
                },
            )

            ContactButton(
                active = (type == 3),
                icon = R.drawable.linkedin,
                onClick = {
                    when (type) {
                        3 -> updateType(0)
                        else -> updateType(3)
                    }
                },
            )
        }
    }
}

@Composable
fun Picture(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.chapa),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth(0.7f)
                .clip(RoundedCornerShape(16.dp))
        )

        Text(
            text = stringResource(R.string.name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayMedium,
            modifier = modifier.padding(top = 12.dp),
        )

        Text(
            text = stringResource(R.string.title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(top = 6.dp),
        )
    }
}

@Composable
fun CodeImage(@DrawableRes id: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Surface(
            color = MaterialTheme.colorScheme.inverseSurface,
            shape = RoundedCornerShape(16.dp),
            modifier = modifier,
        ) {
            Image(
                painter = painterResource(id),
                contentDescription = "avatar",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseOnSurface),
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .aspectRatio(1f)
            )
        }
    }
}


@Composable
fun ContactButton(
    active: Boolean, @DrawableRes icon: Int, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    val sur = when (active) {
        true -> MaterialTheme.colorScheme.onSecondaryContainer
        else -> MaterialTheme.colorScheme.secondaryContainer
    }

    val img = when (active) {
        true -> MaterialTheme.colorScheme.secondaryContainer
        else -> MaterialTheme.colorScheme.onSecondaryContainer
    }

    Surface(
        color = sur, shape = RoundedCornerShape(16.dp), onClick = onClick, modifier = modifier
    ) {
        Image(
            colorFilter = ColorFilter.tint(img),
            painter = painterResource(id = icon),
            contentDescription = "mobile",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardApp() {
    var type by remember {
        mutableIntStateOf(0)
    }

    Card(type, { type = it })
}