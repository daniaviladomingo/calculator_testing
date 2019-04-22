package avila.daniel.calculator.domain

import io.reactivex.Single
import java.lang.IllegalArgumentException

class CalcImp : ICalc {
    override fun add(op1: Float, op2: Float): Single<Float> = Single.create { it.onSuccess(op1 + op2) }

    override fun subtract(op1: Float, op2: Float): Single<Float> = Single.create { it.onSuccess(op1 - op2) }

    override fun multiply(op1: Float, op2: Float): Single<Float> = Single.create { it.onSuccess(op1 * op2) }

    override fun division(op1: Float, op2: Float): Single<Float> = Single.create {
        if (op2 == 0f) {
            it.onError(IllegalArgumentException("Division by Zero"))
        } else {
            it.onSuccess(op1 / op2)
        }
    }
}