package io.gideon.studentguide.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.gideon.studentguide.R
import io.gideon.studentguide.databinding.OurGuideBinding

class RegisterFragment:Fragment(R.layout.our_guide) {
    private  lateinit var binding: OurGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OurGuideBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}