package com.example.quizapp.controller

data class QuestionData (
    var question:String,
    var id:Int,
    var option1:String,
    var option2:String,
    var option3:String,
    var option4:String,
    var correct_ans:Int
        )