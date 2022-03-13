package com.example.workoutapp

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        val burpees = ExerciseModel(1,"burpees",R.drawable.burpees_exercise_illustration,false,false)
        val crossJacks = ExerciseModel(2,"cross jacks",R.drawable.cross_jacks_exercise_illustration,false,false)
        val frondAndBackLunges = ExerciseModel(3,"front and back lunges",R.drawable.front_and_back_lunges_exercise_illustration,false,false)
        val highKnees = ExerciseModel(4,"high knees",R.drawable.high_knees_exercise_illustration,false,false)
        val jumpingJacks = ExerciseModel(5,"jumping jacks",R.drawable.jumping_jacks_exercise_illustration,false,false)
        val mountainClimbers = ExerciseModel(6,"mountain climbers",R.drawable.mountain_climbers_exercise_illustration,false,false)
        val plankJacks = ExerciseModel(7,"plank jacks",R.drawable.plank_jacks_exercise_illustration,false,false)
        val sideShuffle = ExerciseModel(9,"side shuffle",R.drawable.side_shuffle_exercise_illustration,false,false)
        val standingCrissCross = ExerciseModel(9,"standing criss cross",R.drawable.standing_criss_cross_crunches_illustration,false,false)

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