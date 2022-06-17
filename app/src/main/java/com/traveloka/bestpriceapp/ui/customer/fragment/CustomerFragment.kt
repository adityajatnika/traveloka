package com.traveloka.bestpriceapp.ui.customer.fragment

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
import com.traveloka.bestpriceapp.databinding.FragmentCustomerBinding
import com.traveloka.bestpriceapp.ui.customer.adapter.ListCustomerAdapter
import com.traveloka.bestpriceapp.ui.customer.viewmodel.CustomerViewModel

class CustomerFragment : Fragment() {

    private var _binding: FragmentCustomerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: CustomerViewModel by viewModels()
    private val adapter = ListCustomerAdapter(ArrayList())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CustomerViewModel =
            ViewModelProvider(this).get(CustomerViewModel::class.java)
//        val listUser: List<CustomerResponse>
//        val adapter = ListCustomerAdapter(ArrayList<CustomerResponse>())
        _binding = FragmentCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.adapter = this@CustomerFragment.adapter
        binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
        setUpView()
        viewModel.getListCustomer()
    }

    private fun setUpView(){
        showRecyclerlist()

        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.visibility = if (it){
                View.VISIBLE
            }else {
                View.INVISIBLE
            }
        }

        viewModel.customers.observe(viewLifecycleOwner){
            if (it != null){
                val adapter = ListCustomerAdapter(it)
                binding.rvUser.adapter = adapter
            }
        }

        viewModel.stringError.observe(viewLifecycleOwner){
            if (it != null){
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showRecyclerlist() {
        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvUser.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}