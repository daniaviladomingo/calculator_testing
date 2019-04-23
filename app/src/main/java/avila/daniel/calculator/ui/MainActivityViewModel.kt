package avila.daniel.calculator.ui

import avila.daniel.calculator.base.BaseViewModel
import avila.daniel.calculator.domain.interactor.AddUseCase
import avila.daniel.calculator.domain.interactor.DivisionUseCase
import avila.daniel.calculator.domain.interactor.MultiplyUseCase
import avila.daniel.calculator.domain.interactor.SubtractUseCase
import avila.daniel.calculator.domain.model.Operands
import avila.daniel.calculator.schedulers.IScheduleProvider
import avila.daniel.calculator.ui.data.Resource
import avila.daniel.calculator.util.SingleLiveEvent

class MainActivityViewModel(
    private val addUseCase: AddUseCase,
    private val divisionUseCase: DivisionUseCase,
    private val multiplyUseCase: MultiplyUseCase,
    private val substractUseCase: SubtractUseCase,
    private val scheduleProvider: IScheduleProvider
) : BaseViewModel() {

    val resultLiveData = SingleLiveEvent<Resource<Float>>()

    fun add(op1: Float, op2: Float) {
        resultLiveData.value = Resource.loading()
        addDisposable(addUseCase.execute(Operands(op1, op2))
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ result ->
                resultLiveData.value = Resource.success(result)
            }) {
                resultLiveData.value = Resource.error(it.localizedMessage)
            })
    }

    fun division(op1: Float, op2: Float) {
        resultLiveData.value = Resource.loading()
        addDisposable(divisionUseCase.execute(Operands(op1, op2))
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ result ->
                resultLiveData.value = Resource.success(result)
            }) {
                resultLiveData.value = Resource.error(it.localizedMessage)
            })
    }

    fun multiply(op1: Float, op2: Float) {
        resultLiveData.value = Resource.loading()
        addDisposable(multiplyUseCase.execute(Operands(op1, op2))
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ result ->
                resultLiveData.value = Resource.success(result)
            }) {
                resultLiveData.value = Resource.error(it.localizedMessage)
            })
    }

    fun substract(op1: Float, op2: Float) {
        resultLiveData.value = Resource.loading()
        addDisposable(substractUseCase.execute(Operands(op1, op2))
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.io())
            .subscribe({ result ->
                resultLiveData.value = Resource.success(result)
            }) {
                resultLiveData.value = Resource.error(it.localizedMessage)
            })
    }
}