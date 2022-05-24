package com.hdsturkey.yalovabsm404.firstassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hdsturkey.yalovabsm404.firstassignment.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var mBinding: FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSignupBinding.inflate(layoutInflater)
        return mBinding.root
    }

}