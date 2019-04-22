package avila.daniel.calculator.domain.interactor

import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.interactor.type.SingleUseCaseWithParameter
import avila.daniel.calculator.domain.model.Operands
import io.reactivex.Single

class AddUseCase(private val calc: ICalc) : SingleUseCaseWithParameter<Operands, Float> {
    override fun execute(parameter: Operands): Single<Float> = calc.add(parameter)
}