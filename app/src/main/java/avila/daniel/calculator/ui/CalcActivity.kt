package avila.daniel.calculator.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import avila.daniel.calculator.R
import avila.daniel.calculator.base.BaseActivity
import avila.daniel.calculator.model.Operator
import avila.daniel.calculator.ui.data.ResourceState
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class CalcActivity : BaseActivity() {

    private val calcViewModel: CalcViewModel by viewModel()

    private var operator: Operator? = null

    private var op1: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()

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

        mapOf(
            Pair(button_add, Operator.ADD),
            Pair(button_division, Operator.DIVISION),
            Pair(button_multiply, Operator.MULTIPLY),
            Pair(button_substract, Operator.SUBSTRACT)
        ).forEach { mapEntry ->
            mapEntry.key.setOnClickListener {
                if (result.text.toString().isNotEmpty()) {
                    op1 = result.text.toString().toFloat()
                    result.setText("")
                    operator = mapEntry.value
                } else if (mapEntry.value == Operator.SUBSTRACT) {
                    result.setText("-")
                }
            }
        }

        button_c.setOnClickListener {
            op1 = null
            operator = null
            result.setText("")
        }

        button_equal.setOnClickListener {
            operator?.run {
                val resultText = result.text.toString()
                if (resultText.isNotEmpty()) {
                    val op2 = resultText.toFloat()
                    when (this) {
                        Operator.ADD -> calcViewModel.add(op1!!, op2)
                        Operator.DIVISION -> calcViewModel.division(op1!!, op2)
                        Operator.MULTIPLY -> calcViewModel.multiply(op1!!, op2)
                        Operator.SUBSTRACT -> calcViewModel.subtract(op1!!, op2)
                    }
                }
            }
        }
    }

    private fun setListener() {
        calcViewModel.resultLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        op1 = this
                        result.setText("$this")
                    }
                }
            }
        })
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun tryAgain(): () -> Unit = {
        result.setText("")
        revertResourceState()
    }

    override fun checkAgain(): () -> Unit = {}
}
