package com.halidmahmutyazicioglu.nutritionapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.halidmahmutyazicioglu.nutritionapp.R
import com.halidmahmutyazicioglu.nutritionapp.ui.home.model.Food

class RecommendedFoodAdapter(private val foodList: List<Food>) :
    RecyclerView.Adapter<RecommendedFoodAdapter.FoodViewHolder>() {
    override fun getItemCount() = foodList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val foodView = inflater.inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(foodView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentFood = foodList[position]
        holder.tvTitle.text = currentFood.title
        holder.tvDescription.text = currentFood.description
        holder.tvCalories.text = "${currentFood.calories} Caloires"
        holder.imgFood.setImageResource(currentFood.imageId)
        holder.itemView.setOnClickListener {
            Navigation.findNavController(holder.itemView).navigate(R.id.action_navigation_home_to_foodDetailFragment)
        }
//        Glide
//            .with(holder.imgFood)
//            .load(currentFood.imageUrl)
//            .centerCrop()
//            .into(holder.imgFood)
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFood = itemView.findViewById<ImageView>(R.id.imgFood)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvCalories = itemView.findViewById<TextView>(R.id.tvCalories)
    }
}