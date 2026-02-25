package com.dush1729.cfseeker.platform

import platform.Foundation.NSBundle

actual val appVersionName: String =
    NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleShortVersionString") as? String ?: "Unknown"

actual val isIos: Boolean = true
