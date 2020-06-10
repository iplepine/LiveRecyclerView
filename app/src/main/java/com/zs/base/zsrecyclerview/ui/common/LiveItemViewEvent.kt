package com.zs.base.zsrecyclerview.ui.common

class LiveItemViewEvent<T>(val type: EventType, val item: T?) {
    enum class EventType {
        SELECT, INSERT, DELETE, UPDATE, REFRESH
    }
}