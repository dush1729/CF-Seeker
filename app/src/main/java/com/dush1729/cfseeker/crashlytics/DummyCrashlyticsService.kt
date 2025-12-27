package com.dush1729.cfseeker.crashlytics

import android.util.Log

object DummyCrashlyticsService : CrashlyticsService {
    private const val TAG = "Crashlytics"

    override fun logException(exception: Throwable) {
        Log.e(TAG, "Exception logged", exception)
    }

    override fun log(message: String) {
        Log.d(TAG, message)
    }

    override fun setCustomKey(key: String, value: String) {
        Log.d(TAG, "Custom key: $key = $value")
    }

    override fun setCustomKey(key: String, value: Int) {
        Log.d(TAG, "Custom key: $key = $value")
    }

    override fun setCustomKey(key: String, value: Boolean) {
        Log.d(TAG, "Custom key: $key = $value")
    }
}