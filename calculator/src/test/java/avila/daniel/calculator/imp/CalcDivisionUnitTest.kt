package avila.daniel.calculator.imp

import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.model.Operands
import avila.domingo.calculator.imp.CalcImp
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
