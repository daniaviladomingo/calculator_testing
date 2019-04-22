package avila.daniel.calculator.domain

import io.reactivex.observers.TestObserver
import org.junit.Test

class CalcSubUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun `subtract with +op1 & +op2 is correct`() {
        calc.subtract(2f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }

    @Test
    fun `subtract with +op1 & -op2 is correct`() {
        calc.subtract(2f, -2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(4f)
        }
    }

    @Test
    fun `subtract with -op1 & +op2 is correct`() {
        calc.subtract(-2f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-4f)
        }
    }

    @Test
    fun `subtract with -op1 & -op2 is correct`() {
        calc.subtract(-2f, -2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }
}
