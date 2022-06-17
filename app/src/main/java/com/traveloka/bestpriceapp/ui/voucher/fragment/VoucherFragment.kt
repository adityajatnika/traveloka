package com.traveloka.bestpriceapp.ui.voucher.fragment

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveloka.bestpriceapp.databinding.FragmentVoucherBinding
import com.traveloka.bestpriceapp.ui.product.activity.AddProductActivity
import com.traveloka.bestpriceapp.ui.voucher.activity.AddVoucherActivity
import com.traveloka.bestpriceapp.ui.voucher.adapter.ListVoucherAdapter
import com.traveloka.bestpriceapp.ui.voucher.viewmodel.VoucherViewModel

class VoucherFragment : Fragment() {


    private var _binding: FragmentVoucherBinding? = null

    private val binding get() = _binding!!
    private val viewModel: VoucherViewModel by viewModels()
    private val adapter = ListVoucherAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View
    {

        _binding = FragmentVoucherBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpView(){
        showRecyclerList()

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
        }

        viewModel.voucher.observe(viewLifecycleOwner) {
            if(it != null){
                val adapter = ListVoucherAdapter(it)
                binding.rvVoucher.adapter = adapter

            }
        }

        viewModel.stringError.observe(viewLifecycleOwner){
            if(it != null){
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvVoucher.setHasFixedSize(true)
        binding.rvVoucher.adapter = this@VoucherFragment.adapter
        binding.rvVoucher.layoutManager = LinearLayoutManager(requireContext())
        binding.button.setOnClickListener{
            startActivity(Intent(requireContext(), AddVoucherActivity::class.java))
        }
        setUpView()
        viewModel.getListVoucher()
    }

    private fun showRecyclerList() {
        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvVoucher.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvVoucher.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}