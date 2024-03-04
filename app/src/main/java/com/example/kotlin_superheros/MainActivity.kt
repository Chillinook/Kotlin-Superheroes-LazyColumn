package com.example.kotlin_superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_superheros.data.Hero
import com.example.kotlin_superheros.data.HeroesRepository.heroes
import com.example.kotlin_superheros.ui.theme.Kotlin_SuperherosTheme

//Name: Sutham Hengsuwan
//ID : 445868
//SODV 3203
//24JANMNTR2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_SuperherosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold(
        topBar = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( 16.dp)
            )
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroCard(
                    hero = it,
                )
            }
        }
    }
}

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = Modifier
            .padding( start = 16.dp , end = 16.dp , bottom = 8.dp)

    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(104.dp)
        ) {
            Column (
                modifier = Modifier
                    .weight(2f)
                    .padding( start= 16.dp , top = 16.dp  )
            ){
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(

                painter =  painterResource(id = hero.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .padding( end = 8.dp , top = 16.dp , bottom = 16.dp )
                    .height(72.dp)
                    .width(72.dp)
                    .clip( RoundedCornerShape( 8.dp))
            )
        }
    }

}