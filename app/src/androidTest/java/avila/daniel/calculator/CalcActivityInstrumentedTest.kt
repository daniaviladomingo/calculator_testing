package avila.daniel.calculator

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import avila.daniel.calculator.ui.MainActivity
import avila.daniel.ui.testing.util.checkText
import avila.daniel.ui.testing.util.touch
import avila.daniel.ui.testing.util.view
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class CalcActivityInstrumentedTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clearOperation() {
        listOf(R.id.button_2, R.id.button_add, R.id.button_2, R.id.button_c).forEach { it.touch() }
        R.id.result.view().checkText("")
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

    @Test
    fun divisionByCero() {
        // 2 / 0 = Error!!
        listOf(
            R.id.button_2,
            R.id.button_division,
            R.id.button_0,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.error_message.view().checkText("Division by Zero")
    }

    /**
     * MULTIPLY
     */

    @Test
    fun multiplyPositivePositive() {
        // 2 * 3 = 6.0
        listOf(R.id.button_2, R.id.button_multiply, R.id.button_3, R.id.button_equal).forEach { it.touch() }
        R.id.result.view().checkText("6.0")
    }

    @Test
    fun multiplyPositiveNegative() {
        // 2 * -3 = -6.0
        listOf(
            R.id.button_2,
            R.id.button_multiply,
            R.id.button_substract,
            R.id.button_3,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("-6.0")
    }

    @Test
    fun multiplyNegativePositive() {
        // -2 * 3 = -6.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_multiply,
            R.id.button_3,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("-6.0")
    }

    @Test
    fun multiplyNegativeNegative() {
        // -2 * -3 = -6.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_multiply,
            R.id.button_substract,
            R.id.button_3,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("6.0")
    }

    /**
     * SUBSTRACT
     */
    @Test
    fun substractPositivePositive() {
        // 2 - 2 = 0.0
        listOf(R.id.button_2, R.id.button_substract, R.id.button_2, R.id.button_equal).forEach { it.touch() }
        R.id.result.view().checkText("0.0")
    }

    @Test
    fun substractPositiveNegative() {
        // 2 - -2 = 4.0
        listOf(
            R.id.button_2,
            R.id.button_substract,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("4.0")
    }

    @Test
    fun substractNegativePositive() {
        // -2 - 2 = -4.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("-4.0")
    }

    @Test
    fun substractNegativeNegative() {
        // -2 - -2 = 0.0
        listOf(
            R.id.button_substract,
            R.id.button_2,
            R.id.button_substract,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("0.0")
    }
}
