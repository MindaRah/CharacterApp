package com.minda.mycharactersapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.minda.mycharactersapp.adapter.CharacterAdapter
import com.minda.mycharactersapp.databinding.FragmentCharacterBinding
import com.minda.mycharactersapp.util.UIState
import dagger.hilt.EntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PeopleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class CharacterFragment : BaseFragment() {
    private val binding by lazy {
        FragmentCharacterBinding.inflate(layoutInflater)
    }
    private val characterAdapter by lazy {
        CharacterAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        observeData()
        return binding.root
    }
    private fun initRecyclerView(){
        binding.peopleRecVw.apply{
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = characterAdapter
        }
    }

    private fun observeData(){
        characterViewModel.characters.observe(viewLifecycleOwner){state ->
            when(state){
                is UIState.LOADING ->{

                }
                is UIState.SUCCESS -> {
                    characterAdapter.setCharacter(state.response.results.toMutableList())
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage){
                    }
                }
                else -> {}
            }
        }
        characterViewModel.getCharacter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.let {
            null
        }
    }
}