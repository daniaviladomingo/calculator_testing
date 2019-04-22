package avila.daniel.calculator.domain

import io.reactivex.observers.TestObserver
import org.junit.Test
import java.lang.IllegalArgumentException

class CalcDivisionUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun `division with +op1 & +op2 is correct`() {
        calc.division(2f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(1f)
        }
    }

    @Test
    fun `division with +op1 & -op2 is correct`() {
        calc.division(2f, -2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-1f)
        }
    }

    @Test
    fun `division with -op1 & +op2 is correct`() {
        calc.division(-2f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-1f)
        }
    }

    @Test
    fun `division with -op1 & -op2 is correct`() {
        calc.division(2f, 2f).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(1f)
        }
    }

    @Test
    fun `division by cero forbidden`() {
        calc.division(2f, 0f).subscribe(testObserver)
        testObserver.assertNotComplete()
        testObserver.assertError(IllegalArgumentException::class.java)
    }
}
