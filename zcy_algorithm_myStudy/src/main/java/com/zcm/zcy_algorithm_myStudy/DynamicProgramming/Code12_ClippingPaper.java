package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目：剪纸拼词  leetcode：https://leetcode.cn/problems/stickers-to-spell-word/
 *
 * 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文
 * arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
 * 返回需要至少多少张贴纸可以完成这个任务？
 * 例子：str= “babac”，arr = {“ba”,“c”,“abcd”}
 * ba + ba + c 3 abcd + abcd 2 abcd+ba 2
 * */
public class Code12_ClippingPaper {

    public static int getAnswer1(String[] stickers , String target){
        int n = stickers.length;

        int[][] map = new int[n][26];
        for (int i=0 ; i<stickers.length ; i++){
            char[] str = stickers[i].toCharArray();
            for (char c : str){
                map[i][c-'a']++;
            }
        }

        HashMap<String, Integer> dp = new HashMap<>();

        // 递归过程的终止条件
        dp.put("",0);

        return prrocess1(dp,map,target);
    }


    /**
     * HashMap<String,Integer> dp : 傻缓存。如果rest已经算过了，则直接返回缓存中的数据
     * String rest : 剩余的字符串
     * int[][] map : map是 stickers中每个字符串所含的字符的词频统计
     *
     * 规定如果函数的返回值是-1，则表明map数组中元素是无论如何都无法搞定rest
     * */
    public static int prrocess1(HashMap<String,Integer> dp , int[][] map , String rest){

        // 如果此时的rest已经算过了，则直接返回缓存中的结果
        if (dp.containsKey(rest)){
            return dp.get(rest);
        }

        // 如果rest没有算过，则走下面的递归调用过程

        int ans = Integer.MAX_VALUE;   // ans 就是此方法需要返回搞定rest，需要使用的最少的贴纸的数量
        int n = map.length;   // n 就是贴纸的数量

        // 将字符串rest转为词频的形式  rest -> tmap
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for (char c : target){
            tmap[c-'a']++;
        }

        // for循环，枚举当前使用的第一张贴纸是谁？ i：表示的就是使用了第几张贴纸
        for (int i=0 ; i<n ; i++){

            // 就是说当前贴纸，至少含有一个target中的字符，否则，当前for循环结束。
            // 换句话说就是 当前贴纸中至少含有一种target中的字符，我才有必要接着试
            if (map[i][target[0]-'a'] == 0) {   // if 中的判断意思是，target[0]位置的字符，在贴纸中有没有
                continue;
            }

            StringBuilder sb = new StringBuilder();
            // for循环，j：枚举a b ...z 字符
            for (int j=0 ; j<26 ; j++){
                if (tmap[j]>0){  // 如果tmap[j]这个位置还存在没有处理的字符
                    // 现在我们使用了第i张贴纸，map[i][j] 表示第i张贴纸上j处字符的数量
                    // tmap[j] 表示我们的rest字符串中字符j需要多少个
                    // 假如表示第i张贴纸上j处字符的数量为5，rest字符串中字符j需要7个，则我们就在新的字符串中添加两个jj (因为剩下5个已经被map[i][j]抵消了)
                    for (int k=0 ; k<Math.max(0,tmap[j]-map[i][j]);k++){
                        sb.append((char)('a'+j));
                    }
                }
            }
            // 被第i个贴纸抵消后的字符串，就是sb了
            String s = sb.toString();

            // 调用递归函数，继续解决剩下的字符
            int tmp = prrocess1(dp,map,s);
            if (tmp != -1){
                ans = Math.min(ans,1+tmp);
            }
        }
        dp.put(rest , ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);
    }
}
