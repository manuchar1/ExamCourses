package com.tbcacademy.examcourses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbcacademy.examcourses.databinding.ItemCourseBinding
import com.tbcacademy.examcourses.models.Course


class ChildAdapter(private val children: List<Course>) :
    RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemCourseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = children.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()


    }


    inner class ViewHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val child = children[adapterPosition]
            itemView.apply {

                Glide.with(this).load(child.image).into(binding.ivLogo)
                binding.progressBar.progress = child.precent.toInt()
                binding.tvBookingTime.text = child.title


            }

        }

    }
}
