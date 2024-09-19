package org.dokge.niven.Utils

class Array {
    companion object{
        fun sumOfItems(items : IntArray) : Int{
            var sum : Int = 0
            for(i in 0..<items.size){
                sum +=items[i]
            }
            return sum
        }
    }
}