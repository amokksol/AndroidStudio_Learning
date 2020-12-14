package com.amokksol.geoquiz

import androidx.annotation.StringRes
//класс данных - содержит 2 вида данных, текст вопроса и правильность ответа(да/нет)
//@StringRes - аннотация указывает на использование строки,
//textResId - числовой ID - ссылка на строковый ресурс
data class Question(@StringRes val textResId: Int, val answer: Boolean) {

}