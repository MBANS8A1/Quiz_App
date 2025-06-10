package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.FragmentQuestionBinding
import androidx.core.graphics.toColorInt


class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    private var name: String? = null
    val score:Int = 0
    val result = ResultFragment()
    private val bundle = Bundle()
    var currentPosition:Int = 1
    var selectedOption:Int = 0
    private var questionList: ArrayList<QuestionData>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //get name from the HomeFragment
        arguments.let{
            name  = it?.getString("name")
        }
        bundle.putString("name",name)
        questionList = SetData.getQuestion()
        setQuestion()
        binding.option1.setOnClickListener {

        }

    }

    private fun setQuestion() {
        TODO("Not yet implemented")
    }

    private fun selectedOptionStyle(view:TextView,opt:Int){
        optionStyle()
        selectedOption = opt
        view.background=ContextCompat.getDrawable(requireContext(),R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor("#000000".toColorInt())
    }

    private fun optionStyle() {
        val optionList : ArrayList<TextView> = arrayListOf()
        optionList.add(0,binding.option1)
        optionList.add(1,binding.option2)
        optionList.add(2,binding.option3)
        optionList.add(3,binding.option4)
        for(op in optionList){
            op.setTextColor("#555151".toColorInt())
            op.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.question_option
            )
            op.typeface=Typeface.DEFAULT_BOLD
        }
    }

}