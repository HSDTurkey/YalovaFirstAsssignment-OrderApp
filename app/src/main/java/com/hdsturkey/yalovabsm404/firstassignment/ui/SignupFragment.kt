package com.hdsturkey.yalovabsm404.firstassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hdsturkey.yalovabsm404.firstassignment.databinding.FragmentSignupBinding
import com.hdsturkey.yalovabsm404.firstassignment.util.hideKeyboard
import com.hdsturkey.yalovabsm404.firstassignment.util.isValidEmail
import com.hdsturkey.yalovabsm404.firstassignment.util.showKeyboard
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
            mBinding.etName.showKeyboard()
            return false
        }

        if (mBinding.etSurname.text.isNullOrBlank()) {
            toast("Lütfen soyadınızı giriniz")
            mBinding.etSurname.showKeyboard()
            return false
        }

        //Email null ve boş olmamalı: 2p
        if (mBinding.etEmail.text.isNullOrBlank()) {
            toast("Lütfen mail adresi giriniz.")
            mBinding.etEmail.showKeyboard()
            return false
        }

        //Girilen email adresi doğru formatta olmalı: 2p
        if (mBinding.etEmail.text.toString().isValidEmail().not()) {
            toast("Lütfen doğru formatta bir mail adresi giriniz.")
            mBinding.etEmail.showKeyboard()
            return false
        }

        //Şifre null ve boş olmamalı: 2p
        if (mBinding.etPassword.text.isNullOrBlank()) {
            toast("Lütfen şifre giriniz.")
            mBinding.etPassword.showKeyboard()
            return false
        }

        //Şifre 8 karakterden az olmamalı: 2p
        if (mBinding.etPassword.text.toString().length < 8) {
            toast("Şifreniz 8 karakterden küçük olamaz.")
            mBinding.etPassword.showKeyboard()
            return false
        }

        //Girilen email sadece “xxxx@yalova.edu.tr” türünde olmalı: 2p
        if (mBinding.etEmail.text.toString().contains("@yalova.edu.tr")
                .not()
        ) {    //contains yerine EmailPattern ile de yapılabilir.
            toast("Mail adresiniz yalova.edu.tr içermelidir.")
            mBinding.etEmail.showKeyboard()
            return false
        }

        hideKeyboard()

        //KVKK ile ilgili checkbox işaretli olmalı: 2p
        if (mBinding.chkKvkk.isChecked.not()) {
            toast("KVKK metnini okuyup onaylamanız gerekmektedir.")
            return false
        }

        return true         // Yukarıdaki hiçbir koşul sağlanmadıysa herşey doğru girilmiş demektir.
    }


    //Kullanıcı Adı ve Soyadının “Sipariş” sayfasına gönderilmesi: 2p
    //“Sipariş” sayfasına geçiş: 2p
    private fun goNextScreen() {
        val userNameSurname = mBinding.etName.text.toString() + " " + mBinding.etSurname.text.toString()
        val email = mBinding.etEmail.text.toString()
        //Fragment ve Navigation Component yapısını kullanırken veri gönderiminde “Safe Args” kullanılması (Bonus %3)
        val action = SignupFragmentDirections.actionSignupFragmentToOrderFragment(userNameSurname, email)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSignupBinding.inflate(layoutInflater)
        return mBinding.root
    }

}