package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalcAddUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun `add with +op1 & +op2 is correct`() {
        calc.add(Operands(2f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(4f)
        }
    }

    @Test
    fun `add with -op1 & +op2 is correct`() {
        calc.add(Operands(-2f, 2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }

    @Test
    fun `add with +op1 & -op2 is correct`() {
        calc.add(Operands(2f, -2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(0f)
        }
    }

    @Test
    fun `add with -op1 & -op2 is correct`() {
        calc.add(Operands(-2f, -2f)).subscribe(testObserver)
        testObserver.run {
            assertComplete()
            assertNoErrors()
            assertValue(-4f)
        }
    }
}
