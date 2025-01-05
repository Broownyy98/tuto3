package com.example.tuto3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuto3.Recipe

data class Recipe(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int
)
class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipes = listOf(
            Recipe(1, "Black Karaage with Curry Bento", "This Japanese modern izakaya dish features crispy black ka...", R.drawable.black_karage),
            Recipe(2, "Seafood Udon", "A Japanese-style dish that’s quick and easy to prepare...", R.drawable.seafood_udon),
            Recipe(3, "Takoyaki", "Is a Japanese snack that originated in Osaka, Japan. It is a ball-shaped cake..", R.drawable.takoyaki),
            Recipe(4, "Tempura", "Is a popular Japanese dish that consists of seafood, vegetable..", R.drawable.tempura),
            Recipe(5, "Yakitori Shrimp", "Is a Japanese dish that consists of skewered and grilled chicken. However, it..", R.drawable.yakitorishrimp),
            Recipe(6, "Seafood Udon", "A Japanese-style dish that’s quick and easy to prepare..", R.drawable.seafood_udon2)
        )

        val recipesRecyclerView = findViewById<RecyclerView>(R.id.recipeRecyclerView)
        recipesRecyclerView.layoutManager = LinearLayoutManager(this)
        recipesRecyclerView.adapter = Recipe_adapter(this, recipes)
    }
}