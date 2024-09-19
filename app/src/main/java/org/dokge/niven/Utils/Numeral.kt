package org.dokge.niven.Utils

class Numeral {
    companion object {
        fun lengthOfNumeral(value: Int): Int {
            var str: String = value.toString()
            return str.length
        }

        fun toDigits( IValue : Int) :  IntArray{
            var value = IValue
            val length = lengthOfNumeral(value)
            var digits = IntArray(length)
            for (i in 0..<length){
                digits[i] = value%10
                value/=10
            }
            return digits
        }
    }
}