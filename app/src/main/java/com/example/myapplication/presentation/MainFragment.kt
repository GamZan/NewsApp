package com.example.myapplication.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: FragmentMainBinding

    private val newsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = newsAdapter

        viewModel.getLiveDataObserver().observe(viewLifecycleOwner) {
            if (it != null) {
                newsAdapter.setListNews(it)
                newsAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(
                    requireContext(),
                    "error in getting data from server",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewModel.loadListNews()
    }

}