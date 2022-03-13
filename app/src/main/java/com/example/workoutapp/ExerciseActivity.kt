package com.example.workoutapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.workoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var binding: ActivityExerciseBinding?= null

    private var restTimer: CountDownTimer? = null
    private var timerProgress = 0
    private var restFlag = true

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
        if (restTimer != null){
            restTimer?.cancel()
            timerProgress = 0
        }

        if (restFlag){
            restFlag = false
            binding?.titleTextView?.text = "Get Ready For Exercise"
            setRestProgressBar(10000)
        }
        else{
            restFlag = true
            binding?.titleTextView?.text = "Exercise Name"
            setRestProgressBar(30000)
        }

    }

    override fun onDestroy() {
        super.onDestroy()


        binding = null
    }

}