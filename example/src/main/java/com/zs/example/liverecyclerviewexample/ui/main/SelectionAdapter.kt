package com.zs.example.liverecyclerviewexample.ui.main

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.zs.lib.view.liverecyclerview.LiveViewAdapter

class SelectionAdapter(lifecycleOwner: LifecycleOwner) :
    LiveViewAdapter<SelectionItemViewModel, SelectionViewHolder>(lifecycleOwner) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionViewHolder {
        return SelectionViewHolder(parent)
    }
}