package com.alyndroid.architecturepatternstutorialshomework.repository;

import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;

public class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
