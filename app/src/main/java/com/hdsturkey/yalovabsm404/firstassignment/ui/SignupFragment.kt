package com.hdsturkey.yalovabsm404.firstassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hdsturkey.yalovabsm404.firstassignment.databinding.FragmentSignupBinding
import com.hdsturkey.yalovabsm404.firstassignment.util.isValidEmail
import com.hdsturkey.yalovabsm404.firstassignment.util.toast


class SignupFragment : Fragment() {

    private lateinit var mBinding: FragmentSignupBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()

    }

    private fun setListeners() {
        mBinding.btnSignup.setOnClickListener {
            if (isInputsValid()) {
                goNextScreen()
            }
        }
    }

    //Kullanıcıdan alınan veriler için çeşitli validasyonların yapılması: 10p
    //Validasyon kontrolleri sonucunda eğer hata çıkarsa kullanıcıya her hata ile ilgili Toast ile mesaj gösterme: 4p
    private fun isInputsValid(): Boolean {

        if (mBinding.etName.text.isNullOrBlank()) {
            toast("Lütfen adınızı giriniz")
            return false
        }

        if (mBinding.etSurname.text.isNullOrBlank()) {
            toast("Lütfen soyadınızı giriniz")
            return false
        }

        //Email null ve boş olmamalı: 2p
        if (mBinding.etEmail.text.isNullOrBlank()) {
            toast("Lütfen mail adresi giriniz.")
            return false
        }

        //Girilen email adresi doğru formatta olmalı: 2p
        if (mBinding.etEmail.text.toString().isValidEmail().not()) {
            toast("Lütfen doğru formatta bir mail adresi giriniz.")
            return false
        }

        //Şifre null ve boş olmamalı: 2p
        if (mBinding.etPassword.text.isNullOrBlank()) {
            toast("Lütfen şifre giriniz.")
            return false
        }

        //Şifre 8 karakterden az olmamalı: 2p
        if (mBinding.etPassword.text.toString().length < 8) {
            toast("Şifreniz 8 karakterden küçük olamaz.")
            return false
        }

        //Girilen email sadece “xxxx@yalova.edu.tr” türünde olmalı: 2p
        if (mBinding.etEmail.text.toString().contains("@yalova.edu.tr")
                .not()
        ) {    //contains yerine EmailPattern ile de yapılabilir.
            toast("Mail adresiniz yalova.edu.tr içermelidir.")
            return false
        }

        //KVKK ile ilgili checkbox işaretli olmalı: 2p
        if (mBinding.chkKvkk.isChecked.not()) {
            toast("KVKK metnini okuyup onaylamanız gerekmektedir.")
            return false
        }

        return true         // Yukarıdaki hiçbir koşul sağlanmadıysa herşey doğru girilmiş demektir.
    }


    private fun goNextScreen() {
        //todo
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSignupBinding.inflate(layoutInflater)
        return mBinding.root
    }

}