package com.zs.example.liverecyclerviewexample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zs.example.liverecyclerviewexample.data.Selection
import com.zs.example.liverecyclerviewexample.databinding.MainFragmentBinding
import com.zs.lib.view.liverecyclerview.LiveItemViewEvent
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    private var selectionAdapter: SelectionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        recyclerView.apply {
            selectionAdapter = SelectionAdapter(viewLifecycleOwner)
            adapter = selectionAdapter
            viewModel.adapter = selectionAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.getItemUpdateEvent().observe(viewLifecycleOwner, Observer {
            handleItemUpdateEvent(it)
        })
    }

    private fun handleItemUpdateEvent(event: LiveItemViewEvent<Selection>) {
        when (event.type) {
            LiveItemViewEvent.EventType.SELECT -> {
                Toast.makeText(context, event.item?.text?.value, Toast.LENGTH_SHORT).show()
            }
            LiveItemViewEvent.EventType.DELETE -> {
                event?.item?.also { item ->
                    val position = viewModel.getItemPosition(item)
                    if (position != -1) {
                        viewModel.onDeleteItem(position)
                        selectionAdapter?.notifyItemRemoved(position)
                    }
                }
            }
        }
    }
}