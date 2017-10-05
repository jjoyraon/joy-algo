//https://www.acmicpc.net/problem/1193
package baekjoon.p1193

fun main(args: Array<String>) {
    val num = readLine()!!.toInt();
    var edge = 0;
    var size = 1;
    while(edge < num){
        edge += size;
        size++;
    }
    size--;
    edge = edge - size;

    var upValue = when{
        size%2==0 -> num - edge;
        else -> size - (num - edge) + 1;
    }

    var downValue = when{
        size%2==0 -> size - (num - edge) + 1;
        else -> num - edge;

    }
    println(upValue.toString() + "/" + downValue.toString());
}
