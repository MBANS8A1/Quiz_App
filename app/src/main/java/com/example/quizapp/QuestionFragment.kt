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
    var score:Int = 0
    val fragment = ResultFragment()
    private val bundle = Bundle()
    var currentPosition:Int = 1
    var selectedOption:Int = 0
    var questionListSize: Int = 0
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
        questionListSize = questionList!!.size //added
        bundle.putInt("total",questionListSize) //added
        setQuestion()
        binding.option1.setOnClickListener {
            selectedOptionStyle(binding.option1,1)
        }
        binding.option2.setOnClickListener {
            selectedOptionStyle(binding.option2,2)
        }
        binding.option3.setOnClickListener {
            selectedOptionStyle(binding.option3,3)
        }
        binding.option4.setOnClickListener {
            selectedOptionStyle(binding.option4,4)
        }

        binding.submitBtn.setOnClickListener {
            if(selectedOption!=0){
                val question = questionList!![currentPosition-1]
                if(selectedOption!=question.correct_answer){
                    binding.submitBtn.text="submit"
                    setColour(selectedOption,R.drawable.wrong_question_option)
                    setColour(question.correct_answer,R.drawable.correct_question_option)
                }
                else{
                    setColour(selectedOption,R.drawable.correct_question_option)
                    binding.submitBtn.text="Next"
                    score++

                }
                if(currentPosition == questionList!!.size){
                    binding.submitBtn.text="Finish"
                }
                else{
                    binding.submitBtn.text="Next"
                }
            }
            else{
                currentPosition++
                when{ //update the questions
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        bundle.putInt("score",score)
                        fragment.arguments=bundle
                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(R.id.HomeFrame,fragment).addToBackStack(null)
                            .commit()
                    }
                }
            }
            selectedOption = 0
        }
    }

    private fun setColour(opt:Int, colour:Int) {
        when(opt){
            1->{
                binding.option1.background = ContextCompat.getDrawable(requireContext(),colour)
            }
            2->{
                binding.option2.background = ContextCompat.getDrawable(requireContext(),colour)
            }
            3->{
                binding.option3.background = ContextCompat.getDrawable(requireContext(),colour)
            }
            4->{
                binding.option4.background = ContextCompat.getDrawable(requireContext(),colour)
            }
        }
    }

    private fun setQuestion() {
        val question = questionList!![currentPosition-1] //gets to zeroeth position
        optionStyle()
        binding.progressBar.progress =currentPosition
        binding.progressBar.max = questionList!!.size
        binding.progressText.text = "${currentPosition}/${questionList!!.size}"
        binding.questionTV.text = question.question
        binding.option1.text=question.option_one
        binding.option2.text=question.option_two
        binding.option3.text=question.option_three
        binding.option4.text=question.option_four

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