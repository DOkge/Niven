package org.dokge.niven.Utils

class Niven {
    companion object{
        fun isValid(value : Int) : Boolean{
            var sum = Array.sumOfItems(Numeral.toDigits(value))
            if(sum == 0) return false;
            var result : Boolean = (value%sum==0)
            return result
        }
    }
}