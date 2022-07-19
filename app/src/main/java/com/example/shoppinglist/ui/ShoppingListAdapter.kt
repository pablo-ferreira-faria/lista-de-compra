package com.example.shoppinglist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.ShoppingList
import com.example.shoppinglist.databinding.ItemShoppingListBinding

class ShoppingListAdapter :
    androidx.recyclerview.widget.ListAdapter<ShoppingList, ShoppingListAdapter.ViewHolder>(Diffcalback()) {

        var ListenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemShoppingListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemShoppingListBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind (item: ShoppingList){
                    binding.tvItem.text = item.item
                    binding.tvQuantidade.text = item.quantidade
                    binding.tvDelete.setOnClickListener()

                }
            }



}
class Diffcalback: DiffUtil.ItemCallback<ShoppingList>(){
    override fun areItemsTheSame(oldItem: ShoppingList, newItem: ShoppingList) = oldItem == newItem

    override fun areContentsTheSame(oldItem: ShoppingList, newItem: ShoppingList) = oldItem.id == newItem.id


}