package io.gideon.studentguide.fragment

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.gideon.studentguide.R
import io.gideon.studentguide.databinding.FragmentCourseListBinding

class CourseList : Fragment() {
    private lateinit var binding: FragmentCourseListBinding
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
           binding = FragmentCourseListBinding.inflate(layoutInflater)

           return binding.root
        //return inflater.inflate(R.layout.fragment_course_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            dropdown.setOnClickListener {
                if (imgLayoutCollapsable.visibility == View.GONE){
                    TransitionManager.beginDelayedTransition(actionBar,AutoTransition())
                    imgLayoutCollapsable.visibility = View.VISIBLE
                    dropdown.setImageResource(R.drawable.draw_up)
                }else{
                    TransitionManager.beginDelayedTransition(actionBar,AutoTransition())
                    imgLayoutCollapsable.visibility = View.GONE
                    dropdown.setImageResource(R.drawable.dropdown)
                }
            }
            backBtn.setOnClickListener {
                findNavController().navigate(R.id.action_courseList_to_ourGuide)
            }
        }
    }

}