package com.app.tradesm8.views.fragments.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.app.tradesm8.R
import com.app.tradesm8.databinding.FragmentCategoryBinding
import com.app.tradesm8.models.category.CategoryRepo
import com.app.tradesm8.utilities.common.ItemOffsetDecoration
import com.app.tradesm8.utilities.common.createFactory
import com.app.tradesm8.utilities.common.customToast
import com.app.tradesm8.utilities.common.retrieveUser2
import com.app.tradesm8.utilities.network.RetrofitService
import com.app.tradesm8.viewModels.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val factory = CategoryViewModel(CategoryRepo(RetrofitService(),this)).createFactory()
        val binding : FragmentCategoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_category,container,false)
        categoryViewModel = ViewModelProvider(this,factory).get(CategoryViewModel::class.java)
        categoryViewModel.getCategory(retrieveUser2(activity,"userId")!!,"0")

        recyclerView.layoutManager = GridLayoutManager(activity,2)
        recyclerView.addItemDecoration(ItemOffsetDecoration(2,25,true))

        categoryViewModel.response.observe(this, {
            if (it.statusCode == 200){

                recyclerView.adapter = CategoryAdapter(it.category,activity)

            }
            else {
                activity!!.customToast("Something Went Wrong")
            }
        })

        return binding.root
    }
}