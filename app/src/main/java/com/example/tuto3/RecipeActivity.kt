package com.example.tuto3


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RecipeActivity : AppCompatActivity() {
    private val queryFlow = MutableStateFlow("")
    private val _uiState = MutableStateFlow(RecipesUIState(isLoading = false, recipes = emptyList()))
    private val uiState: StateFlow<RecipesUIState> = _uiState.asStateFlow()


    val mockedRecipes = listOf(
        Recipe(1, "Black Karaage with Curry Bento", "This Japanese modern izakaya dish features crispy black ka...", R.drawable.black_karage),
        Recipe(2, "Seafood Udon", "A Japanese-style dish that’s quick and easy to prepare...", R.drawable.seafood_udon),
        Recipe(3, "Takoyaki", "Is a Japanese snack that originated in Osaka, Japan. It is a ball-shaped cake..", R.drawable.takoyaki),
        Recipe(4, "Tempura", "Is a popular Japanese dish that consists of seafood, vegetable..", R.drawable.tempura),
        Recipe(5, "Yakitori Shrimp", "Is a Japanese dish that consists of skewered and grilled chicken. However, it..", R.drawable.yakitorishrimp),
        Recipe(6, "Seafood Udon", "A Japanese-style dish that’s quick and easy to prepare..", R.drawable.seafood_udon2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipesRecyclerView = findViewById<RecyclerView>(R.id.recipeRecyclerView)
        val searchView = findViewById<SearchView>(R.id.searchView)

        recipesRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Recipe_adapter(this, emptyList())
        recipesRecyclerView.adapter = adapter

        lifecycleScope.launch {
            uiState.collect { state ->
                recipesRecyclerView.isVisible = !state.isLoading
                adapter.updateRecipes(state.recipes)
            }
        }
        lifecycleScope.launch {
            queryFlow
                .debounce(300)
                .onEach { _uiState.update { it.copy(isLoading = true) } }
                .onEach { delay(2000) }
                .map { query ->
                    mockedRecipes.filter {
                        it.name.contains(query, ignoreCase = true) ||
                                it.description.contains(query, ignoreCase = true)
                    }
                }
                .collect { filteredRecipes ->
                    _uiState.update { it.copy(isLoading = false, recipes = filteredRecipes) }
                }
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = true

            override fun onQueryTextChange(newText: String?): Boolean {
                queryFlow.value = newText.orEmpty()
                return true
            }
        })
    }
    data class RecipesUIState(
        val isLoading: Boolean,
        val recipes: List<Recipe>
    )
}