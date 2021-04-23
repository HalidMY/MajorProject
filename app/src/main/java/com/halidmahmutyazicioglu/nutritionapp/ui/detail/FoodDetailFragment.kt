package com.halidmahmutyazicioglu.nutritionapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.halidmahmutyazicioglu.nutritionapp.R
import com.halidmahmutyazicioglu.nutritionapp.ui.moredetails.MoreDetailBottomSheetFragment

class FoodDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgBack = view.findViewById<ImageView>(R.id.imgBack)

        imgBack.setOnClickListener {
            Navigation.findNavController(imgBack).popBackStack()
        }

        val cardView = view.findViewById<CardView>(R.id.cvMoreDetails)

        cardView.setOnClickListener {
            MoreDetailBottomSheetFragment.newInstance().show(childFragmentManager, "moreDetail")
        }
    }
}