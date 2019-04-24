package com.example.marsrobots

import com.example.marsrobots.network.ApiManager
import com.example.marsrobots.network.MarsImagesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NasaImageModel {

    var eventsListener: Events?

    fun loadImageUrls()

    interface Events {
        fun onImageSourcesAvailable(imagesResponse: MarsImagesResponse)

        fun onErrorOccurred()
    }
}

/**
 * Provides metadata about the images. It has a cache policy implemented as well - in memory
 */
class NasaImageNetworkModel : NasaImageModel {

    private val cache = MemoryCacheImageMetadata.instance

    override var eventsListener: NasaImageModel.Events? = null

    override fun loadImageUrls() {
        if (cache.hasData && cache.isDataFresh) {
            eventsListener?.onImageSourcesAvailable(cache.imageData)
            return
        }

        ApiManager.service().getListImages().enqueue(object : Callback<MarsImagesResponse> {
            override fun onFailure(call: Call<MarsImagesResponse>, t: Throwable) {
                eventsListener?.onErrorOccurred()
            }

            override fun onResponse(call: Call<MarsImagesResponse>, response: Response<MarsImagesResponse>) {
                val imageResponse = response.body()
                if (imageResponse != null) {
                    cache.update(imageResponse)
                    eventsListener?.onImageSourcesAvailable(imageResponse)
                } else {
                    eventsListener?.onErrorOccurred()
                }
            }
        })
    }
}