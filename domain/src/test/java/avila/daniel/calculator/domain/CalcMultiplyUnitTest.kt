package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalcMultiplyUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun `multiply with +op1 & +op2 is correct`() {
        calc.multiply(Operands(3f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(6f)
        }
    }

    @Test
    fun `multiply with +op1 & -op2 is correct`() {
        calc.multiply(Operands(3f, -2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-6f)
        }
    }

    @Test
    fun `multiply with -op1 & +op2 is correct`() {
        calc.multiply(Operands(-3f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-6f)
        }
    }

    @Test
    fun `multiply with -op1 & -op2 is correct`() {
        calc.multiply(Operands(3f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(6f)
        }
    }
}
