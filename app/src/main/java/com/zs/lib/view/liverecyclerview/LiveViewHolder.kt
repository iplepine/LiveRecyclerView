package com.zs.lib.view.liverecyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class LiveViewHolder(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun getVariableId(): Int

    fun clear() {
        binding.setVariable(getVariableId(), null)
    }

    fun bind(item: LiveItemViewModel) {
        binding.setVariable(getVariableId(), item)
    }
}