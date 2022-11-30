package com.example.auto
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.auto.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    var imgP: String? = null
    var imgG: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)
        viewModel.loadData()?.let { parsJson(it) }
    }
    private fun parsJson(s: String) {
        var builder: StringBuilder = StringBuilder()
        try {
            var root = JSONObject(s)
            var json: JSONObject = root.getJSONObject("party")
            imgP = json.getString("photoParty")
            imgG=json.getString("photoInviting")
            builder.append("").append(json.getString("nameParty")).append("\n")
            builder.append("").append(json.getString("nameInviting")).append("\n")

            var company: JSONArray = json.getJSONArray("guest")
            for (i in 0 until company.length()) {
                val compan: JSONObject = company.getJSONObject(i)

                builder
                //append(compan.getString("photoGuest")).append(": ")
                    .append(compan.getString("name")).append("\n")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Glide.with(this)
            .load(imgP)
            .into(binding.imgP)
        Glide.with(this)
            .load(imgG)
            .into(binding.imgG)
    }

}