import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.utb.megacompapp.PreferenceManager
import com.utb.megacompapp.R
import com.utb.megacompapp.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment() {

    private var _binding: FragmentAboutAppBinding? = null
    private val binding get() = _binding!!

    private lateinit var heartButton: ImageButton
    private lateinit var heartCount: TextView
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAppBinding.inflate(inflater, container, false)
        val root: View = binding.root

        heartButton = root.findViewById(R.id.imageButtonHerat)
        heartCount = root.findViewById(R.id.textViewHeartCounter)

        // Inicializace PreferenceManageru
        preferenceManager = PreferenceManager.getInstance(requireContext())

        // Nastavení stávající hodnoty srdíčka
        heartCount.text = preferenceManager.heartCount.toString()

        heartButton.setOnClickListener {
            incrementHeartCount()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun incrementHeartCount() {
        val currentCount = preferenceManager.heartCount
        val newCount = currentCount + 1

        preferenceManager.heartCount = newCount
        heartCount.text = newCount.toString()
    }
}