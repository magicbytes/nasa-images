package com.example.marsrobots

import com.example.marsrobots.network.MarsImagesResponse

class NasaImagePresenter(
        private val view: NasaImageView,
        private val model: NasaImageModel
) : NasaImageModel.Events {

    init {
        model.eventsListener = this
    }

    fun showImages() {
        view.isErrorVisible = false
        view.isLoadingProgressVisible = true
        model.loadImageUrls()
    }

    override fun onImageSourcesAvailable(imagesResponse: MarsImagesResponse) {
        view.isLoadingProgressVisible = false

        val listItems = imagesResponse.collection.items.map { collectionItem ->
            ImageListItem(collectionItem.data[0].description, collectionItem.data[0].createdDate, collectionItem.links[0].url)
        }

        view.showImages(listItems)
    }

    override fun onErrorOccurred() {
        view.isLoadingProgressVisible = false
        view.isErrorVisible = true
    }
}