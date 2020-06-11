package com.zs.example.liverecyclerviewexample.ui.main

import androidx.lifecycle.LiveData
import com.zs.example.liverecyclerviewexample.data.Selection
import com.zs.example.liverecyclerviewexample.data.SelectionRepository
import com.zs.lib.view.liverecyclerview.LiveItemViewEvent
import com.zs.lib.view.liverecyclerview.LiveItemViewModel

class SelectionItemViewModel(val selection: Selection) : LiveItemViewModel() {

    fun getTitle(): LiveData<String> {
        return selection.title
    }

    fun getText(): LiveData<String> {
        return selection.text
    }

    fun onClickItem() {
        SelectionRepository.updateEvent.value =
            LiveItemViewEvent(LiveItemViewEvent.EventType.SELECT, selection)
    }

    fun onClickDelete() {
        SelectionRepository.updateEvent.value =
            LiveItemViewEvent(LiveItemViewEvent.EventType.DELETE, selection)
    }

    fun onClickUpdate() {
        selection.title.value = selection.title.value + "11"
    }
}
