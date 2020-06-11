package com.zs.lib.view.liverecyclerview

abstract class LiveRecyclerViewModel : LiveViewModel() {
    abstract fun getItems(): List<LiveItemViewModel>
}
