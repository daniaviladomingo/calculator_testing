package avila.daniel.calculator.model

enum class Operator constructor(val operator: Char) {
    ADD('+'),
    DIVISION('/'),
    MULTIPLY('*'),
    SUBSTRACT('-');

    companion object {
        fun valueFor(operator: Char): Operator = Operator.values().first { it.operator == operator }
    }
}