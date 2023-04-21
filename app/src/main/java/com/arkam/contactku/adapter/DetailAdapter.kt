package com.arkam.contactku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arkam.contactku.databinding.ItemListDetailBinding
import com.arkam.contactku.model.DetailPeople
import kotlinx.android.extensions.LayoutContainer

class DetailAdapter(
    private val detailpeople: List<DetailPeople>,
)
    : RecyclerView.Adapter<DetailAdapter.MainMenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainMenuViewHolder(
            ItemListDetailBinding.inflate(LayoutInflater.from(parent.context),)
        )

    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) {
        holder.binding.tvFirstName.text = detailpeople[position].firstName
        holder.binding.tvLastName.text = detailpeople[position].lastName
        holder.binding.tvEmail.text = detailpeople[position].email
        holder.binding.tvDob.text = detailpeople[position].dob
    }

    override fun getItemCount(): Int {
        return detailpeople.size
    }

    inner class MainMenuViewHolder(
        val binding: ItemListDetailBinding
    ) : RecyclerView.ViewHolder(binding.root), LayoutContainer {
        override val containerView: View?
            get() = itemView

    }

}