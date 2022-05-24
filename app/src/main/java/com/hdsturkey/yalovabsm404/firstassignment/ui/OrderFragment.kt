package com.hdsturkey.yalovabsm404.firstassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hdsturkey.yalovabsm404.firstassignment.databinding.FragmentOrderBinding


class OrderFragment : Fragment() {
    private lateinit var mBinding: FragmentOrderBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentOrderBinding.inflate(layoutInflater)
        return mBinding.root
    }

}