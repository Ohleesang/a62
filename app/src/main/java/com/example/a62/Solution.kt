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
        var filteredList :List<String>
        var exFilteredList = List<String>(list.size,{""}).toMutableList()
        // 이전 필터된 마지막 문자들
        var count = 0
        // while인데.... 언제 멈춰야하지?
        // -->filtered 가 더이상 되지 않는경우?
        while(true) {
            for (index in list.indices) {
                //각 리스트에 diction 이 포함되어 있으면 걸러낸다.
                filteredList = diction.filter { list[index].contains(it) }

                //필터링된 리스트 값을 뺀다.
                if (filteredList.isEmpty()) count++
                else {

                    for (f in filteredList) {
                        //이전과 같으면 시행되면안된다!!
                        if(exFilteredList[index]==f) {
                            list[index]="-1"
                            break
                        } //더이상 계산필요 x
                        else {
                            list[index] = list[index].replaceFirst(f, "")
                            exFilteredList[index] = f
                            break
                        }
                    }
                }
            }
            if(count>=list.size) break

            //값 초기화
            count = 0
        }




        answer = list.count{it==""}


        return answer
    }
}
fun main(){
    val a = Solution()
//    a.solution(arrayOf("aya", "yee", "u", "maa"))//1
//    a.solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"))//2
//    a.solution(arrayOf("maya"))//0
    a.solution(arrayOf("ayayeayayeaya"))//1
    a.solution(arrayOf("yeyema"))//0
}