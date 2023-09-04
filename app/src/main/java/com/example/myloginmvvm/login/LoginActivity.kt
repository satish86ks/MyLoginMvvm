package com.example.myloginmvvm.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import com.example.myloginmvvm.MainActivity
import com.example.myloginmvvm.R
import com.example.myloginmvvm.databinding.LoginLayoutBinding
import com.example.myloginmvvm.helper.UiUtils
import com.example.myloginmvvm.remote.repository.NavState
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginLayoutBinding
    private lateinit var viewModel: LoginViewModel
    private var syncDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginLayoutBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContentView(binding.root)

        syncDialog = UiUtils.setProgressDialog(this, getString(R.string.loading))
        syncDialog?.setCancelable(false)

        binding.btnLogin.setOnClickListener {
            showLoading()
            var userId = binding.edtUserId.text.toString()
            var password = binding.edtPassword.text.toString()
            viewModel.getLoginDetails(userId, password)
        }

        viewModel.user.observe(this) {

            dismissLoading()

            if (it.data.name.equals("fuchsia rose", true)) {

                val mainIntent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(mainIntent)
                finish()

            }

        }



        viewModel.navigation.observe(this) { state ->

            when (state) {

                is NavState.Loading -> {

                }

                is NavState.Failed -> {
                    dismissLoading()
                    state.let {
                        if (it.message?.contains("ECODE404") == true) {

                        } else if (it.message?.contains("Unauthorized") == true) {

                        } else if (it.message?.contains("Invalid Token") == true) {

                        } else if (it.message?.contains("Socket") == true) {

                            Toast.makeText(this@LoginActivity, "Socket", Toast.LENGTH_LONG).show()

                        } else if (it.message?.contains("NOT FOUND") == true) {

                        } else {

                        }
                    }

                }

                is NavState.Success -> {
                    dismissLoading()
                }

                else -> {}
            }
        }


    }

    private fun showLoading() {
        if (!syncDialog?.isShowing!!) {
            syncDialog?.show()
        }
    }

    private fun dismissLoading() {
        if (syncDialog?.isShowing!!) {
            syncDialog?.dismiss()
        }
    }

}