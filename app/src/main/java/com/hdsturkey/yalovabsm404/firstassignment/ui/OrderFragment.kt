package com.hdsturkey.yalovabsm404.firstassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hdsturkey.yalovabsm404.firstassignment.databinding.FragmentOrderBinding
import com.hdsturkey.yalovabsm404.firstassignment.util.loadImage


class OrderFragment : Fragment() {
    private lateinit var mBinding: FragmentOrderBinding
    private val args: OrderFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()

    }

    private fun initializeViews() {
        setGreetingMessage()
        setEmailAddress()
        setProfileImage()
    }

    //“Kayıt Ol” ekranından gönderilen kullanıcı adı ve soyadının büyük harflerle gösterilmesi ve “Hoşgeldiniz” yazısı ile birlikte gösterilmesi: 5p
    private fun setGreetingMessage() {
        val incomeUserNameSurname = args.nameSurname
        val upperCasedUserNameSurname = incomeUserNameSurname.uppercase()
        val greetingMessage = "Hoşgeldin $upperCasedUserNameSurname"
        mBinding.tvWelcome.text = greetingMessage
    }

    private fun setEmailAddress() {
        mBinding.tvEmail.text = args.email
    }

    //Glide kütüphanesinin implementasyonu, rastgele bir URL’deki görseli ImageView’da gösterme: 10p
    private fun setProfileImage() {
        val profileUrl = "https://avatars.githubusercontent.com/u/28221219?v=4"
        mBinding.imgProfile.loadImage(profileUrl)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentOrderBinding.inflate(layoutInflater)
        return mBinding.root
    }

}