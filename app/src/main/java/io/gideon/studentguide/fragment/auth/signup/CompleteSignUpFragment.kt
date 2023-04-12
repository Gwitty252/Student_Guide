package io.gideon.studentguide.fragment.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.gideon.studentguide.data.User
import io.gideon.studentguide.databinding.FragmentCompleteSignUpBinding
import io.gideon.studentguide.viewmodels.RegisterViewModel

class CompleteSignUpFragment : Fragment() {

    private lateinit var binding: FragmentCompleteSignUpBinding
    private val viewModel by viewModels<RegisterViewModel>()
    private lateinit var users: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCompleteSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }

    }

}