package com.example.marsrobots.network

import com.google.gson.annotations.SerializedName

/**
 * Contains the list of images and it's metadata. Provided by the API
 */
class MarsImagesResponse(val collection: Collection) {
    companion object {
        fun empty(): MarsImagesResponse {
            return MarsImagesResponse(Collection(emptyList()))
        }
    }
}

/**
 * Contains all the links to the images along with additional information
 */
class Collection(val items: List<CollectionItem>) {

}

/**
 * Represents one single image along with additional information
 */
data class CollectionItem(val data: List<ImageDescription>, val links: List<ImageLink>)


data class ImageDescription(
        val description: String,
        @SerializedName("date_created") val createdDate: String
)

data class ImageLink(@SerializedName("href") val url: String)