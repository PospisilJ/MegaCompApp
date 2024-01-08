package com.utb.megacompapp.ui.about_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.utb.megacompapp.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment() {

    private var _binding: FragmentAboutAppBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutAppViewModel =
            ViewModelProvider(this).get(AboutAppViewModel::class.java)

        _binding = FragmentAboutAppBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//        aboutAppViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}