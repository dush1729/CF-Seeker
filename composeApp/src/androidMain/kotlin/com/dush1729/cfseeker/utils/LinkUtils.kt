package com.dush1729.cfseeker.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

/**
 * Opens a URL in the default browser
 */
fun openUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(intent)
    } catch (e: Exception) {
        Firebase.crashlytics.recordException(e)
        Firebase.crashlytics.setCustomKey("url", url)
        Firebase.crashlytics.log("LinkUtils: Failed to open URL: $url - ${e.message}")
    }
}

/**
 * Opens the app's Play Store page
 */
fun openPlayStore(context: Context, packageName: String = "com.dush1729.cfseeker") {
    try {
        // Try to open in Play Store app first
        val intent = Intent(Intent.ACTION_VIEW, "market://details?id=$packageName".toUri())
        context.startActivity(intent)
    } catch (e: Exception) {
        // Fallback to browser if Play Store app is not available
        openUrl(context, "https://play.google.com/store/apps/details?id=$packageName")
    }
}
