const val ERROR_LIMIT = -1.0
const val ERROR_TYPE = -2.0


const val TYPE_VISA = "visa"
const val TYPE_Vk = "vk PAY"
const val TYPE_mastercard = "mastercard"
var transfer = 10000
var transfermonth = 0

fun main() {


    //  val resault = calculation(TYPE_VISA, transfer, transfermonth)
    println(komission("visa",100_000,0))
}

fun komission(kard: String, transf: Int, transfmonth: Int): Double {
    return when (kard) {
        TYPE_Vk -> if (transf > 15_000 || transfmonth + transf > 40_000){
            ERROR_LIMIT
        }else 0.0
        TYPE_mastercard ,TYPE_VISA-> if (transf > 150_000 || transfmonth + transf > 600_000) {
            ERROR_LIMIT
        } else {
            if (transf <= 75_000) 0.0 else (transf * 0.006) + 20
        }
        else -> ERROR_TYPE
    }
}











// }