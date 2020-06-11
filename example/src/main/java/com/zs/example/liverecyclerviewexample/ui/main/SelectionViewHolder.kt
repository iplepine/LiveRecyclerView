package com.zs.example.liverecyclerviewexample.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zs.example.liverecyclerviewexample.BR
import com.zs.example.liverecyclerviewexample.databinding.ItemViewBinding
import com.zs.lib.view.liverecyclerview.LiveViewHolder

class SelectionViewHolder(parent: ViewGroup) : LiveViewHolder(
    ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
) {

    override fun getVariableId(): Int {
        return BR.item
    }
}
