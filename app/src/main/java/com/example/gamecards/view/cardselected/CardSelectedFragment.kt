package com.example.gamecards.view.cardselected

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.gamecards.R
import com.example.gamecards.data.domain.model.Card
import com.example.gamecards.databinding.FragmentCardSelectedBinding
import com.example.gamecards.view.util.AlertDialogError
import dagger.hilt.android.AndroidEntryPoint

/**
 * Igor Santos
 * 25/10/2022
 */

@AndroidEntryPoint
class CardSelectedFragment : Fragment() {

    private var _binding: FragmentCardSelectedBinding? = null
    private val binding get() = _binding!!

    private val cardSelectedViewModel: CardSelectedViewModel by viewModels()
    private val args: CardSelectedFragmentArgs by navArgs()

    private lateinit var cardSelectedAdapter: CardSelectedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycle.addObserver(cardSelectedViewModel)
        cardSelectedViewModel.getSelectedCard(args.cardId)
        cardSelectedAdapter = CardSelectedAdapter()
        return FragmentCardSelectedBinding.inflate(inflater, container, false).also {
            _binding = it
            binding.apply {
                viewModel = cardSelectedViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.rvCardSelected.apply {
            adapter = cardSelectedAdapter
        }

        cardSelectedViewModel.apply {
            cardInfos.observe(viewLifecycleOwner){
                cardSelectedAdapter.submitList(it)
            }

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