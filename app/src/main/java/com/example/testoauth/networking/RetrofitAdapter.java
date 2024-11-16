package com.example.testoauth.networking.profile

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface OAuthProfileService {

    companion object {
        const val BASE_URL = "https://oauth-account-noneu.truecaller.com/"
        const val ENDPOINT_FETCH_PROFILE = "v1/userinfo"
        const val HEADER_AUTHORIZATION = "Authorization"
    }

    @GET(ENDPOINT_FETCH_PROFILE)
    fun fetchProfile(
        @Header(HEADER_AUTHORIZATION) accessToken: String
    ): Call<ResponseBody>
}
