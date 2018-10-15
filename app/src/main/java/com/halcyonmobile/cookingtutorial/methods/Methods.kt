package com.halcyonmobile.cookingtutorial.methods

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.halcyonmobile.cookingtutorial.feature.dish.RecipeActivity

fun getStartIntent(context: Context, className: Class<RecipeActivity>) : Intent {
        return Intent(context,className)
}

fun goToVideo(context: Context, youtubeID: String){
    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$youtubeID")))
}