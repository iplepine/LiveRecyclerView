package com.zs.example.liverecyclerviewexample.ui.main

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.zs.example.liverecyclerviewexample.data.Selection
import com.zs.example.liverecyclerviewexample.data.SelectionRepository
import com.zs.lib.view.liverecyclerview.LiveItemViewEvent
import com.zs.lib.view.liverecyclerview.LiveViewModel

class MainViewModel : LiveViewModel() {
    val items = MutableLiveData<ArrayList<SelectionItemViewModel>>()

    var adapter: SelectionAdapter? = null

    init {
        refresh()
    }

    fun refresh() {
        val itemViewModels = SelectionRepository.getItems().map {
            SelectionItemViewModel(it)
        }

        items.value = ArrayList(itemViewModels)
        adapter?.notifyDataSetChanged()
    }

    fun getItemUpdateEvent(): LiveData<LiveItemViewEvent<Selection>> {
        return SelectionRepository.updateEvent
    }

    fun getItemPosition(item: Selection): Int {
        items.value?.forEachIndexed { index, viewModel ->
            if (viewModel.selection == item) {
                return index
            }
        }
        return -1
    }

    fun addMore() {
        val itemViewModels = SelectionRepository.loadMore().map {
            SelectionItemViewModel(it)
        }

        items.value?.addAll(itemViewModels)
        adapter?.notifyDataSetChanged()
    }

    fun onDeleteItem(position: Int) {
        items.value?.removeAt(position)
    }

    fun updateRandomItem() {
        items.value?.random()?.onClickUpdate()
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<SelectionItemViewModel>?) {
    data?.also {
        (recyclerView.adapter as? SelectionAdapter)?.setData(it)
    }
}