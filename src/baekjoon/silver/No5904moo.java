package baekjoon.silver;

import java.io.*;
import java.util.*;

public class No5904moo {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        moo(N);
    }

    public static void moo(int num){
        int side = 0;
        int middle = 3;

        while(num>middle+side*2){
            side=side+middle+side;
            middle++;
        }

        if(num==side+1){
            System.out.println("m");
        }else if(num>side+1&&num<=side+middle){
            System.out.println("o");
        }else{
            moo(num-side-middle);
        }
    }
}
