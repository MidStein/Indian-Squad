package com.example.indiansquad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.example.indiansquad.databinding.ActivityPlayerDataBinding
import java.util.*

class PlayerDataActivity : AppCompatActivity() {
    companion object {
        const val PLAYER_ID_EXTRA = "playerIdExtra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPlayerDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val rootUrl = "https://cricket.sportmonks.com/api/v2.0/players/"
        val playerId = intent.getStringExtra(PLAYER_ID_EXTRA)
        val apiToken = "?api_token=lDFTsljCJ10SYUyCltMxMuqVZsCnT36dw6D9FLIaiRyHmDCzaEIts4kL9SO0"

        val url = rootUrl + playerId + apiToken
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val datum = response.getJSONObject("data")
                Glide.with(binding.image.context).load(datum.getString("image_path")).into(binding.image)
                val dateofbirth = datum.getString("dateofbirth")
                val birthYear: String = dateofbirth[0].toString() + dateofbirth[1].toString() + dateofbirth[2].toString() + dateofbirth[3].toString()
                val age = Calendar.getInstance().get(Calendar.YEAR) - birthYear.toInt()
                binding.nameAndAge.text = datum.getString("fullname") + ", " + age.toString()
                binding.role.text = datum.getJSONObject("position").getString("name")
                binding.battingStyle.text = "Batting Style: \n" + datum.getString("battingstyle")
                binding.bowlingStyle.text = "Bowling Style: \n" + datum.getString("bowlingstyle")
            }, {})
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}