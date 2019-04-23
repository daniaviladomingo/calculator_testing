package avila.daniel.calculator

import avila.daniel.calculator.ui.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Robolectric


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class CalcActivityUnitTest {
    private val mainActivity = Robolectric.setupActivity(MainActivity::class.java)

    @Test
    fun `add with +op1 & +op2 is correct`() {
        mainActivity.button_3.performClick()
        mainActivity.button_add.performClick()
        mainActivity.button_4.performClick()
        mainActivity.button_equal.performClick()

        assertThat(mainActivity.result.text.toString(), `is`("7"))

    }
}
