package com.seoleo.slovaruzru.ui.toruslat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import com.seoleo.slovaruzru.databinding.FragmentToRusLatBinding
import com.seoleo.slovaruzru.ui.adapter.DictionaryAdapter
import kotlinx.coroutines.launch

class ToRusLatFragment : Fragment() {

    private var _binding: FragmentToRusLatBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: DictionaryAdapter
    private lateinit var viewModel: ToRusLatViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewModel = ViewModelProvider(this).get(ToRusLatViewModel::class.java)
        _binding = FragmentToRusLatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        setUpRecyclerView()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dictionariesStateFlow.collect {
                    Log.d(TAG, "onViewCreated: repeatOnLifecycle(Lifecycle.State.STARTED)")
                    adapter.updateList(it,)
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        adapter = DictionaryAdapter(
            dictionaryClicked = {dictionaryModel ->
                viewModel.dictionaryClicked(dictionaryModel)
            }
        )
        binding.dictionaryRecyclerView.adapter = adapter
        binding.dictionaryRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "ToRusLatFragment"

    }
}