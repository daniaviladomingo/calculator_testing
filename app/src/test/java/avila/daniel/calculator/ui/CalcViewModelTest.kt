package avila.daniel.calculator.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import avila.daniel.calculator.*
import avila.daniel.calculator.domain.interactor.AddUseCase
import avila.daniel.calculator.domain.interactor.DivisionUseCase
import avila.daniel.calculator.domain.interactor.MultiplyUseCase
import avila.daniel.calculator.domain.interactor.SubtractUseCase
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalcViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var addUseCase: AddUseCase
    @Mock
    lateinit var divisionUseCase: DivisionUseCase
    @Mock
    lateinit var multiplyUseCase: MultiplyUseCase
    @Mock
    lateinit var subtractUseCase: SubtractUseCase
    @Mock
    lateinit var calcViewModel: CalcViewModel

    @Before
    fun setUp() {
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
        Mockito.`when`(addUseCase.execute(operands)).thenReturn(Single.just(ADD_RESULT))

        calcViewModel.add(OP1, OP2)

        Mockito.verify(addUseCase, Mockito.times(1)).execute(operands)
        Mockito.verifyNoMoreInteractions(addUseCase)
    }

    @Test
    fun `should subtract operands`() {
        Mockito.`when`(subtractUseCase.execute(operands)).thenReturn(Single.just(SUBTRACT_RESULT))

        calcViewModel.subtract(OP1, OP2)

        Mockito.verify(subtractUseCase, Mockito.times(1)).execute(operands)
        Mockito.verifyNoMoreInteractions(subtractUseCase)
    }

    @Test
    fun `should multiply operands`() {
        Mockito.`when`(multiplyUseCase.execute(operands)).thenReturn(Single.just(MULTIPLY_RESULT))

        calcViewModel.multiply(OP1, OP2)

        Mockito.verify(multiplyUseCase, Mockito.times(1)).execute(operands)
        Mockito.verifyNoMoreInteractions(multiplyUseCase)
    }

    @Test
    fun `should divide operands`() {
        Mockito.`when`(divisionUseCase.execute(operands)).thenReturn(Single.just(DIVISION_RESULT))

        calcViewModel.division(OP1, OP2)

        Mockito.verify(divisionUseCase, Mockito.times(1)).execute(operands)
        Mockito.verifyNoMoreInteractions(divisionUseCase)
    }
}