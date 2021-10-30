package com.example.eatyeaty.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eatyeaty.R
import com.example.eatyeaty.repositories.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>) {
    Column(
        Modifier.fillMaxSize()
    ) {
        recipes.forEach {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageWithPlaceholder(
                    image = it.image,
                    placeholder = painterResource(R.drawable.recipe_placeholder)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = it.title,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun RecipeListPreview() {
    RecipeList(
        listOf(
            Recipe(title = "Lasange"),
            Recipe(title = "Pizza"),
        )
    )
}