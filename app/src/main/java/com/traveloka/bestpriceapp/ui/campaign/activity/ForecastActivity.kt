package com.traveloka.bestpriceapp.ui.campaign.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.databinding.ActivityAddProductBinding
import com.traveloka.bestpriceapp.databinding.ActivityForecastBinding

class ForecastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForecastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        binding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setChart()
    }

    private fun setChart() {
        val kasus = ArrayList<Entry>()
        kasus.add(Entry(0F, 149F))
        kasus.add(Entry(1F, 113F))
        kasus.add(Entry(2F, 196F))
        kasus.add(Entry(3F, 106F))
        kasus.add(Entry(4F, 181F))
        kasus.add(Entry(5F, 218F))
        kasus.add(Entry(6F, 247F))
        kasus.add(Entry(7F, 218F))
        kasus.add(Entry(8F, 337F))
        kasus.add(Entry(9F, 219F))

        val sembuh = ArrayList<Entry>()
        sembuh.add(Entry(0F, 22F))
        sembuh.add(Entry(1F, 9F))
        sembuh.add(Entry(2F, 22F))
        sembuh.add(Entry(3F, 16F))
        sembuh.add(Entry(4F, 14F))
        sembuh.add(Entry(5F, 28F))
        sembuh.add(Entry(6F, 12F))
        sembuh.add(Entry(7F, 18F))
        sembuh.add(Entry(8F, 30F))
        sembuh.add(Entry(9F, 30F))

        val meninggal = ArrayList<Entry>()
        meninggal.add(Entry(0F, 21F))
        meninggal.add(Entry(1F, 13F))
        meninggal.add(Entry(2F, 11F))
        meninggal.add(Entry(3F, 10F))
        meninggal.add(Entry(4F, 7F))
        meninggal.add(Entry(5F, 11F))
        meninggal.add(Entry(6F, 12F))
        meninggal.add(Entry(7F, 19F))
        meninggal.add(Entry(8F, 40F))
        meninggal.add(Entry(9F, 26F))

        val kasusLineDataSet = LineDataSet(kasus, "Kasus")
        kasusLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        kasusLineDataSet.color = Color.BLUE
        kasusLineDataSet.circleRadius = 5f
        kasusLineDataSet.setCircleColor(Color.BLUE)

        val sembuhLineDataSet = LineDataSet(sembuh, "Sembuh")
        sembuhLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        sembuhLineDataSet.color = Color.GREEN
        sembuhLineDataSet.circleRadius = 5f
        sembuhLineDataSet.setCircleColor(Color.GREEN)

        val meninggalLineDataSet = LineDataSet(meninggal, "Meninggal")
        meninggalLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        meninggalLineDataSet.color = Color.RED
        meninggalLineDataSet.circleRadius = 5f
        meninggalLineDataSet.setCircleColor(Color.RED)

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
            lineChart.data = LineData(kasusLineDataSet, sembuhLineDataSet, meninggalLineDataSet)
            lineChart.animateXY(100, 500)
        }
    }
}