package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.internal

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class GlideBinder {
    companion object {
        @BindingAdapter("cardViewImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(backdropPath)
                .into(imageView)
        }

        @BindingAdapter("ticketImage")
        @JvmStatic
        fun loadTicketImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(backdropPath)
                .into(imageView)
        }

        @BindingAdapter("selectorImage")
        @JvmStatic
        fun loadSelectedImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(backdropPath)
                .into(imageView)
        }

        @BindingAdapter("congratulationsImage")
        @JvmStatic
        fun loadCongratulationsImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(backdropPath)
                .into(imageView)
        }

        @BindingAdapter("recipeTicketImage")
        @JvmStatic
        fun loadRecipeTicketImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(backdropPath)
                .into(imageView)
        }

        @BindingAdapter("selectorTicketImage")
        @JvmStatic
        fun loadSelectorTicketImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(backdropPath)
                .into(imageView)
        }
    }
}