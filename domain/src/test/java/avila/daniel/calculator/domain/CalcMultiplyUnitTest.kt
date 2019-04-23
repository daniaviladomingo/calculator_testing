package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalcMultiplyUnitTest {
    private val calc: ICalc = CalcImp()

    @Test
    fun `multiply with +op1 & +op2 is correct`() {
        calc.multiply(Operands(3f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(6f)
        }
    }

    @Test
    fun `multiply with +op1 & -op2 is correct`() {
        calc.multiply(Operands(3f, -2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(-6f)
        }
    }

    @Test
    fun `multiply with -op1 & +op2 is correct`() {
        calc.multiply(Operands(-3f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(-6f)
        }
    }

    @Test
    fun `multiply with -op1 & -op2 is correct`() {
        calc.multiply(Operands(3f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(6f)
        }
    }
}
