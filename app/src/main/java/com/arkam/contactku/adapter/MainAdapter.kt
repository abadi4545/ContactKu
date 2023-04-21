package com.arkam.contactku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arkam.contactku.databinding.ItemListContactBinding
import com.arkam.contactku.model.People
import kotlinx.android.extensions.LayoutContainer

class MainAdapter(
    private val people: List<People>,
)
    : RecyclerView.Adapter<MainAdapter.MainMenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainMenuViewHolder(
            ItemListContactBinding.inflate(LayoutInflater.from(parent.context),)
        )

    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) {
        holder.binding.tvFirst.text = people[position].firstName
        holder.binding.tvLast.text = people[position].lastName
    }

    override fun getItemCount(): Int {
       return people.size
    }

    inner class MainMenuViewHolder(
        val binding: ItemListContactBinding
    ) : RecyclerView.ViewHolder(binding.root), LayoutContainer {
        override val containerView: View?
            get() = itemView

    }

}