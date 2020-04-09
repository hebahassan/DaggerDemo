package com.example.daggermvvm.ui.main.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.daggermvvm.R
import com.example.daggermvvm.app.ViewModelProviderFactory
import com.example.daggermvvm.databinding.FragmentPostsBinding
import com.example.daggermvvm.util.*
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostsFragment : DaggerFragment() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var binding: FragmentPostsBinding
    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posts, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, providerFactory)[PostsViewModel::class.java]
        binding.viewModel = viewModel

        observeOnPostsStatus()
    }

    private fun observeOnPostsStatus() {
        viewModel.postsStatus.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Loading -> binding.progressBar.showView()

                is Success -> binding.progressBar.hideView()

                is Failure -> {
                    binding.progressBar.hideView()
                    Log.d("Posts: ", it.error.message ?: "Couldn't find message")
                }
            }
        })
    }
}