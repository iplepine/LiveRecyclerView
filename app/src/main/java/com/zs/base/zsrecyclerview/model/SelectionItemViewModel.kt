package com.zs.base.zsrecyclerview.model

import androidx.lifecycle.LiveData
import com.zs.base.zsrecyclerview.ui.common.LiveItemViewEvent
import com.zs.base.zsrecyclerview.ui.common.LiveItemViewModel

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
}
