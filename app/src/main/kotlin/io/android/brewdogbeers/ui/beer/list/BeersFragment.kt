package io.android.brewdogbeers.ui.beer.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import io.android.brewdogbeers.databinding.FragmentBeersBinding
import io.android.brewdogbeers.ui.base.ViewModelFactory
import io.android.brewdogbeers.ui.beer.model.Beer
import javax.inject.Inject

class BeersFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<BeersViewModel>

    private lateinit var viewModel: BeersViewModel
    private var _binding: FragmentBeersBinding? = null
    private val binding get() = _binding!!
    private val beersAdapter by lazy { BeersAdapter(::onBeerItemClicked) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(BeersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBeersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.beers.adapter = beersAdapter

        viewModel.beers.observe(
            viewLifecycleOwner,
            Observer { beers ->
                beersAdapter.submitList(beers)
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onBeerItemClicked(beer: Beer) {
        findNavController().navigate(BeersFragmentDirections.beersToDetails(beer))
    }
}
