package avila.daniel.calculator.domain.interactor

import avila.daniel.calculator.domain.DIVISION_RESULT
import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.operands
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class DivisionUseCaseTest {

    private lateinit var divisionUseCase: DivisionUseCase
    private lateinit var calc: ICalc

    @Before
    fun setUp() {
        calc = Mockito.mock(ICalc::class.java)
        divisionUseCase = DivisionUseCase(calc)
    }

    @Test
    fun `should division two numbers`() {
        Mockito.`when`(calc.division(operands)).thenReturn(
            Single.just(
                DIVISION_RESULT
            )
        )

        divisionUseCase.execute(operands).test()
            .assertComplete()
            .assertValue(DIVISION_RESULT)

        Mockito.verify(calc, Mockito.times(1)).division(operands)
        Mockito.verifyNoMoreInteractions(calc)
    }
}