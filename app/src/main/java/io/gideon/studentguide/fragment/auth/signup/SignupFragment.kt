package io.gideon.studentguide.fragment.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.gideon.studentguide.R
import io.gideon.studentguide.data.User
import io.gideon.studentguide.databinding.FragmentSignupBinding
import io.gideon.studentguide.viewmodels.RegisterViewModel

@AndroidEntryPoint
class SignupFragment : Fragment(R.layout.fragment_signup) {

    private lateinit var binding: FragmentSignupBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
           continueBtn.setOnClickListener {
//               val user = User(
//                   firstName.text,
//                   surname.text,
//                   enterPhoneNumber.text,
//                   editEmail.text,
//                   enterRegNumber.text,
//                   enterAccessCode.text,
//
//
//               )
               val user = User()
               var accessCode =  enterAccessCode.text.toString()

           }
        }
    }

}