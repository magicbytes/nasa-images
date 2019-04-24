package com.example.marsrobots

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.marsrobots.adapter.ImagesAdapter
import com.example.marsrobots.network.ApiManager
import com.example.marsrobots.network.MarsImagesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), NasaImageView {

    private lateinit var presenter: NasaImagePresenter

    private lateinit var messageTextView: TextView
    private lateinit var progressBar: View
    private lateinit var retryButton: View
    private lateinit var recyclerView: RecyclerView

    override var isLoadingProgressVisible: Boolean = false
        set(value) {
            field = value

            messageTextView.text = "Loading image information..."
            progressBar.visibility = if (value) View.VISIBLE else View.GONE
        }

    override var isErrorVisible: Boolean = false
        set(value) {
            field = value

            messageTextView.text = "There was an error, please retry"
            retryButton.visibility = if (value) View.VISIBLE else View.GONE
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()

        presenter = NasaImagePresenter(this, NasaImageNetworkModel())
        presenter.showImages()
    }

    override fun showImages(images: List<ImageListItem>) {
        messageTextView.visibility = View.GONE
        recyclerView.adapter = ImagesAdapter(images)
    }


    private fun setupViews() {
        messageTextView = findViewById(R.id.messageTextView)
        progressBar = findViewById(R.id.progressBar)
        retryButton = findViewById(R.id.retryButton)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        retryButton.setOnClickListener { presenter.showImages() }
    }
}
