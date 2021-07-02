package com.tbcacademy.examcourses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tbcacademy.examcourses.adapters.ParentAdapter
import com.tbcacademy.examcourses.databinding.AllCoursesFragmentBinding

class AllCoursesFragment : Fragment() {

    private var adapter = ParentAdapter()

    private val viewModel by viewModels<AllCoursesViewModel>()

    private lateinit var binding: AllCoursesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AllCoursesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()

        viewModel._coursesLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            hideProgressBar()

        })

        viewModel.init()
        initRecycler()
    }


    private fun initRecycler() {
        adapter = ParentAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerview.adapter = adapter


    }


    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE

    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE

    }

}