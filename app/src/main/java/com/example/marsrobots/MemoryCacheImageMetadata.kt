package com.example.marsrobots

import com.example.marsrobots.network.MarsImagesResponse
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Keeps information about the metadata regarding images. It has a life of 2 hours.
 */
class MemoryCacheImageMetadata {

    private var lastUpdatedTime: Long = 0
    var imageData: MarsImagesResponse = MarsImagesResponse.empty()
        private set

    val isDataFresh: Boolean
        get() {
            val dataTime = Calendar.getInstance().timeInMillis - lastUpdatedTime
            return dataTime < TimeUnit.HOURS.toMillis(2)
        }

    val hasData: Boolean
        get() = imageData.collection.items.isNotEmpty()


    fun update(newData: MarsImagesResponse) {
        imageData = newData
        lastUpdatedTime = Calendar.getInstance().timeInMillis
    }

    companion object {
        val instance = MemoryCacheImageMetadata()
    }
}