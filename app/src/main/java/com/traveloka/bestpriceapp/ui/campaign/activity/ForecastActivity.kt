package com.traveloka.bestpriceapp.ui.campaign.activity

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.databinding.ActivityAddProductBinding
import com.traveloka.bestpriceapp.databinding.ActivityForecastBinding
import com.traveloka.bestpriceapp.ui.campaign.adapter.ListCampaignForecastAdapter
import com.traveloka.bestpriceapp.ui.campaign.viewmodel.ForecastViewModel
import com.traveloka.bestpriceapp.ui.product.adapter.CategoryProduct
import com.traveloka.bestpriceapp.ui.product.adapter.ListProductAdapter
import com.traveloka.bestpriceapp.ui.product.viewmodel.ProductViewModel

class ForecastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForecastBinding
    private val viewModel: ForecastViewModel by viewModels()
    private val adapter = ListCampaignForecastAdapter(ArrayList())
    private val list = ArrayList<CategoryProduct>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        binding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCampaign.setHasFixedSize(true)
        binding.rvCampaign.adapter = this@ForecastActivity.adapter
        binding.rvCampaign.layoutManager = LinearLayoutManager(applicationContext)

        setUpView()
        viewModel.getCampaigns()

        binding.button.setOnClickListener {
            Toast.makeText(this, "Campaign Active Updated", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            setChart()
            Toast.makeText(this, "Forecasting Success", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setUpView(){
        showRecyclerList()

        viewModel.isLoading.observe(this) {
            binding.progressBar.visibility = if (it) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
        }

        viewModel.campaigns.observe(this) {
            if(it != null){
                val adapter = ListCampaignForecastAdapter(it)
                binding.rvCampaign.adapter = adapter

//                adapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
//                    override fun onItemClicked(data: User) {
//                        showSelectedUser(data)
//                    }
//                })
            }
        }

        viewModel.stringError.observe(this){
            if(it != null){
                Toast.makeText(baseContext, it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvCampaign.layoutManager = GridLayoutManager(applicationContext, 2)

        } else {
            binding.rvCampaign.layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    private fun setChart() {
        val kasus = ArrayList<Entry>()
        kasus.add(Entry(0F, 67F))
        kasus.add(Entry(1F, 11F))
        kasus.add(Entry(2F, 11F))
        kasus.add(Entry(3F, 67F))
        kasus.add(Entry(4F, 41F))
        kasus.add(Entry(5F, 79F))
        kasus.add(Entry(6F, 28F))
        kasus.add(Entry(7F, 18F))
        kasus.add(Entry(8F, 28F))
        kasus.add(Entry(9F, 12F))
        kasus.add(Entry(10F, 12F))
        kasus.add(Entry(11F, 19F))
        kasus.add(Entry(12F, 13F))
        kasus.add(Entry(13F, 11F))
        kasus.add(Entry(14F, 12F))

//        val sembuh = ArrayList<Entry>()
//        sembuh.add(Entry(0F, 22F))
//        sembuh.add(Entry(1F, 9F))
//        sembuh.add(Entry(2F, 22F))
//        sembuh.add(Entry(3F, 16F))
//        sembuh.add(Entry(4F, 14F))
//        sembuh.add(Entry(5F, 28F))
//        sembuh.add(Entry(6F, 12F))
//        sembuh.add(Entry(7F, 18F))
//        sembuh.add(Entry(8F, 30F))
//        sembuh.add(Entry(9F, 30F))
//
//        val meninggal = ArrayList<Entry>()
//        meninggal.add(Entry(0F, 21F))
//        meninggal.add(Entry(1F, 13F))
//        meninggal.add(Entry(2F, 11F))
//        meninggal.add(Entry(3F, 10F))
//        meninggal.add(Entry(4F, 7F))
//        meninggal.add(Entry(5F, 11F))
//        meninggal.add(Entry(6F, 12F))
//        meninggal.add(Entry(7F, 19F))
//        meninggal.add(Entry(8F, 40F))
//        meninggal.add(Entry(9F, 26F))

        val kasusLineDataSet = LineDataSet(kasus, "Kasus")
        kasusLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        kasusLineDataSet.color = Color.BLUE
        kasusLineDataSet.circleRadius = 5f
        kasusLineDataSet.setCircleColor(Color.BLUE)

//        val sembuhLineDataSet = LineDataSet(sembuh, "Sembuh")
//        sembuhLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
//        sembuhLineDataSet.color = Color.GREEN
//        sembuhLineDataSet.circleRadius = 5f
//        sembuhLineDataSet.setCircleColor(Color.GREEN)
//
//        val meninggalLineDataSet = LineDataSet(meninggal, "Meninggal")
//        meninggalLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
//        meninggalLineDataSet.color = Color.RED
//        meninggalLineDataSet.circleRadius = 5f
//        meninggalLineDataSet.setCircleColor(Color.RED)

//Setup Legend
        val legend = binding.lineChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.setDrawInside(false)

        binding.apply {
            lineChart.description.isEnabled = false
            lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
            lineChart.data = LineData(kasusLineDataSet)
            lineChart.animateXY(100, 500)
        }
    }

    private fun showSelectedCategory(category: CategoryProduct) {
//        val intent = Intent(requireContext(), AddProductActivity::class.java)
////        intent.putExtra(ProfileActivity.EXTRA_USER, user)
//        startActivity(intent)
        Toast.makeText(applicationContext, "Menampilkan ${category.categoryName}", Toast.LENGTH_SHORT).show()
//        viewModel.getListProductSearch(category.categoryName)
    }
}