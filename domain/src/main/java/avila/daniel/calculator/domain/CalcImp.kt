package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import io.reactivex.Single
import java.lang.IllegalArgumentException

class CalcImp : ICalc {
    override fun add(ops: Operands): Single<Float> = Single.create { it.onSuccess(ops.run { op1 + op2 }) }

    override fun subtract(ops: Operands): Single<Float> = Single.create { it.onSuccess(ops.run { op1 - op2 }) }

    override fun multiply(ops: Operands): Single<Float> = Single.create { it.onSuccess(ops.run { op1 * op2 }) }

    override fun division(ops: Operands): Single<Float> = Single.create {
        if (ops.op2 == 0f) {
            it.onError(IllegalArgumentException("Division by Zero"))
        } else {
            it.onSuccess(ops.run { op1 / op2 })
        }
    }
}