package com.example.quizapp.controller

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {


    private var Name:String?=null
    private var score:Int=0
    private var currentP:Int=1
    private var questionList : ArrayList<QuestionData>? = null
    private var selected:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        SavedData.getQuestion()

        Name=intent.getStringExtra(SavedData.name)

        questionList=SavedData.getQuestion()

        setQuestion()

        option_1.setOnClickListener {
            select(option_1,1)
        }

        option_2.setOnClickListener {
            select(option_2,2)
        }

        option_3.setOnClickListener {
            select(option_3,3)
        }

        option_4.setOnClickListener {
            select(option_4,4)
        }

        submit.setOnClickListener {
            if (selected!=0){
                val question=questionList!![currentP-1]
                if (selected!=question.correct_ans){
                   setColor(selected,R.drawable.wrong)
                }else{
                    score++
                }
                setColor(question.correct_ans,R.drawable.correct)
                if(currentP==questionList!!.size)
                    submit.text="Finish"
                else
                    submit.text="Go to Next"

            }
            else {
                currentP++
                when{
                    currentP<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent=Intent(this,ResultActivity::class.java)
                        intent.putExtra(SavedData.name,Name.toString())
                        intent.putExtra(SavedData.score,score.toString())
                        intent.putExtra("Total Size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selected=0
        }

    }

    fun setColor(option:Int,color: Int){
        when(option){
            1->{
                option_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                option_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                option_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                option_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }
    fun setQuestion(){
        val question = questionList!![currentP-1]
        setoptionstyle()

        progess_bar.progress=currentP
        progess_bar.max=questionList!!.size
        progess_text.text="${currentP}"+"/"+"${progess_bar.max}"
        question_text.text=question.question
        option_1.text=question.option1
        option_2.text=question.option2
        option_3.text=question.option3
        option_4.text=question.option4
    }

    fun setoptionstyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,option_1)
        optionList.add(1,option_2)
        optionList.add(2,option_3)
        optionList.add(3,option_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT

        }
    }

    fun select(view: TextView,option:Int){
        setoptionstyle()

        selected=option
        view.background=ContextCompat.getDrawable(this,R.drawable.selected)
        view.typeface=Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}