package com.example.cian.screens.newAd

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cian.models.PostState

class NewAdViewModel : ViewModel() {

    var postId = ""

    private var _postState = MutableLiveData(PostState.NOTHING)
    val postState: LiveData<PostState>
        get() = _postState

    fun updatePostState(state: PostState) {
        _postState.value = state
    }

    private var _imagesUris = MutableLiveData(HashMap<Uri, Boolean>())
    val imagesUris: LiveData<HashMap<Uri, Boolean>>
        get() = _imagesUris

    fun updateImagesUris(uri: Uri, value: Boolean) {
        _imagesUris.value?.set(uri, value)
        _imagesUris.notifyObserver()
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }

    fun clear() {
        _imagesUris.value = HashMap()
        _postState.value = PostState.NOTHING
    }

}