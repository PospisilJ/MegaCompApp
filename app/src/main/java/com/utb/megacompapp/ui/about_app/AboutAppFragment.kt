package com.utb.megacompapp.ui.about_app

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.utb.megacompapp.MainActivity
import com.utb.megacompapp.R
import com.utb.megacompapp.databinding.FragmentAboutAppBinding


class AboutAppFragment : Fragment() {

    private var _binding: FragmentAboutAppBinding? = null
    private val binding get() = _binding!!

    private lateinit var heartButton: ImageButton
    private lateinit var heartCount: TextView
    private lateinit var zeroCounterButton: ImageButton

    private lateinit var sharedPreferences: SharedPreferences



    // V companion object
    companion object {
        private const val PREF_NAME = "MyPreferences"
        private const val KEY_HEART_COUNT = "heartCount"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAppBinding.inflate(inflater, container, false)
        val root: View = binding.root



        heartButton = root.findViewById(R.id.imageButtonHeart)
        heartCount = root.findViewById(R.id.textViewHeartCounter)
        zeroCounterButton = root.findViewById(R.id.imageButtonZeroCounter)


        sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        heartCount.text = sharedPreferences.getInt(KEY_HEART_COUNT, 0).toString()

        heartButton.setOnClickListener {
            incrementHeartCount()
        }

        zeroCounterButton.setOnClickListener{
            zeroHeartCount()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun incrementHeartCount() {
        val currentCount = heartCount.text.toString().toInt()
        val newCount = currentCount + 1

        heartCount.text = newCount.toString()

        // Uložení hodnoty do SharedPreferences
        with(sharedPreferences.edit()) {
            putInt(KEY_HEART_COUNT, newCount)
            apply()
        }
    }

    private fun zeroHeartCount(){
        heartCount.text = "0"

        with(sharedPreferences.edit()){
            putInt(KEY_HEART_COUNT, 0)
            apply()
        }
    }
}