package com.example.gamecards.view.factionhorde

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gamecards.R
import com.example.gamecards.data.arq.EventObserver
import com.example.gamecards.databinding.FragmentFactionHordeBinding
import com.example.gamecards.view.util.AlertDialogError
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.glide.transformations.BlurTransformation

/**
 * Igor Santos
 * 24/10/2022
 */

@AndroidEntryPoint
class FactionHordeFragment : Fragment() {

    private var _binding: FragmentFactionHordeBinding? = null
    private val binding get() = _binding!!

    private val factionViewModel: FactionHordeViewModel by viewModels()
    private lateinit var factionHordeAdapter: FactionHordeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycle.addObserver(factionViewModel)
        factionHordeAdapter = FactionHordeAdapter(factionViewModel)
        return FragmentFactionHordeBinding.inflate(inflater, container, false).also {
            _binding = it
            binding.apply {
                viewModel = factionViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(R.drawable.background)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
            .into(binding.backgroundContainer)

        binding.rvCards.apply {
            adapter = factionHordeAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        factionViewModel.apply {
            factionHorde.observe(viewLifecycleOwner) { factionHordeAdapter.submitList(it) }

            onSelectCard.observe(viewLifecycleOwner, EventObserver {
                val direction = FactionHordeFragmentDirections.actionCardFragmentToCategorySelectedFragment(it)
                findNavController().navigate(direction)
            })

            error.observe(viewLifecycleOwner) {
                AlertDialogError()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}