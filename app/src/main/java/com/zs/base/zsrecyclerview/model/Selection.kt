package com.zs.base.zsrecyclerview.model

import androidx.lifecycle.MutableLiveData

class Selection(title: String, text: String) {
    var title = MutableLiveData(title)
    var text = MutableLiveData(text)
}