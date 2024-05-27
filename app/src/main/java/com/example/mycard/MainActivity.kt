package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCardTheme {
                Surface(
                    Modifier.fillMaxSize()
                ) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier.weight(1f),
        ) {

        }

        Row(
            modifier.weight(1f),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.chapa),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )

                Text(
                    text = "João Campos",
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(top = 12.dp),
                )

                Text(
                    text = "Software Engineer",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = modifier.padding(top = 6.dp),
                )
            }
        }

        Row(
            modifier.weight(1f),
            verticalAlignment = Alignment.Bottom,
        ) {
            Column(
                modifier = modifier.padding(bottom = 48.dp)
            ) {
                Contact(contact = "937 588 691", id = R.drawable.telephone)
                Contact(contact = "Pastilhas", id = R.drawable.github)
                Contact(contact = "jp-campos", id = R.drawable.linkedin)
            }
        }
    }
}

@Composable
fun Contact(contact: String, id: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id),
            contentDescription = "phone",
            modifier = modifier.size(24.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground),
        )

        Text(
            text = contact,
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            modifier = modifier.padding(start = 12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCardTheme {
        Page()
    }
}