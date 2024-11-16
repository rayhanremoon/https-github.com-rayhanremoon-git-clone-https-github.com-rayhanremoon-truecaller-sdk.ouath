package com.example.testoauth.networking.accessToken

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.FormUrlEncoded

interface OAuthAccessTokenService {

    class BaseUrl {
        companion object {
            const val FETCH_ACCESS_TOKEN_BASE_URL = "https://oauth-account-noneu.truecaller.com/"
        }
    }

    class Endpoints {
        companion object {
            const val FETCH_ACCESS_TOKEN = "v1/token"
        }
    }

    @GET("oauth/token")
    fun fetchAccessToken(
        @Query("client_id") clientId: String,
        @Query("app_key") appkey: String,
        @Query("code") authorizationCode: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("code_verifier") codeVerifier: String,
        @Query("grant_type") grantType: String
    ): Call<AccessTokenResponse>

    // Response class to handle access token response
    data class AccessTokenResponse(
        val access_token: String,
        val token_type: String,
        val expires_in: Long,
        val refresh_token: String?
    )
}