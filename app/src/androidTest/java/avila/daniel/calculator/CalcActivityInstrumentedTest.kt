package avila.daniel.calculator

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import avila.daniel.calculator.ui.MainActivity
import avila.daniel.calculator.util.checkText
import avila.daniel.calculator.util.touch
import avila.daniel.calculator.util.view
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalcActivityInstrumentedTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false)

    @Before
    fun clear() {
        R.id.button_c.touch()
    }

    /**
     * ADD
     */
    @Test
    fun addPositivePositive() {
        // 2 + 2 = 4.0
        listOf(R.id.button_2, R.id.button_add, R.id.button_2, R.id.button_equal).forEach { it.touch() }
        R.id.result.view().checkText("4.0")
    }

    @Test
    fun addPositiveNegative() {
        // 2 + -2 = 0.0
        listOf(
            R.id.button_2,
            R.id.button_add,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("0.0")
    }

    @Test
    fun addNegativePositive() {
        // -2 + 2 = 0.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_add,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("0.0")
    }

    @Test
    fun addNegativeNegative() {
        // -2 + -2 = -4.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_add,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("-4.0")
    }

    /**
     * DIVISION
     */

    @Test
    fun divisionPositivePositive() {
        // 2 / 2 = 1.0
        listOf(R.id.button_2, R.id.button_division, R.id.button_2, R.id.button_equal).forEach { it.touch() }
        R.id.result.view().checkText("1.0")
    }

    @Test
    fun divisionPositiveNegative() {
        // 2 / -2 = -1.0
        listOf(
            R.id.button_2,
            R.id.button_division,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("-1.0")
    }

    @Test
    fun divisionNegativePositive() {
        // -2 / 2 = -1.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_division,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("-1.0")
    }

    @Test
    fun divisionNegativeNegative() {
        // -2 / -2 = 1.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_division,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("1.0")
    }
}
