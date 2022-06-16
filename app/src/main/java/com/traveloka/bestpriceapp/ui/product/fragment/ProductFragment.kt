package com.traveloka.bestpriceapp.ui.product.fragment

import android.content.Intent
import android.content.res.Configuration
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.Product
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.databinding.FragmentProductBinding
import com.traveloka.bestpriceapp.ui.product.activity.AddProductActivity
import com.traveloka.bestpriceapp.ui.product.adapter.CategoryProduct
import com.traveloka.bestpriceapp.ui.product.adapter.ListCategoryAdapter
import com.traveloka.bestpriceapp.ui.product.adapter.ListProductAdapter
import com.traveloka.bestpriceapp.ui.product.viewmodel.ProductViewModel

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by viewModels()
    private val adapter = ListProductAdapter(ArrayList())
    private val list = ArrayList<CategoryProduct>()

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
//        val categoryProduct = resources.getStringArray(R.array.product_category_all)
//        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, categoryProduct)
//        binding.edtCategory.setAdapter(arrayAdapter)

        binding.rvProduct.setHasFixedSize(true)
        binding.rvProduct.adapter = this@ProductFragment.adapter
        binding.rvProduct.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.rvCategory.setHasFixedSize(true)
        binding.rvCategory.adapter = this@ProductFragment.adapter
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.btnAdd.setOnClickListener{
            startActivity(Intent(requireContext(), AddProductActivity::class.java))
        }
        list.addAll(listCategory)
        showRecyclerListButton()
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

    private fun showRecyclerListButton(){
        if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val listCategoryAdapter = ListCategoryAdapter(list)
        binding.rvCategory.adapter = listCategoryAdapter

        listCategoryAdapter.setOnItemClickCallback(object : ListCategoryAdapter.OnItemClickCallback {
            override fun onItemClicked(data: CategoryProduct) {
                showSelectedCategory(data)
            }
        })
    }

    private val listCategory: ArrayList<CategoryProduct>
        get() {
            val dataName = resources.getStringArray(R.array.product_category_all)
            val categories = ArrayList<CategoryProduct>()
            for (i in dataName.indices) {
                val category = CategoryProduct(dataName[i])
                categories.add(category)
            }
            return categories
        }

    private fun showSelectedCategory(category: CategoryProduct) {
        val intent = Intent(requireContext(), AddProductActivity::class.java)
//        intent.putExtra(ProfileActivity.EXTRA_USER, user)
        startActivity(intent)
        Toast.makeText(requireContext().applicationContext, "Menampilkan ${category.categoryName}", Toast.LENGTH_SHORT).show()
    }
}