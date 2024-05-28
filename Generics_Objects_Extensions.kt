enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

class Quiz : ProgressPrintable {
    override val progressText: String
    	get() = "${Quiz.answered} of ${Quiz.total} answered."
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
	val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
	val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
	}
    
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
    
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

fun main() {
   	Quiz().printProgressBar()
    println()
    
    Quiz().apply {
        printQuiz()
	}
}