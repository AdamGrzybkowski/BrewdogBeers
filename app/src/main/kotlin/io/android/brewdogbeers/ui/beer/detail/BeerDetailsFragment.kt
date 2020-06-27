package io.android.brewdogbeers.ui.beer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.api.load
import dagger.android.support.DaggerFragment
import io.android.brewdogbeers.R
import io.android.brewdogbeers.databinding.FragmentBeerBinding

class BeerDetailsFragment : DaggerFragment() {

    private val args by navArgs<BeerDetailsFragmentArgs>()
    private var _binding: FragmentBeerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBeerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val beer = args.beer
        with(binding) {
            beerName.text = beer.name
            beerImage.load(beer.image)
            beerABV.text = getString(R.string.beer_abv, beer.abv)
            beerDescription.text = beer.description
            beerHops.text = beer.hops.joinToString(", ")
            beerMalts.text = beer.malts.joinToString(", ")
            beerMethodMashTemp.text = beer.method.mashTemp.joinToString(", ")
            beerMethodFermentation.text = beer.method.fermentation
            beerMethodTwist.text = beer.method.twist ?: "-"
        }
    }
}
