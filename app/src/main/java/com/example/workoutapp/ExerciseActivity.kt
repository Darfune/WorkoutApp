package com.example.workoutapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityExerciseBinding
import kotlin.random.Random

class ExerciseActivity : AppCompatActivity() {

    private var binding: ActivityExerciseBinding?= null

    private var restTimer: CountDownTimer? = null
    private var timerProgress = 0
    private var restFlag = true

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var selected: Int = 1

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.exerciseToolbar)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.exerciseToolbar?.setNavigationOnClickListener {
            onBackPressed()
        }

        exerciseList = Constants.defaultExerciseList()

        setupRestView()
    }

    private fun setRestProgressBar(time: Long) {
        binding?.progressBar?.progress = timerProgress
        binding?.progressBar?.max = (time/1000).toInt()

        restTimer = object: CountDownTimer(time, 1000){

            override fun onTick(p0: Long) {
                timerProgress++
                binding?.progressBar?.progress = ((time/1000) - timerProgress).toInt()
                binding?.timerTextView?.text = ((time/1000) - timerProgress).toString()
            }

            override fun onFinish() {
                setupRestView()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun setupRestView(){
        if (counter >= 7){
            Toast.makeText(this@ExerciseActivity, "You Finished", Toast.LENGTH_SHORT).show()
        }
        else{
            if (restTimer != null){
                restTimer?.cancel()
                timerProgress = 0

            }

            if (restFlag){
                restFlag = false
                setExerciseImage(false)
                setRestProgressBar(1000)
            }
            else{
                restFlag = true
                setExerciseImage(true)
                setRestProgressBar(2000)
                counter++
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setExerciseImage(flag: Boolean) {
        if (flag){
            binding?.titleTextView?.text = "" +  exerciseList!![selected].getName()
            binding?.exerciseImageView?.setImageResource(exerciseList!![selected].getImage())
            binding?.exerciseImageView?.visibility = View.VISIBLE

        }
        else{
            do {
                selected = (0 until (exerciseList?.size!!)).random()
            }while (exerciseList!![selected].getIsSelected())
            exerciseList!![selected].setIsSelected(true)

            binding?.exerciseImageView?.visibility = View.INVISIBLE
            binding?.titleTextView?.text = "Get Ready for " +  exerciseList!![selected].getName()
        }
    }

    override fun onDestroy() {
        super.onDestroy()


        binding = null
    }

}