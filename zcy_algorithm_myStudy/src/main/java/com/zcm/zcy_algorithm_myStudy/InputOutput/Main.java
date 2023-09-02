package com.zcm.zcy_algorithm_myStudy.InputOutput;

    import java.util.Arrays;
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String s = in.nextLine();
                String[] date = s.split(",");
                Arrays.sort(date);
                System.out.println(String.join(",", date));
            }
        }
    }
