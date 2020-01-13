package avila.daniel.calculator.domain.interactor

import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.MULTIPLY_RESULT
import avila.daniel.calculator.domain.operands
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class MultiplyUseCaseTest {

    private lateinit var multiplyUseCase: MultiplyUseCase
    private lateinit var calc: ICalc

    @Before
    fun setUp() {
        calc = Mockito.mock(ICalc::class.java)
        multiplyUseCase = MultiplyUseCase(calc)
    }

    @Test
    fun `should multiply two numbers`() {
        Mockito.`when`(calc.multiply(operands)).thenReturn(
            Single.just(
                MULTIPLY_RESULT
            )
        )

        multiplyUseCase.execute(operands).test()
            .assertComplete()
            .assertValue(MULTIPLY_RESULT)

        Mockito.verify(calc, Mockito.times(1)).multiply(operands)
        Mockito.verifyNoMoreInteractions(calc)
    }
}