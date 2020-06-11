package com.zs.lib.view.liverecyclerview

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import java.lang.ref.WeakReference


abstract class LiveViewAdapter<VM : LiveItemViewModel, T : LiveViewHolder>(lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<T>() {

    private val lifecycleOwner = WeakReference(lifecycleOwner)
    protected var items: List<VM>? = null

    fun setData(data: List<VM>) {
        items = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        val item = items?.get(position)
        if (item == null) {
            holder.clear()
        } else {
            holder.bind(item)
        }
    }

    override fun onViewAttachedToWindow(holder: T) {
        super.onViewAttachedToWindow(holder)
        // 라이프사이클 오우너를 등록해줘야함
        holder.binding.lifecycleOwner = lifecycleOwner.get()
    }

    override fun onViewDetachedFromWindow(holder: T) {
        super.onViewDetachedFromWindow(holder)
        holder.binding.lifecycleOwner = null
    }
}
