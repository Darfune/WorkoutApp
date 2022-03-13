package com.example.workoutapp

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        val burpees = ExerciseModel(1,"burpees",R.drawable.burpees_exercise_illustration,false,false)
        val crossJacks = ExerciseModel(2,"cross jacks",R.drawable.burpees_exercise_illustration,false,false)
        val frondAndBackLunges = ExerciseModel(3,"front and back lunges",R.drawable.burpees_exercise_illustration,false,false)
        val highKnees = ExerciseModel(4,"high knees",R.drawable.burpees_exercise_illustration,false,false)
        val jumpingJacks = ExerciseModel(5,"jumping jacks",R.drawable.burpees_exercise_illustration,false,false)
        val mountainClimbers = ExerciseModel(6,"mountain climbers",R.drawable.burpees_exercise_illustration,false,false)
        val plankJacks = ExerciseModel(7,"plank jacks",R.drawable.burpees_exercise_illustration,false,false)
        val sideShuffle = ExerciseModel(9,"side shuffle",R.drawable.burpees_exercise_illustration,false,false)
        val standingCrissCross = ExerciseModel(9,"standing criss cross",R.drawable.burpees_exercise_illustration,false,false)

        exerciseList.add(burpees)
        exerciseList.add(crossJacks)
        exerciseList.add(frondAndBackLunges)
        exerciseList.add(highKnees)
        exerciseList.add(jumpingJacks)
        exerciseList.add(mountainClimbers)
        exerciseList.add(plankJacks)
        exerciseList.add(sideShuffle)
        exerciseList.add(standingCrissCross)

        return exerciseList
    }

}