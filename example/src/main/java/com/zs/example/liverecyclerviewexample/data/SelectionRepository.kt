package com.zs.example.liverecyclerviewexample.data

import androidx.lifecycle.MutableLiveData
import com.zs.lib.view.liverecyclerview.LiveItemViewEvent

object SelectionRepository {
    val updateEvent = MutableLiveData<LiveItemViewEvent<Selection>>()

    val selections = arrayOf("일번", "이번", "삼번", "사범", "5번")

    fun getItems(): List<Selection> {
        return ArrayList(selections.asList().shuffled().map {
            Selection("타이틀", it)
        })
    }

    fun loadMore(): List<Selection> {
        return ArrayList(selections.asList().shuffled().map {
            Selection("타이틀", it)
        })
    }
}