import java.lang.StringBuilder

/**
 * 1~100 babbling 의 길이
 * 1~30 babbling[i] 의 길이
 */
class Solution {
    fun solution(babbling: Array<String>): Int {
        //네가지 발음을 조합,연속으로는 안됨
        // "aya", "ye", "woo", "ma"

        var answer: Int = 0
        var diction = arrayOf("aya","ye","woo","ma")

        var list = babbling.toMutableList()
        var filteredList = listOf("")
        for(index in list.indices){
            //각 리스트에 diction 을 빼서 비어 있다면 count
            filteredList = diction.filter {list[index].contains(it)}

            //필터링된 리스트 값을 뺀다.
            for(f in filteredList){
                list[index] = list[index].substringAfter(f)
            }
        }
        answer = list.count{it==""}


        return answer
    }
}
fun main(){
    val a = Solution()
    a.solution(arrayOf("aya", "yee", "u", "maa"))
    a.solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"))
}