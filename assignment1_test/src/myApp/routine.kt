package myApp

class Routine (var score: Int = 0, var element: Int = 0, var canContinue: Boolean = true){


    fun buttonPressed(button: String?) {
        if (!canContinue) {
            when (button) {
                "deduction" -> deduction()
                "preform" -> preform()
                "reset" -> reset()
            }
            if (button == "deduction") {
                canContinue = false
            }
        }
    }

    fun reset(){
        score = 0
        element =0
        canContinue = true
    }

    fun deduction() {
        when (element){
            0 -> score
            1 -> score = 0
            2 -> score = 0
            3,4,5,6,7,8,9 -> score--
        }
        canContinue = false
    }
    fun preform(){
        addition()
        if(element>=9){
            canContinue = false
        }
        element++
    }

    fun addition(){
        when (element){
            0,1,2 -> score++
            3,4,5,6 -> score += 2
            7,8,9 -> score += 3
        }
    }
}