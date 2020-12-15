package com.amokksol.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ImageButton
//создание консатнты для записей LOG
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    //объявляем наши кнопки с импортом виджета
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var backButton: ImageButton
    private lateinit var questionTextView: TextView


    //создаем список вопросов из дата класса Question. заранее указывая верные ответы
    private val questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_africa,false),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true))
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //регистрация Логов
        Log.d(TAG,"onCreate(Bundle&) called")
        setContentView(R.layout.activity_main)
        //создаем ссылку на кнопки
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        backButton = findViewById(R.id.back_button)
        questionTextView = findViewById(R.id.question_text_view)

        //создаем действие на нажатие
        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
           //код выполнение - после нажатия -> уведомление
            }
        falseButton.setOnClickListener { view: View ->
            //код выполнение - после нажатия -> уведомление
         checkAnswer(false)
            }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex+1)%questionBank.size
            updateQuestion()
            }
        questionTextView.setOnClickListener { currentIndex = (currentIndex+1)%questionBank.size
            updateQuestion() }
        backButton.setOnClickListener {
            currentIndex = (currentIndex-1)%questionBank.size
            updateQuestion()
        }
        updateQuestion()
        }

    //Переопрелделние функций жизненного цикла
    override fun onStart(){
        super.onStart()
        Log.d(TAG,"onStart(Bundle&) called")
    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG,"onResume(Bundle&) called")
    }
    override fun onPause(){
        super.onPause()
        Log.d(TAG,"onPause(Bundle&) called")
    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG,"onStop(Bundle&) called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy(Bundle&) called")
    }
    //создаем функцию которая нужна  в двух местах
    //вывод вопроса из списка. questionBank - создали список, currentIndex  = 0
    //textResId - значение полученное из Data класса
    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if(userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show()
    }


}

