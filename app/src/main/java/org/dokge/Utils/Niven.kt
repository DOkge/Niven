package org.dokge.Utils

/**
 * @author dokge
 */
class Niven {
    companion object{
        /**
         * checks if the number is a niven number
         */
        fun isValid(value : Int) : Boolean{
            var sum = Array.sumOfItems(Numeral.toDigits(value))
            if(sum == 0) return false
            var result : Boolean = (value%sum==0)
            return result
        }
    }
}