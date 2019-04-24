package com.example.marsrobots

/**
 * Describe the contract between Presenter and the View
 */
interface NasaImageView {
    var isLoadingProgressVisible: Boolean

    var isErrorVisible: Boolean

    fun showImages(images: List<ImageListItem>)
}