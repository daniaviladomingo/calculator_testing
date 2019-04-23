package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.IllegalArgumentException

@RunWith(JUnit4::class)
class CalcDivisionUnitTest {
    private val calc: ICalc = CalcImp()

    @Test
    fun `division with +op1 & +op2 is correct`() {
        calc.division(Operands(2f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(1f)
        }
    }

    @Test
    fun `division with +op1 & -op2 is correct`() {
        calc.division(Operands(2f, -2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(-1f)
        }
    }

    @Test
    fun `division with -op1 & +op2 is correct`() {
        calc.division(Operands(-2f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(-1f)
        }
    }

    @Test
    fun `division with -op1 & -op2 is correct`() {
        calc.division(Operands(2f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(1f)
        }
    }

    @Test
    fun `division by cero forbidden`() {
        calc.division(Operands(2f, 0f)).test().run {
            assertNotComplete()
            assertError(IllegalArgumentException::class.java)
        }
    }
}
