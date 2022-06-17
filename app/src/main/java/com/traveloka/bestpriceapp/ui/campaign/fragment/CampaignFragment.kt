package com.traveloka.bestpriceapp.ui.campaign.fragment

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveloka.bestpriceapp.databinding.FragmentCampaignBinding
import com.traveloka.bestpriceapp.ui.campaign.activity.AddCampaignActivity
import com.traveloka.bestpriceapp.ui.campaign.activity.ForecastActivity
import com.traveloka.bestpriceapp.ui.campaign.adapter.ListCampaignAdapter
import com.traveloka.bestpriceapp.ui.campaign.viewmodel.CampaignViewModel

class CampaignFragment : Fragment() {

    private var _binding: FragmentCampaignBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: CampaignViewModel by viewModels()
    private val adapter = ListCampaignAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CampaignViewModel =
            ViewModelProvider(this).get(CampaignViewModel::class.java)

        _binding = FragmentCampaignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.adapter = this@CampaignFragment.adapter
        binding.rvUser.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        setUpView()
        viewModel.getListCampaign()
        binding.btnAdd1.setOnClickListener{
            startActivity(Intent(requireContext(), AddCampaignActivity::class.java))
        }
        setUpView()
        binding.btnForecast.setOnClickListener {
            startActivity(Intent(requireContext(), ForecastActivity::class.java))
        }
    }

    private fun setUpView(){
        showRecyclerList()

        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.visibility = if (it) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
        }

        viewModel.campaigns.observe(viewLifecycleOwner){
            if (it != null){
                val adapter = ListCampaignAdapter(it)
                binding.rvUser.adapter = adapter
            }
        }

        viewModel.stringError.observe(viewLifecycleOwner){
            if (it != null){
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showRecyclerList(){
        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.rvUser.layoutManager = GridLayoutManager(requireContext(),2)
        }else {
            binding.rvUser.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }
}