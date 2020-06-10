package com.zs.base.zsrecyclerview.ui.main

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.zs.base.zsrecyclerview.model.SelectionItemViewModel
import com.zs.base.zsrecyclerview.ui.common.LiveViewAdapter

class SelectionAdapter(lifecycleOwner: LifecycleOwner) :
    LiveViewAdapter<SelectionItemViewModel, SelectionViewHolder>(lifecycleOwner) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionViewHolder {
        return SelectionViewHolder(parent)
    }
}