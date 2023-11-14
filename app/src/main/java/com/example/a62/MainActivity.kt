package com.example.a62

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            var diction = arrayOf<String>("aya", "ye", "woo", "ma")

            fun checkDiction(s : String):Boolean{
                var answer = false
                var str: String = s
                var list :List<String> = mutableListOf()
                    for(index in 0..3) {
                        if (str.contains(diction[index])){
                            list = str.split(diction[index],ignoreCase = false,limit =2)
                            str=list[1]

                        }
                    }
                if(str=="") answer = true
                return answer
            }

            fun solution(babbling: Array<String>): Int {
                //네가지 발음을 조합,연속으로는안됨
                // "aya", "ye", "woo", "ma"
                var answer: Int = 0

                for(i in 0..babbling.size-1){
                    if(checkDiction(babbling[i])) answer++
                }



                return answer
            }
        }
        val a = Solution()
        a.solution(arrayOf("aya", "yee", "u", "maa"))
        a.solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"))
    }
}