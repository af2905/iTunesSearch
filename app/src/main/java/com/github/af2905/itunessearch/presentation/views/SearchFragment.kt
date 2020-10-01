package com.github.af2905.itunessearch.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.component.ViewModelComponent
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    var viewModel: SearchViewModel? = null
        @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
    }
}