package avila.daniel.calculator.domain

import io.reactivex.Single

interface ICalc {
    fun add(op1: Float, op2: Float): Single<Float>
    fun subtract(op1: Float, op2: Float): Single<Float>
    fun multiply(op1: Float, op2: Float): Single<Float>
    fun division(op1: Float, op2: Float): Single<Float>
}