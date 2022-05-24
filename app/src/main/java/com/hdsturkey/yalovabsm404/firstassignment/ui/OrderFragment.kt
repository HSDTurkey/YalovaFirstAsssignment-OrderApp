package com.hdsturkey.yalovabsm404.firstassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hdsturkey.yalovabsm404.firstassignment.R
import com.hdsturkey.yalovabsm404.firstassignment.databinding.FragmentOrderBinding
import com.hdsturkey.yalovabsm404.firstassignment.util.loadImage
import com.hdsturkey.yalovabsm404.firstassignment.util.show
import com.hdsturkey.yalovabsm404.firstassignment.util.toast


class OrderFragment : Fragment() {
    private lateinit var mBinding: FragmentOrderBinding
    private val args: OrderFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        setListeners()
    }

    private fun setListeners() {
        mBinding.btnCalculate.setOnClickListener {
            if (isOrdersOptionSelected()) {
                val orderCost = calculateOrderCost()
                setOrderCost(orderCost)
            }
        }
    }


    //2 yemek türünden herhangi birisi için opsiyon seçilmediyse ücretin hesaplanmaması gerekir. Ayrıca kullanıcıya Toast ile uyarı mesajı gösterilmesi: 8p
    private fun isOrdersOptionSelected(): Boolean {
        val NO_SELECTED_RADIO_BUTTON = -1

        if (mBinding.firstOrderOptions.checkedRadioButtonId == NO_SELECTED_RADIO_BUTTON) {
            toast("Lütfen birinci menüden bir opsiyon seçiniz")
            return false
        }

        if (mBinding.secondOrderOptions.checkedRadioButtonId == NO_SELECTED_RADIO_BUTTON) {
            toast("Lütfen ikinci menüden bir opsiyon seçiniz")
            return false
        }

        return true
    }

    //Her yemeğin 3 adet opsiyon var, kullanıcının seçtiği opsiyonlara göre ücretin hesaplanması: 12p
    private fun calculateOrderCost(): Int {
        var orderCost = 0
        orderCost += getFirstOrderCost()
        orderCost += getSecondOrderCost()
        return orderCost
    }

    private fun getFirstOrderCost(): Int {
        return when (mBinding.firstOrderOptions.checkedRadioButtonId) {
            R.id.first_small -> 10
            R.id.first_medium -> 20
            R.id.first_big -> 30
            else -> -999999
        }
    }

    private fun getSecondOrderCost(): Int {
        return when (mBinding.secondOrderOptions.checkedRadioButtonId) {
            R.id.second_small -> 7
            R.id.second_medium -> 13
            R.id.second_big -> 33
            else -> -999999
        }
    }

    private fun setOrderCost(orderCost: Int) {
        mBinding.tvCost.text = "Ödemeniz gereken ücret $orderCost ₺"
        mBinding.tvCost.show()      //Ücretin gösterildiği TextView’in hesaplama süreci başladıktan sonra görünür olması: 5p
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