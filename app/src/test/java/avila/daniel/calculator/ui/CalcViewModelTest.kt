package avila.daniel.calculator.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import avila.daniel.calculator.*
import avila.daniel.calculator.domain.interactor.AddUseCase
import avila.daniel.calculator.domain.interactor.DivisionUseCase
import avila.daniel.calculator.domain.interactor.MultiplyUseCase
import avila.daniel.calculator.domain.interactor.SubtractUseCase
import avila.daniel.calculator.domain.model.Operands
import avila.daniel.calculator.ui.data.ResourceState
import io.reactivex.Single
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.IllegalArgumentException

class CalcViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var addUseCase: AddUseCase

    @MockK
    lateinit var divisionUseCase: DivisionUseCase

    @MockK
    lateinit var multiplyUseCase: MultiplyUseCase

    @MockK
    lateinit var subtractUseCase: SubtractUseCase

    @MockK
    lateinit var calcViewModel: CalcViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        calcViewModel = CalcViewModel(
            addUseCase,
            divisionUseCase,
            multiplyUseCase,
            subtractUseCase,
            MockSchedulersImp
        )
    }

    @Test
    fun `should add operands`() {
        every { addUseCase.execute(operands) } returns Single.just(ADD_RESULT)

        calcViewModel.add(OP1, OP2)

        val value = calcViewModel.resultLiveData.getOrAwaitValue()

        value.status shouldBeEqualTo ResourceState.SUCCESS
        value.data shouldBeEqualTo ADD_RESULT

        verify(exactly = 1) { addUseCase.execute(operands) }
    }

    @Test
    fun `should subtract operands`() {
        every { subtractUseCase.execute(operands) } returns Single.just(SUBTRACT_RESULT)

        calcViewModel.subtract(OP1, OP2)

        val value = calcViewModel.resultLiveData.getOrAwaitValue()

        value.status shouldBeEqualTo ResourceState.SUCCESS
        value.data shouldBeEqualTo SUBTRACT_RESULT

        verify(exactly = 1) { subtractUseCase.execute(operands) }
    }

    @Test
    fun `should multiply operands`() {
        every { multiplyUseCase.execute(operands) } returns Single.just(MULTIPLY_RESULT)

        calcViewModel.multiply(OP1, OP2)

        val value = calcViewModel.resultLiveData.getOrAwaitValue()

        value.status shouldBeEqualTo ResourceState.SUCCESS
        value.data shouldBeEqualTo MULTIPLY_RESULT

        verify(exactly = 1) { multiplyUseCase.execute(operands) }
    }

    @Test
    fun `should divide operands`() {
        every { divisionUseCase.execute(operands) } returns Single.just(DIVISION_RESULT)

        calcViewModel.division(OP1, OP2)

        val value = calcViewModel.resultLiveData.getOrAwaitValue()

        value.status shouldBeEqualTo ResourceState.SUCCESS
        value.data shouldBeEqualTo DIVISION_RESULT

        verify(exactly = 1) { divisionUseCase.execute(operands) }
    }

    @Test
    fun `division by zero`() {
        val op = Operands(2f, 0f)
        every { divisionUseCase.execute(op) } returns Single.create {
            it.onError(
                IllegalArgumentException("Division by Zero")
            )
        }

        calcViewModel.division(2f, 0f)

        val value = calcViewModel.resultLiveData.getOrAwaitValue()

        value.status shouldBeEqualTo ResourceState.ERROR
        value.message shouldBeEqualTo "Division by Zero"

        verify(exactly = 1) { divisionUseCase.execute(op) }
    }
}