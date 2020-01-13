package avila.daniel.calculator.domain.interactor

import avila.daniel.calculator.domain.ADD_RESULT
import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.operands
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class AddUseCaseTest {

    private lateinit var addUseCase: AddUseCase
    private lateinit var calc: ICalc

    @Before
    fun setUp() {
        calc = Mockito.mock(ICalc::class.java)
        addUseCase = AddUseCase(calc)
    }

    @Test
    fun `should add two numbers`() {
        Mockito.`when`(calc.add(operands)).thenReturn(
            Single.just(
                ADD_RESULT
            )
        )

        addUseCase.execute(operands).test()
            .assertComplete()
            .assertValue(ADD_RESULT)

        Mockito.verify(calc, Mockito.times(1)).add(operands)
        Mockito.verifyNoMoreInteractions(calc)
    }
}