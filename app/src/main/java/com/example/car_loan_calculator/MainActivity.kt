package com.example.car_loan_calculator

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.ConfigurationCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun calculateLoan(view:View){
        if(editTextCarPrice.text.isEmpty())
        {
            editTextCarPrice.setError(getString(R.string.error_input))
        }

        val loan: Int =  editTextCarPrice.text.toString().toInt() - editTextDownPayment.text.toString().toInt()
        val interest: Float = loan * editTextInterestRate.text.toString().toFloat() * editTextLoanPeriod.text.toString().toInt()
       val malrepy:Float = (loan + interest)/editTextLoanPeriod.text.toString().toInt()/12

        //val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0)

        var currency = (Currency.getInstance(Locale.getDefault())).getSymbol();

        textViewCarloan.setText( currency + " ${loan}")
        textViewInterest.setText(currency +" ${interest}")
        textViewMonthlyRepayment.setText(currency + " ${malrepy}")

    }


    fun reset(view:View){

        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewMonthlyRepayment.setText("")
        textViewCarloan.setText("")
        textViewInterest.setText("")

    }

}
