package com.rakhee.flicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val webUrl="https://api.themoviedb.org/3/movie/now_playing";
    val webUrlParams="https://api.themoviedb.org/3/movie/now_playing?api-key=69694a19e98df7f5c79b13285d536102"
    val apiKey = "69694a19e98df7f5c79b13285d536102"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client: AsyncHttpClient = AsyncHttpClient()
        val params:RequestParams = RequestParams("api_key",apiKey)

        val jsonResponseHandler:JsonHttpResponseHandler= object: JsonHttpResponseHandler(){

            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                super.onSuccess(statusCode, headers, response)
                println("success")
                println(response.toString())
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                println("faliure_Object "+errorResponse?.toString())
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseString: String?, throwable: Throwable?) {
                super.onFailure(statusCode, headers, responseString, throwable)
                println("faliure_String "+responseString)
            }

        }
        client.get(webUrl,params,jsonResponseHandler)
    }
}