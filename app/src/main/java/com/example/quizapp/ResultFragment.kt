package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private var name:String? = null
    private var score:Int? = null
    private var total:Int? = null //added
    private val poorScoreMessage: String? = "You scored poorly"
    private val averageScoreMessage: String? = "Your score is average"
    private val highScoreMessage: String? = "You scored very well"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            name = it.getString("name")
            score = it.getInt("score")
            total = it.getInt("total")
        }
        binding.congTV.text=capitalizeString(name)
        binding.scoreObtainedTV.text=capitalizeString(score.toString().plus("/").plus(total.toString()))
        binding.scoreMessageTV.text = when(score){
            in 0..2 -> poorScoreMessage
            3-> averageScoreMessage
            null -> ""
            else-> highScoreMessage
        }
        binding.finishBtn.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun capitalizeString(str:String?):String?{
        return (str?.replaceFirstChar { it.uppercase() })
    }
}