package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(inflater,container,false)
        return binding.root
    }

}