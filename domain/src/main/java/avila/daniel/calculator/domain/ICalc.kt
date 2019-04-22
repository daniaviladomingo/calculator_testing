package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import io.reactivex.Single

interface ICalc {
    fun add(ops: Operands): Single<Float>
    fun subtract(ops: Operands): Single<Float>
    fun multiply(ops: Operands): Single<Float>
    fun division(ops: Operands): Single<Float>
}