package com.zcm.zcy_algorithm_myStudy.Sort;

public class Hot01_比较版本号 {
    public int compare (String version1, String version2) {
        int i=0;
        int j=0;

        int v1=version1.length();
        int v2=version2.length();


        // 两个字符串，只要有一方还没到终点，则继续进行
        while(i<v1 || j<v2){
            // 先获得version1的该段的数字（如果version1的指针到终点了，则num1就是0）
            int num1=0;
            while(i<v1 && version1.charAt(i)!='.' ){
                num1 = num1*10 + version1.charAt(i)-'0';
                i++;
            }
            // 跳过 '.'
            i++;

            // 获得version2的该段的数字（如果version2的指针到终点了，则num2就是0）
            int num2 = 0;
            while(j<v2 && version2.charAt(j)!='.' ){
                num2 = num2*10 + version2.charAt(j)-'0';
                j++;
            }
            j++;

            // 比较两个数字的大小
            if (num1==num2){
                continue;
            }else if(num1<num2){
                return -1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}
