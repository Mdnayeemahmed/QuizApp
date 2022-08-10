package com.example.quizapp.controller

object SavedData {
    const val name:String="name"
    const val score:String="0"
    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1=QuestionData(
            "What is the captial of Bangladesh",
            1,
            "Dhaka",
            "Chittagong",
            "Barishal",
            "none of above",
            1

        )
        var q2=QuestionData(
            "How many total Districts are there in Bangladesh",
            2,
            "60",
            "61",
            "63",
            "64",
            4

        )
        var q3=QuestionData(
            "National game of Bangladesh is",
            3,
            "Cricket",
            "Football",
            "Kabadi",
            "Hockey",
            3

        )
        var q4=QuestionData(
            "Which of following river is longest in Bangladesh",
            4,
            "Padma",
            "Surma",
            "Meghna",
            "none of above",
            2

        )
        var q5=QuestionData(
            "Who is the first president of Bangladesh",
            5,
            "Ziaur Rahman",
            "Abdus sattar",
            "Taj Uddin",
            "Sheikh Mujibur Rahman",
            4

        )
        var q6=QuestionData(
            "How many provinces are there in Bangladesh",
            6,
            "5",
            "6",
            "7",
            "8",
            4

        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        return que
    }
}