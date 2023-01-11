package com.example.historicheros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.historicheros.model.Place
import com.example.historicheros.model.UserMap
import kotlinx.android.synthetic.main.activity_main.*



const val EXTRA_USER_MAP = "EXTRA_USER_MAP"
const val EXTRA_MAP_TITLE = "EXTRA_MAP_TITLE"

private const val TAG = "MainActivity"
private const val REQUEST_CODE = 1234
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userMaps = generateSampleData()
        //Setting layout manager on recyler view
        rvMaps.layoutManager = LinearLayoutManager(this)

        //Setting adapter on recyler view
        rvMaps.adapter = MapsAdapter(this, userMaps, object: MapsAdapter.OnClickListener{
            override fun onItemClick(position: Int) {
                Log.i(TAG, "onItemClick $position")
                val intent = Intent(this@MainActivity, DisplayMapActivity::class.java)
                intent.putExtra(EXTRA_USER_MAP, userMaps[position])
                startActivity(intent)
            }

        })
    }

    private fun generateSampleData(): List<UserMap> {
        return listOf(
            UserMap(
                "Poets & their Exhibition",
                listOf(
                    Place("National Library of Ireland",
                        "National Library of Ireland has Exhibition related to W.B yeast work",
                        53.341099,
                        -6.254482
                    ),
                )
            ),
            UserMap(
                "National heros & their memories",
                listOf(
                    Place("National Gallery of Ireland",
                        "National Gallery of Ireland houses the national collection of Irish and European art of poets from 15th century.",
                        53.340893,
                        -6.252458
                    )
                )
            ),
            UserMap(
                "Publishers",
                listOf(
                    Place("Trinity College Dublin",
                        "Best place to find work of irish publishers.",
                        53.343792,
                        -6.254572
                    )
                )
            )
        )
    }
}