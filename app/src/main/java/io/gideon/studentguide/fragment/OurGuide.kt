package io.gideon.studentguide.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.gideon.studentguide.R
import io.gideon.studentguide.databinding.OurGuideBinding

class OurGuide : Fragment(R.layout.our_guide) {
    private lateinit var binding: OurGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OurGuideBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.conditionsForWithdrawal.setOnClickListener {
            findNavController().navigate(R.id.action_ourGuide_to_withdrawalDialog)
        }

        binding.listOfCourses.setOnClickListener {
            findNavController().navigate(R.id.action_ourGuide_to_courseList)
        }
    }
}