package com.zcm.zcy_algorithm_myStudy.MyTest;


import java.util.Scanner;

public class Shein_0913 {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int i = in.nextInt();
//        int[][] arr = new int[i][2];
//        in.nextLine();
//        for(int j=0;j<i;j++){
//            String s = in.nextLine();
//            String[] split = s.split(" ");
//            arr[j][0]=Integer.valueOf(split[0]);
//            arr[j][1]=Integer.valueOf(split[1]);
//        }
//        System.out.println(process(arr));
//    }


    public static int process(int[][] arr){
        int res=0;
        int linPai = 100;
        int shike = 0;
        int preShike =0;
        for(int i=0;i<arr.length;i++){
            int shiKe = arr[i][0] - preShike;
            preShike = arr[i][0];
//            if(shiKe%100 !=0){
//                String s=String.valueOf(shike);
//                shike = (int) (Integer.valueOf(s.charAt(0))*Math.pow(10,s.length()-1));
//            }
            linPai = linPai + (shiKe/100)*10;
            if(linPai>150){
                linPai=150;
            }
            if (linPai-arr[i][1]<0){
                res+=-(linPai-arr[i][1]);
                linPai=0;
            }else {
                linPai=linPai-arr[i][1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        System.out.println(process(split[0],Integer.valueOf(split[1])));
    }

    public static String process(String s,int row){
        Character[][] arr = new Character[row][s.length()];

        int rowIndex=0;
        int colIndex=0;
        boolean shang = false;
        for(int i=0;i<s.length();i++){
            if(shang){
                rowIndex--;
                colIndex++;
                arr[rowIndex][colIndex] = s.charAt(i);
                if(rowIndex==0){
                    rowIndex++;
                    colIndex++;
                    shang=false;
                }
                continue;
            }
            arr[rowIndex][colIndex] = s.charAt(i);
            if(rowIndex==row-1){
                shang=true;
                continue;
            }
            rowIndex++;
        }

        Character[] resC = new Character[s.length()];
        int j=0;
        while(j<resC.length){
            for(int i=0;i<arr.length;i++){
                for(int u=0;u<arr[0].length;u++){
                    if(arr[i][u]!='\0'){
                        resC[i]=arr[i][u];
                    }
                }
            }
        }
        return String.valueOf(resC);
    }



}
