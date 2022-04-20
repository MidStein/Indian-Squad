package com.example.indiansquad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.indiansquad.databinding.ActivityPlayerListBinding

class PlayerListActivity : AppCompatActivity(), IListener {
    private lateinit var binding: ActivityPlayerListBinding;
    companion object {
        const val RESOURCE_ID_EXTRA = "resourceIdExtra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        val view = binding.root;
        setContentView(view)
        val playerCategory = intent.getStringExtra(RESOURCE_ID_EXTRA)
        val imageDrawable: Int
        val items = ArrayList<Player>()
        if (playerCategory.toString().equals("batsmen")) {
            imageDrawable = R.drawable.rohit_sharma
            items.clear()
            items.add(Player(R.drawable.rohit_sharma_face, "Rohit Sharma", "278"))
            items.add(Player(R.drawable.virat_kohli_face, "Virat Kohli", "46"))
            items.add(Player(R.drawable.mayank_agarwal_face, "Mayank Agarwal", "49"))
        }
        else if (playerCategory.toString().equals("allRounder")) {
            imageDrawable = R.drawable.hardik_pandya
            items.clear()
            items.add(Player(R.drawable.hardik_pandya_face, "Hardik Pandya", "281"))
            items.add(Player(R.drawable.kedar_jadhav_face, "Kedar Jadhav", "286"))
            items.add(Player(R.drawable.ravindra_jadeja_face, "Ravindra Jadeja", "55"))
        }
        else if (playerCategory.toString().equals("wicketKeeper")) {
            imageDrawable = R.drawable.ms_dhoni
            items.clear()
            items.add(Player(R.drawable.rishabh_pant_face, "Rishabh Pant", "53"))
            items.add(Player(R.drawable.kl_rahul_face, "KL Rahul", "47"))
            items.add(Player(R.drawable.ms_dhoni_face, "MS Dhoni", "274"))
            items.add(Player(R.drawable.dinesh_karthik_face, "Dinesh Karthik", "275"))
        }
        else {
            imageDrawable = R.drawable.kuldeep_yadav
            items.clear()
            items.add(Player(R.drawable.kuldeep_yadav_face, "Kuldeep Yadav", "56"))
            items.add(Player(R.drawable.mohammed_shami_face, "Mohammed Shami", "57"))
            items.add(Player(R.drawable.jasprit_bumrah_face, "Jasprit Bumrah", "284"))
            items.add(Player(R.drawable.bhuvneshwar_kumar_face, "Bhuvneshwar Kumar", "280"))
            items.add(Player(R.drawable.yuzvendra_chahal_face, "Yuzvendra Chahal", "273"))
        }
        Glide.with(binding.categoryPic.context).load(imageDrawable).into(binding.categoryPic)
        val mAdapter = PlayerListAdapter(this)
        mAdapter.updateList(items)
        binding.recyclerView.adapter = mAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this);
    }

    override fun onItemClicked(item: Player) {
        val intent = Intent(this, PlayerDataActivity::class.java)
        intent.putExtra(PlayerDataActivity.PLAYER_ID_EXTRA, item.playerId)
        startActivity(intent)
    }
}