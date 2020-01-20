package avila.daniel.calculator.ui

import android.os.Build
import androidx.test.rule.ActivityTestRule
import avila.daniel.calculator.R
import avila.daniel.ui.testing.util.checkText
import avila.daniel.ui.testing.util.touch
import avila.daniel.ui.testing.util.view
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class CalcActivityUnitTest : AutoCloseKoinTest() {

    @get:Rule
    val rule = ActivityTestRule(CalcActivity::class.java)

    @Test
    fun `clear operation`() {
        listOf(
            R.id.button_2,
            R.id.button_add,
            R.id.button_2,
            R.id.button_c
        ).forEach { it.touch() }
        R.id.result.view().checkText("")
    }

    /**
     * ADD
     */
    @Test
    fun `add positive positive`() {
        // 2 + 2 = 4.0
        listOf(
            R.id.button_2,
            R.id.button_add,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("4.0")
    }

    @Test
    fun `add positive negative`() {
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
    fun `add negative positive`() {
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
    fun `add negative negative`() {
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
    fun `division positive positive`() {
        // 2 / 2 = 1.0
        listOf(
            R.id.button_2,
            R.id.button_division,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("1.0")
    }

    @Test
    fun `division positive negative`() {
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
    fun `division negative positive`() {
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
    fun `division negative negative`() {
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
    fun `division by zero`() {
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
    fun `multiply positive positive`() {
        // 2 * 3 = 6.0
        listOf(
            R.id.button_2,
            R.id.button_multiply,
            R.id.button_3,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("6.0")
    }

    @Test
    fun `multiply positive negative`() {
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
    fun `multiply negative positive`() {
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
    fun `multiply negative negative`() {
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
     * SUBTRACT
     */
    @Test
    fun `subtract positive positive`() {
        // 2 - 2 = 0.0
        listOf(
            R.id.button_2,
            R.id.button_substract,
            R.id.button_2,
            R.id.button_equal
        ).forEach { it.touch() }
        R.id.result.view().checkText("0.0")
    }

    @Test
    fun `subtract positive negative`() {
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
    fun `subtract negative positive`() {
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
    fun `subtract negative negative`() {
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