package com.tbcacademy.examcourses.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbcacademy.examcourses.databinding.ItemCourseTopicsBinding
import com.tbcacademy.examcourses.models.Topic


class ParentAdapter :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val parents = mutableListOf<Topic>()

    private var viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemCourseTopicsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int {
        return parents.size
    }

    fun setData(topic: Topic) {
        this.parents.add(topic)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.nestedChild()
    }


    inner class ViewHolder(private val binding: ItemCourseTopicsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

            val parent = parents[adapterPosition]
            itemView.apply {
                binding.tvTitle.text = parent.type
                binding.tvTextt.text = parent.title

            }


        }

        @SuppressLint("WrongConstant")
        fun nestedChild() {
            itemView.apply {
                val parent = parents[adapterPosition]

                binding.recyclerChild.layoutManager = LinearLayoutManager(
                    binding.recyclerChild.context,
                    LinearLayout.HORIZONTAL,
                    false
                )
                binding.recyclerChild.adapter = ChildAdapter(parent.course)
                //binding.team1ActionRecycler.recycledViewPool = viewPool
                viewPool = binding.recyclerChild.recycledViewPool


            }
        }
    }
}
