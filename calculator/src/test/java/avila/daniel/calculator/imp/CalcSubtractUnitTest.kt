package avila.daniel.calculator.imp

import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.model.Operands
import avila.domingo.calculator.imp.CalcImp
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalcSubtractUnitTest {
    private val calc: ICalc = CalcImp()

    @Test
    fun `subtract with +op1 & +op2 is correct`() {
        calc.subtract(Operands(2f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }

    @Test
    fun `subtract with +op1 & -op2 is correct`() {
        calc.subtract(Operands(2f, -2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(4f)
        }
    }

    @Test
    fun `subtract with -op1 & +op2 is correct`() {
        calc.subtract(Operands(-2f, 2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(-4f)
        }
    }

    @Test
    fun `subtract with -op1 & -op2 is correct`() {
        calc.subtract(Operands(-2f, -2f)).test().run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }
}
