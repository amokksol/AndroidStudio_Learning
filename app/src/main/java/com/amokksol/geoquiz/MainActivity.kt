package com.amokksol.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //объявляем наши кнопки с импортом виджета
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
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
        setContentView(R.layout.activity_main)
        //создаем ссылку на кнопки
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        //создаем действие на нажатие
        trueButton.setOnClickListener { view: View ->
            var toast1 = Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT)
                toast1.show()
                toast1.setGravity(Gravity.TOP,0,0)
           //код выполнение - после нажатия -> уведомление
            }
        falseButton.setOnClickListener { view: View ->
            //код выполнение - после нажатия -> уведомление
            var toast = Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT)
                toast.show()
                toast.setGravity(Gravity.TOP,0,0)
            }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex+1)%questionBank.size
            updateQuestion()
            }
        updateQuestion()
        }
    //создаем функцию которая нужна  в двух местах
    //вывод вопроса из списка. questionBank - создали список, currentIndex  = 0
    //textResId - значение полученное из Data класса
    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
}