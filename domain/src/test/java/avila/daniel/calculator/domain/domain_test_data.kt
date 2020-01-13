package avila.daniel.calculator.domain

import avila.daniel.calculator.domain.model.Operands

const val OP1 = 2f
const val OP2 = 2f

const val ADD_RESULT = OP1 + OP2
const val DIVISION_RESULT = OP1 / OP2
const val MULTIPLY_RESULT = OP1 * OP2
const val SUBTRACT_RESULT = OP1 - OP2

val operands = Operands(OP1, OP2)