package com.example.android_instademo.manager.handler

import com.example.android_instademo.model.Post
import java.lang.Exception

interface DBPostHandler {
    fun onSuccess(post: Post)
    fun onError(e: Exception)
}