package io.android.brewdogbeers.ui.beer.list

import androidx.recyclerview.widget.DiffUtil
import io.android.brewdogbeers.ui.beer.model.Beer

class BeerDiffCallback : DiffUtil.ItemCallback<Beer>() {

    override fun areItemsTheSame(oldItem: Beer, newItem: Beer) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Beer, newItem: Beer) = oldItem == newItem
}
