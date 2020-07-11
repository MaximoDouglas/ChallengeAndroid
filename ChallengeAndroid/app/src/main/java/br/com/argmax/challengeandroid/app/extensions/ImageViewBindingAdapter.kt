package br.com.argmax.challengeandroid.app.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.argmax.challengeandroid.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["imageUri"])
    fun ImageView.setImageUri(imageUri: String? = "") {
        Glide.with(context)
            .load(imageUri)
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user)
            .transform(CircleCrop())
            .into(this)
    }

}