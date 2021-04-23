package com.halidmahmutyazicioglu.nutritionapp.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.halidmahmutyazicioglu.nutritionapp.R
import com.halidmahmutyazicioglu.nutritionapp.ui.home.model.Food

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecommendedFoods(view)
        setOtherFoods(view)
    }

    private fun setOtherFoods(view: View) {
        val otherFoodRecyclerView = view.findViewById<RecyclerView>(R.id.rvOtherFoods)

        val otherFoods = listOf(
            OtherFood(
                name = "Fruits",
                dishes = 150,
                imageId = "\uD83C\uDF4A",
                color = "#FECA97"
            ),
            OtherFood(
                name = "Vegetables",
                dishes = 34,
                imageId = "\uD83E\uDD6C",
                color = "#9FF0AD"
            ),
            OtherFood(
                name = "Fishes",
                dishes = 43,
                imageId = "\uD83D\uDC1F",
                color = "#18E4D6"
            ),
            OtherFood(
                name = "Meat",
                dishes = 122,
                imageId = "\uD83E\uDD69",
                color = "#FFCCC8"
            )
        )
        otherFoodRecyclerView.adapter = OtherFoodAdapter(otherFoods)
    }

    private fun setRecommendedFoods(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvRecommendedFoods)
        val foods = listOf(
            Food(
                imageUrl = "https://image.pngaaa.com/325/269325-middle.png",
                imageId = R.drawable.food1,
                title = "Good for breakfast",
                description = "Salad with complete vegetable topping",
                calories = 9
            ),
            Food(
                imageUrl = "https://www.vhv.rs/dpng/d/437-4373805_skinny-slow-cooker-food-plate-top-view-png.png",
                imageId = R.drawable.food2,
                title = "Good for diet",
                description = "Chicken with complete vegetable topping",
                calories = 200
            ),
            Food(
                imageUrl = "https://image.pngaaa.com/325/269325-middle.png",
                imageId = R.drawable.food1,
                title = "Good for breakfast",
                description = "Salad with complete vegetable topping",
                calories = 9
            ),
            Food(
                imageUrl = "https://www.vhv.rs/dpng/d/437-4373805_skinny-slow-cooker-food-plate-top-view-png.png",
                imageId = R.drawable.food2,
                title = "Good for diet",
                description = "Chicken with complete vegetable topping",
                calories = 200
            )
        )
        recyclerView.adapter = RecommendedFoodAdapter(foods)
    }
}

data class OtherFood(
    val imageId: String,
    val name: String,
    val dishes: Int,
    val color: String
)

class OtherFoodAdapter(private val otherFoods: List<OtherFood>) :
    RecyclerView.Adapter<OtherFoodAdapter.OtherFoodViewHolder>() {

    override fun getItemCount(): Int {
        return otherFoods.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherFoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val otherFoodView = inflater.inflate(R.layout.item_other_food, parent, false)
        return OtherFoodViewHolder(otherFoodView)
    }

    override fun onBindViewHolder(holder: OtherFoodViewHolder, position: Int) {
        val currentOtherFood = otherFoods[position]

        holder.tvOtherFoodTitle.text = currentOtherFood.name
        holder.tvOtherFoodDishes.text = "${currentOtherFood.dishes} Dishes"
        holder.tvOtherFoodEmoji.text = currentOtherFood.imageId
        holder.cvOtherFood.setCardBackgroundColor(Color.parseColor(currentOtherFood.color))
        holder.tvOtherFoodEmoji.setOnClickListener {
            Navigation.findNavController(holder.itemView)
                .navigate(R.id.action_navigation_home_to_foodDetailFragment)
        }
    }

    class OtherFoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvOtherFoodEmoji = itemView.findViewById<TextView>(R.id.tvOtherFoodEmoji)
        val tvOtherFoodTitle = itemView.findViewById<TextView>(R.id.tvOtherFoodTitle)
        val tvOtherFoodDishes = itemView.findViewById<TextView>(R.id.tvOtherFoodDishes)
        val cvOtherFood = itemView.findViewById<CardView>(R.id.cvOtherFood)
    }
}