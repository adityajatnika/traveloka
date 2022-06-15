package com.traveloka.bestpriceapp.ui.product.fragment

import android.content.Intent
import android.content.res.Configuration
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
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
import com.traveloka.bestpriceapp.data.remote.Product
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.databinding.FragmentProductBinding
import com.traveloka.bestpriceapp.ui.product.activity.AddProductActivity
import com.traveloka.bestpriceapp.ui.product.adapter.ListProductAdapter
import com.traveloka.bestpriceapp.ui.product.viewmodel.ProductViewModel

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by viewModels()
    private val adapter = ListProductAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]
//         val listUser: List<ProductItem>()
//        val adapter = ListProductAdapter(ArrayList<ProductItem>())
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvProduct.setHasFixedSize(true)
        binding.rvProduct.adapter = this@ProductFragment.adapter
        binding.rvProduct.layoutManager = LinearLayoutManager(requireContext())
        binding.btnAdd.setOnClickListener{
            startActivity(Intent(requireContext(), AddProductActivity::class.java))
        }
        setUpView()
        viewModel.getListProduct()
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

        viewModel.products.observe(viewLifecycleOwner) {
            if(it != null){
                val adapter = ListProductAdapter(it)
                binding.rvProduct.adapter = adapter

//                adapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
//                    override fun onItemClicked(data: User) {
//                        showSelectedUser(data)
//                    }
//                })
            }
        }

        viewModel.stringError.observe(viewLifecycleOwner){
            if(it != null){
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showRecyclerList() {
        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvProduct.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}