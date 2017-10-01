package baekjoon.p2438

fun main(args: Array<String>) {
    val num = readLine()!!.toInt();
    for(i in 1..num){
        print("*".repeat(i));
        println();
    }
}