package com.amokksol.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //объявляем наши кнопки с импортом виджета
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //создаем ссылку на кнопки
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
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

    }
}