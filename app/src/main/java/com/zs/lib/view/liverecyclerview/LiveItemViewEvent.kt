package com.zs.lib.view.liverecyclerview

class LiveItemViewEvent<T>(val type: EventType, val item: T?) {
    enum class EventType {
        SELECT, INSERT, DELETE, UPDATE, REFRESH
    }
}