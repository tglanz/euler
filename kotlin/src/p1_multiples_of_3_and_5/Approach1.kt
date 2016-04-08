package p1_multiples_of_3_and_5

import fw.Approach

class Approach1 : Approach {

    private val MAX_NUMBER = 1000;

    override fun solve() {
        var sum = 0
        for (idx in 3..MAX_NUMBER){
            if (idx % 3 == 0 || idx % 5 == 0){
                sum += idx
            }
        }

        println("The sum up to $MAX_NUMBER is $sum")
    }

    override fun desc(): String {
        return "Just loop and check each index for division"
    }

}