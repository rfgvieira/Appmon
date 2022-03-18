package com.example.pokemon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.models.AbilityModel
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.adapter.AbilityAdapter
import com.example.pokemon.databinding.FragmentHabilidadeBinding
import com.example.pokemon.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HabilidadeFragment : Fragment() {

    private lateinit var binding : FragmentHabilidadeBinding
    private val viewModel : PokemonViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as PokemonActivity).removePokeball()
        (activity as PokemonActivity).removeText()
        (activity as PokemonActivity).hideRedBall()
        (activity as PokemonActivity).redBackground()

        viewModel.getAbility()
        initObserver()

        binding = FragmentHabilidadeBinding.inflate(inflater, container, false)
        binding.iclAbilityFragTitle.imvBackarrow.setOnClickListener {
            (activity as PokemonActivity).onBackPressed()
        }
        return binding.root
    }

    private fun initObserver() {
        viewModel.ability.observe(viewLifecycleOwner){
            viewModel.setAbilityList(it)
        }

        viewModel.abilityList.observe(viewLifecycleOwner){
            setUpAdapter(it)
        }
    }

    private fun setUpAdapter(list: ArrayList<AbilityModel.Reponse>?) {
        binding.rvAbilitylist.adapter = null

        if (list != null) {
            activity?.let {
                binding.rvAbilitylist.adapter = AbilityAdapter(it,list)
            }
        }

        binding.rvAbilitylist.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

}