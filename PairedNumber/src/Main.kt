import java.io.File

fun main() {

    val bufferedReader = File("input-201.txt").bufferedReader()
    val lineList = mutableListOf<String>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }

    fun returnResult(): String {

        for (i in 0 until lineList.size) {
            val tmp = lineList.filter { it == lineList[i] }
            if (tmp.size == 1) return lineList[i]
        }

        return ""
    }
    val writer = File("input-201.a.txt").bufferedWriter()
    writer.write(returnResult())
    writer.close()
}