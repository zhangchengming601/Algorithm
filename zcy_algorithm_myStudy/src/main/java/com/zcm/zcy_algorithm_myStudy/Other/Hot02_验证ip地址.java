package com.zcm.zcy_algorithm_myStudy.Other;

public class Hot02_验证ip地址 {
    public static String solve (String IP) {
        String[] ipv4 = IP.split("\\.");
        String[] ipv6 = IP.split("\\:");
        char begin = IP.charAt(0);
        char end = IP.charAt(IP.length() - 1);
        if(begin=='.' || begin==':' || end=='.' || end==':'){
            return "Neither";
        }
        if (ipv4.length!=4 && ipv6.length!=8){
            return "Neither";
        }

        if (ipv4.length==4){
            for(int i=0;i<4;i++){
                String cur = ipv4[i];
                // 检查当前字符串首位是不是0
                if (cur.charAt(0)=='0'){
                    return "Neither";
                }
                int sum=0;
                for(int j=0;j<cur.length();j++){
                    sum= (int) (sum+(cur.charAt(j)-'0')*(Math.pow(10,(cur.length()-j-1))));
                }
                if(sum>0 && sum<=255){
                    continue;
                }else {
                    return "Neither";
                }
            }
            return "IPv4";
        }

        if (ipv6.length==8){
            for(int i=0;i<8;i++){
                String cur = ipv6[i];
                // 检查当前字符串长度是否为4
                if(cur.length()>4 || cur.length()<=0){
                    return "Neither";
                }
                for(int j=0;j<cur.length();j++){
                    if((cur.charAt(j)>='a' && cur.charAt(j)<='z') || (cur.charAt(j)>='A' && cur.charAt(j)<='Z') || (cur.charAt(j)>='0'&&cur.charAt(j)<='9')){
                        continue;
                    }else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        String s="20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        solve(s);
    }
}
