package io.android.brewdogbeers.ui.beer.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import io.android.brewdogbeers.R
import io.android.brewdogbeers.databinding.ItemBeerBinding
import io.android.brewdogbeers.ui.beer.model.Beer

class BeersAdapter(
    val onItemClick: (Beer) -> Unit
) : ListAdapter<Beer, BeersAdapter.BeerViewHolder>(BeerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        return BeerViewHolder(
            ItemBeerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BeerViewHolder(
        private val binding: ItemBeerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: Beer) {
            with(binding) {
                beerName.text = beer.name
                beerABV.text = binding.root.context.getString(R.string.beer_abv, beer.abv)
                beerImage.load(beer.image)
                root.setOnClickListener { onItemClick(beer) }
            }
        }
    }
}
