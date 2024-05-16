package com.example.ssg_tube.presentaion.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ssg_tube.databinding.RvCategoryVideoItemBinding
import com.example.ssg_tube.presentaion.model.DetailModel

class CategoryVideoAdapter(private val items: List<DetailModel>) :
    RecyclerView.Adapter<CategoryVideoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryVideoAdapter.ViewHolder {
        val binding =
            RvCategoryVideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryVideoAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(private val binding: RvCategoryVideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DetailModel) {
            binding.apply {
                Glide.with(ivArea.context)
                    .load(item.thumbnail)
                    .into(ivArea)
                tvTitle.text = item.title
            }

        }
    }
}