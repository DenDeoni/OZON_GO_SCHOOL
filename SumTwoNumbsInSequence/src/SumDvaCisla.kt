import java.io.File
import java.util.*

fun main() {

    val bufferedReader = File("input.txt").bufferedReader()
    val lineList = mutableListOf<String>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
    val target = lineList[0].toInt()
    val seqList = lineList[1]
    val seq = mutableListOf<Int>()
    val scan = Scanner(seqList).useDelimiter(" ")
    val writer = File("output.txt").bufferedWriter()
    for (part in scan) {
        if (part.toInt() < target) seq.add(part.toInt())
    }
    seq.sort()
    val len = seq.size

    outerLoop@ for (i in (len - 1) downTo 0) {
        for (j in 0 until len) {

            val sum = seq[i] + seq[j]

            if (sum == target) {
                writer.write("1")
                break@outerLoop
            }

            if ((sum) > target || (sum < target &&  i <= 0 )) {
                writer.write("0")
                break@outerLoop
            }
        }
    }
    writer.close()
}

/*fun main() {

    val bufferedReader = File("input.txt").bufferedReader()
    val seq = mutableListOf<Int>()
    var target = 0
    var i = 1
    var first = 0
    bufferedReader.useLines { lines ->

        lines.forEach {

            val scan = Scanner(it).useDelimiter(" ")

            for (part in scan) {

                if (i == 1) {
                    first = part.toInt()
                    i++
                }
                if (part.toInt() < first) {
                    seq.add(part.toInt())
                } else {
                    target = part.toInt()
                }
            }
        }
    }

    var result = false

    seq.sort()
    val len = seq.size
    for (i in (len - 1) downTo 0) {
        for (j in 0 until len) {
            if (seq[i] + seq[j] == target) {
                result = true
                break
            }

            if (seq[i] + seq[j] > target) break
        }
        if (result) break
    }

    val writer = File("output.txt").bufferedWriter()
    if (result) writer.write("1") else writer.write("0")
    writer.close()
}*/

/*    val len = sequence.size
    var count = 0
    for (i in 0 until len) {
        for (j in i + 1 until len) {
            val sum = (sequence[i] + sequence[j])
            if (sum == target) {
                count++
            }
        }
    }*/
//Array(9) { i -> (i + 1) }.forEach { println("число $it ${if (it % 2 == 0) "четное" else "нечетное"}") }
//Array(9) { i -> (i + 1) }.forEach {print ("число $it"); if(it%2 == 0)  println (" четное") else println(" нечетное")}
//val intArray = Array(1){for (i in 1 .. 9)  if(i%2 == 0) println ("число $i четное") else println ("число $i нечетное")}
//print(array.joinToString())