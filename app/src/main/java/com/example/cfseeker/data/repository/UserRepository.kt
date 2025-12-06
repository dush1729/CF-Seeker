package com.example.cfseeker.data.repository

import com.example.cfseeker.data.remote.api.NetworkService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val service: NetworkService,
) {


}