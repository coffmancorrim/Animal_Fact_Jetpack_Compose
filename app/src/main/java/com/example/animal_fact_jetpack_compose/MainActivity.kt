package com.example.animal_fact_jetpack_compose

import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.animal_fact_jetpack_compose.model.Animal
import com.example.animal_fact_jetpack_compose.ui.theme.Animal_Fact_Jetpack_ComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.random.Random

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Animal_Fact_Jetpack_ComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    color = MaterialTheme.colors.background
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Yellow)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        animalList()
                    }
                }
            }
        }
    }
}

private fun createAnimal(species: String, type: String, fact: String, image: String, size: Int, weight: Int
) = Animal(
    species = species,
    type = type,
    fact = fact,
    image = image,
    size = size,
    weight = weight,
)

@Composable
fun animalList(){
    val animals = mutableListOf<Animal>()

    val speciesList = listOf<String>(
        "Dolphin",
        "Pistol Shrimp",
        "Garden Snail",
        "Giant Pacific Octopus",
        "Polar Bear",
        "Japanese Macaques",
        "Koala",
        "Shoebill Stork",
        "Syrian Brown Bear",
        "Horned Lizard"
    )
    val typeList = listOf<String>(
        "mammal",
        "bird",
        "fish"
    )
    val factList = listOf<Int>(
        R.string.dolphin_fact,
        R.string.pistol_shrimp_Fact,
        R.string.garden_snail_fact,
        R.string.giant_pacific_octopus_fact,
        R.string.polar_bear_fact,
        R.string.japanese_macaques_fact,
        R.string.koala_fact,
        R.string.shoebill_stork_fact,
        R.string.syrian_brown_bear,
        R.string.horned_lizard_fact
    )

    val imageList = listOf<String>(
        "https://drive.google.com/uc?id=1UxA0ybSATM9pqcp8JZH8ZokWCX5v_l_h",
        "https://drive.google.com/uc?id=1QzXENpHjKVk6NiU37IhNIb6MZ076sTL_",
        "https://drive.google.com/uc?id=18NRWIh-VtHzzH2hmYjAFOyHmKR8HhiqS",
        "https://drive.google.com/uc?id=1dkaa2YiDhEA5wDLdrURofH6_MsLAP-7O",
        "https://drive.google.com/uc?id=10qm2mnPR0TgbMwNvHWcumobvZbt9dKV5",
        "https://drive.google.com/uc?id=1H0UbuCW3ZNpKCRZyc_XxXO8wKI5CPF2F",
        "https://drive.google.com/uc?id=1o9JWVpxzwI6BMy9vvNJJKxF0Jmm3CYb0",
        "https://drive.google.com/uc?id=1yAp9eUFXm1S2wlb0ZcK6MWMHsh6cBOlj",
        "https://drive.google.com/uc?id=1dBGsOwV_NBsv0wUL65djx-QX-q5UadcZ",
        "https://drive.google.com/uc?id=1GPDmlyJa9ugFe063dyBXKi1LlVRMj1VU"
    )

    for (i in 0..30) {
        animals.add(
            createAnimal(
                speciesList.random(),
                typeList.random(),
                stringResource(factList.random()),
                imageList.random(),
                Random.nextInt(0, 15),
                Random.nextInt(0, 455),
            )
        )
    }

    LazyColumn{
        items(animals) { animal ->
            animalCard(animal)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun animalCard(animal: Animal, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .padding(16.dp) //this is margin
            .background(Color.White)
            .wrapContentWidth()
            //.padding(16.dp) //this is padding,
                ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.Start
        ) {
            GlideImage(model = animal.image, contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally))
            Text(text = animal.species, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = animal.type, fontStyle = FontStyle.Italic, modifier = Modifier.background(Color.Magenta), fontSize = 20.sp)
            Text(text = "Animal Fact: " + animal.fact, fontSize = 20.sp)
            Text(text = "Weight: " + animal.weight.toString(), fontSize = 20.sp)
            Text(text = "Size: " + animal.size.toString(), fontSize = 20.sp)
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAnimalCard(){
    animalCard(animal = Animal("Dolphin", "fish", "the leorenaonfdsalfnkklasdfnlaskdjf laskjdslk fsldkajflaksjfoamd ldksajfeawo fdsalkjf pewaojf ldsakjf ldsakjf psdaf jpdsakjf a", "placeholder",267, 11))
}