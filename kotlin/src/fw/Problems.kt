package fw

import java.util.*

class Problems{
    companion object Factory{
        val problems: ArrayList<Problem> = ArrayList<Problem>()

        fun boostrap(){
            val p1 = Problem(1, "Multiples of 3 and 5")
            p1.approaches.add(p1_multiples_of_3_and_5.Approach1())
            problems.add(p1);
        }
    }
}
