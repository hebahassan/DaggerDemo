package com.example.daggermvvm.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.daggermvvm.R
import com.example.daggermvvm.app.ViewModelProviderFactory
import com.example.daggermvvm.ui.main.MainActivity
import com.example.daggermvvm.util.*
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    @Inject
    lateinit var logo: Drawable
    @Inject
    lateinit var requestManager: RequestManager

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this, providerFactory)[AuthViewModel::class.java]

        observeOnAuthenticationStatus()
        observeUserStatus()

        setLogo()
        login()
    }

    private fun setLogo() {
        requestManager
            .load(logo)
            .into(login_logo)
    }

    private fun login() {
        login_button.setOnClickListener {
            viewModel.getUserInfo(user_id_input.text.toString().toInt())
        }
    }

    private fun observeOnAuthenticationStatus() {
        viewModel.isAuthenticated.observe(this, Observer {
            if(it) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
    }

    private fun observeUserStatus() {
        viewModel.userInfoStatus.observe(this, Observer {
            when(it) {
                is Loading -> progress_bar.showView()

                is Success -> {
                    progress_bar.hideView()
                }

                is Failure -> {
                    progress_bar.hideView()
                    Log.d("User: ", it.error.message ?: "can't reproduce!!")
                }
            }
        })
    }
}
