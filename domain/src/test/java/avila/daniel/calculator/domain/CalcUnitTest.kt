package avila.daniel.calculator.domain

import io.reactivex.observers.TestObserver
import org.junit.Test

class CalcUnitTest {
    private val calc: ICalc = CalcImp()
    private val testObserver = TestObserver.create<Float>()

    @Test
    fun add_isCorrect() {
        calc.add(2f, 2f).subscribe(testObserver)
        testObserver.assertValue(4f)
    }

    @Test
    fun subtract_isCorrect() {
        calc.subtract(2f, 2f).subscribe(testObserver)
        testObserver.assertValue(0f)
    }

    @Test
    fun multiply_isCorrect() {
        calc.multiply(3f, 2f).subscribe(testObserver)
        testObserver.assertValue(6f)
    }

    @Test
    fun division_isCorrect() {
        calc.division(2f, 2f).subscribe(testObserver)
        testObserver.assertValue(1f)
    }
}
