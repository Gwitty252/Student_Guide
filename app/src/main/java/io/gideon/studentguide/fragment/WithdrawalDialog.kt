package io.gideon.studentguide.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.gideon.studentguide.R
import io.gideon.studentguide.databinding.FragmentWithdrawalDialogBinding

class WithdrawalDialog : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentWithdrawalDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWithdrawalDialogBinding.inflate(layoutInflater)

        return binding.root
       // return inflater.inflate(R.layout.fragment_withdrawal_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backBtn.setOnClickListener{
            findNavController().navigate(R.id.action_withdrawalDialog_to_ourGuide)
        }

    }

}