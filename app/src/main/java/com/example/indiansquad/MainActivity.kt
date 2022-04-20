package com.example.indiansquad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.indiansquad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view);

        val intent = Intent(this, PlayerListActivity::class.java)
        binding.batsmenButton.setOnClickListener {
            intent.putExtra(PlayerListActivity.RESOURCE_ID_EXTRA, "batsmen")
            startActivity(intent);
        }
        binding.allRounderButton.setOnClickListener {
            intent.putExtra(PlayerListActivity.RESOURCE_ID_EXTRA, "allRounder")
            startActivity(intent);
        }
        binding.wicketKeeperButton.setOnClickListener {
            intent.putExtra(PlayerListActivity.RESOURCE_ID_EXTRA, "wicketKeeper")
            startActivity(intent);
        }
        binding.bowlerButton.setOnClickListener {
            intent.putExtra(PlayerListActivity.RESOURCE_ID_EXTRA, "bowler")
            startActivity(intent);
        }
    }
}