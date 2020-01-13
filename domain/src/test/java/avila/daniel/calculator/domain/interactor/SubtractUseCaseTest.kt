package avila.daniel.calculator.domain.interactor

import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.SUBTRACT_RESULT
import avila.daniel.calculator.domain.operands
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class SubtractUseCaseTest {

    private lateinit var subtractUseCase: SubtractUseCase
    private lateinit var calc: ICalc

    @Before
    fun setUp() {
        calc = Mockito.mock(ICalc::class.java)
        subtractUseCase = SubtractUseCase(calc)
    }

    @Test
    fun `should subtract two numbers`() {
        Mockito.`when`(calc.subtract(operands)).thenReturn(
            Single.just(
                SUBTRACT_RESULT
            )
        )

        subtractUseCase.execute(operands).test()
            .assertComplete()
            .assertValue(SUBTRACT_RESULT)

        Mockito.verify(calc, Mockito.times(1)).subtract(operands)
        Mockito.verifyNoMoreInteractions(calc)
    }
}