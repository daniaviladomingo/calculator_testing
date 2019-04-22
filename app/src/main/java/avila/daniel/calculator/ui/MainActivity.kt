package avila.daniel.calculator.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import avila.daniel.calculator.R
import avila.daniel.calculator.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mapOf(
            Pair(button_0, 0),
            Pair(button_1, 1),
            Pair(button_2, 2),
            Pair(button_3, 3),
            Pair(button_4, 4),
            Pair(button_5, 5),
            Pair(button_6, 6),
            Pair(button_7, 7),
            Pair(button_8, 8),
            Pair(button_9, 9)
        ).forEach { mapEntry ->
            mapEntry.key.setOnClickListener {
                val stringRes = result.text.toString()
                result.setText(String.format("%s%d", stringRes, mapEntry.value))
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        val stringRes = result.text.toString()
        when (v.id) {
            R.id.button_0 -> result.setText("${stringRes}0")
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun checkAgain(): () -> Unit = {}

    override fun tryAgain(): () -> Unit = {}
}
