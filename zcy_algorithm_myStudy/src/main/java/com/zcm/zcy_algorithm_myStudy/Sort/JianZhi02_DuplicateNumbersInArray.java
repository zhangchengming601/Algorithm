package com.zcm.zcy_algorithm_myStudy.Sort;


import java.util.HashMap;
import java.util.Objects;

/**
 * 数组中的重复数字
 * https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&tqId=1375279&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi02_DuplicateNumbersInArray {
    public int duplicate (int[] numbers) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return numbers[i];
            }
            map.put(numbers[i],true);
        }
        return -1;
    }
}
