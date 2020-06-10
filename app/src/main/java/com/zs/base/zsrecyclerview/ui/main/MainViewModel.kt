package com.zs.base.zsrecyclerview.ui.main

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.zs.base.zsrecyclerview.model.Selection
import com.zs.base.zsrecyclerview.model.SelectionItemViewModel
import com.zs.base.zsrecyclerview.model.SelectionRepository
import com.zs.base.zsrecyclerview.ui.common.LiveItemViewEvent
import com.zs.base.zsrecyclerview.ui.common.LiveViewModel
import io.reactivex.disposables.CompositeDisposable

class MainViewModel : LiveViewModel() {
    val items = MutableLiveData<ArrayList<SelectionItemViewModel>>()

    val compositeDisposable = CompositeDisposable()
    var adapter: SelectionAdapter? = null

    init {
        refresh()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
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