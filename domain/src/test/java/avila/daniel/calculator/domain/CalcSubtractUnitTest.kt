package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalcSubtractUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun `subtract with +op1 & +op2 is correct`() {
        calc.subtract(Operands(2f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }

    @Test
    fun `subtract with +op1 & -op2 is correct`() {
        calc.subtract(Operands(2f, -2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(4f)
        }
    }

    @Test
    fun `subtract with -op1 & +op2 is correct`() {
        calc.subtract(Operands(-2f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-4f)
        }
    }

    @Test
    fun `subtract with -op1 & -op2 is correct`() {
        calc.subtract(Operands(-2f, -2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }
}
