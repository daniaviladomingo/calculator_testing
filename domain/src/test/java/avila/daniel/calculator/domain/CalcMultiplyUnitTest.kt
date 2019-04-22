package avila.daniel.calculator.domain

import io.reactivex.observers.TestObserver
import org.junit.Test
import java.lang.IllegalArgumentException

class CalcMultiplyUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun `multiply with +op1 & +op2 is correct`() {
        calc.multiply(3f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(6f)
        }
    }

    @Test
    fun `multiply with +op1 & -op2 is correct`() {
        calc.multiply(3f, -2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-6f)
        }
    }

    @Test
    fun `multiply with -op1 & +op2 is correct`() {
        calc.multiply(-3f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-6f)
        }
    }

    @Test
    fun `multiply with -op1 & -op2 is correct`() {
        calc.multiply(3f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(6f)
        }
    }
}
