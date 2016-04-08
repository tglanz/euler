import fw.Approach
import fw.Problem
import fw.Problems

fun main(args: Array<String>){
    println("Project euler")

    println("Bootsrapping all problems")
    Problems.boostrap()

    while (next()){
        println("")
    }
}

fun printProblems(){
    Problems.problems
            .sortedBy{ problem ->  problem.id }
            .forEach { problem -> println("${(problem.id.toString() + ".").padEnd(2)} ${problem.name}") }
}

fun next(): Boolean{

    printProblems()
    val input = readLine()

    if (shouldExit(input)){
        return false
    }

    if (input == null){
        println("Nothing is determined")
    } else {
        eval(input)
    }

    return true
}

fun shouldExit(input: String?): Boolean{

    if (input == null) return false

    return input.equals("Exit", true)
}

fun eval(input: String){

    var shouldEvalByName = false

    try {
        try {
            val id: Int = input.toInt()

            shouldEvalByName = !evalById(id)
        } catch (error: NumberFormatException) {
            shouldEvalByName = true
        }
    }catch (error: Throwable){
        println("Error: ${error.message}")
    }

    if (shouldEvalByName){
        if (evalByName(input) == false){
            println("Unable to determine problem for input: $input")
        }
    }

}

fun evalByName(name: String): Boolean{
    println("Trying to eval by name")

    val problem = Problems.problems.filter { problem -> problem.name.equals(name, true) }.singleOrNull()

    if (problem == null){
        return false
    }

    executeProblem(problem)

    return true
}

fun evalById(id: Int): Boolean{
    println("Trying to eval by id")

    val problem = Problems.problems.filter { problem -> problem.id == id }.singleOrNull()

    if (problem == null){
        return false
    }

    executeProblem(problem)

    return true
}

fun executeProblem(problem: Problem){
    println("Executing problem: ${problem.name}")

    val approach = selectApproach(problem)

    executeApproach(approach)
}

fun selectApproach(problem: Problem): Approach{
    if (problem.approaches.count() == 1){
        return problem.approaches.first()
    } else {
        for ((approach, idx) in problem.approaches.withIndex()){
            val i = idx as Int
            println("${i + 1}. ${approach.dec()}")
        }

        val input = readLine() ?: throw Error("Invalid approach index selected")
        return problem.approaches[input.toInt() - 1]
    }
}

fun executeApproach(approach: Approach){
    println("Approach description: ${approach.desc()}")
    approach.solve()
}