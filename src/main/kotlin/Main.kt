fun main() {
    println("Введите элементы первого массива:")
    val array1 = readIntArray()

    println("Введите элементы второго массива:")
    val array2 = readIntArray()

    val intersection = findIntersection(array1, array2)

    println("Пересечение массивов: ${intersection.contentToString()}")
}

fun readIntArray(): IntArray {
    return readLine()?.split(" ")?.map { it.toInt() }?.toIntArray() ?: intArrayOf()
}

fun findIntersection(array1: IntArray, array2: IntArray): IntArray {
    val map1 = countOccurrences(array1)
    val map2 = countOccurrences(array2)

    val intersection = mutableListOf<Int>()

    for ((key, value) in map1) {
        val count = minOf(value, map2.getOrDefault(key, 0))
        repeat(count) {
            intersection.add(key)
        }
    }

    return intersection.toIntArray()
}

fun countOccurrences(array: IntArray): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()

    for (element in array) {
        val count = map.getOrDefault(element, 0)
        map[element] = count + 1
    }

    return map
}