package stan_atilovich.harry_potter_and_retrofit.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import kotlinx.coroutines.launch
import stan_atilovich.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import stan_atilovich.harry_potter_and_retrofit.data.dto.CharacterDto
import stan_atilovich.harry_potter_and_retrofit.databinding.FragmentMainBinding
import stan_atilovich.harry_potter_and_retrofit.domain.model.repository.CharacterRepository

private val TAG = "MainFragment555"
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.character.collect{
                Log.d(TAG,it.toString())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}