package com.army.ardiary.config

import android.content.Context
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val context: Context,
) : Authenticator {

    companion object {
        private val TAG = TokenAuthenticator::class.java.simpleName
    }

    override fun authenticate(route: Route?, response: Response): Request? {

        if (response.code == 401) {

            // Refresh token으로 토큰 갱신

            /*val refreshToken = getRefreshJwt(context)
            val getNewDeviceToken = CoroutineScope(Dispatchers.Default).async {
                getNewDeviceToken("refreshToken")
            }

            val token = runBlocking {
                getNewDeviceToken.await()
            }
            return getRequest(response, token)*/
        }
        return null
    }
}