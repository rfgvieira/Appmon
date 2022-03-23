package com.example.pokemon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.models.AbilityModel
import com.example.pokemon.R
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.adapter.AbilityAdapter
import com.example.pokemon.databinding.FragmentHabilidadeBinding
import com.example.pokemon.databinding.PopupIdiomaBinding
import com.example.pokemon.viewmodel.PokemonViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
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

        binding.iclButtonIdioma.tvButton.text = getString(R.string.idioma)

        binding.iclButtonIdioma.clButtonredwhite.setOnClickListener {
            popUp()
        }
        return binding.root
    }

    private fun popUp() {
        val popUp = PopupIdiomaBinding.inflate(layoutInflater)
        activity?.let {
            val dialog = BottomSheetDialog(it)
            dialog.setCancelable(true)
            dialog.setContentView(popUp.root)

            popUp.btnEnglish.setOnClickListener {
                setUpAdapter(viewModel.abilityList.value,0)
                dialog.dismiss()
            }

            popUp.btnAlemao.setOnClickListener {
                setUpAdapter(viewModel.abilityList.value,1)
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    private fun initObserver() {
        viewModel.ability.observe(viewLifecycleOwner){
            viewModel.setAbilityList(it)
        }

        viewModel.abilityList.observe(viewLifecycleOwner){
            setUpAdapter(it,0)
        }
    }

    private fun setUpAdapter(list: ArrayList<AbilityModel.Reponse>?, language : Int) {
        binding.rvAbilitylist.adapter = null

        if (list != null) {
            activity?.let {
                binding.rvAbilitylist.adapter = AbilityAdapter(it,list,language)
            }
        }

        binding.rvAbilitylist.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

}