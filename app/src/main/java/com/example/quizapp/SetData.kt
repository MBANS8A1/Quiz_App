package com.example.quizapp

object SetData {
    fun getQuestion(): ArrayList<QuestionData>{
        val que:ArrayList<QuestionData> = arrayListOf()
        val q1 = QuestionData(
            1,
            "Who is the Roman goddess of handicrafts and wisdom?",
            "Ceres",
            "Bellona",
            "Minerva",
            "Luna",
            3

        )

        val q2 = QuestionData(
            2,
            "Which colour is not represented by the rings on the Olympics flag?",
            "Green",
            "Purple",
            "Blue",
            "Red",
            2

        )

        val q3 = QuestionData(
            3,
            "In 2020, who was the 1st male singer to appear solo on the cover of Vogue magazine?",
            "Harry Styles",
            "Ed Sheeran",
            "Bono",
            "Justin Timberlake",
            1
        )

        val q4 = QuestionData(
            4,
            "What was the name of the first and only spacecraft to visit the planet Neptune?",
            "Pioneer 11",
            "Luna 1",
            "Mariner 4",
            "Voyager 2",
            4
        )

        val q5 = QuestionData(
            5,
            "Which language has the longest alphabet in the world?",
            "Hindi",
            "Chinese",
            "Khmer",
            "Persian",
            3
        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que

    }
}