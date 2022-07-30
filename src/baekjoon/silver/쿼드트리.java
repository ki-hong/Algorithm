package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        String line = "";
        for(int i = 0; i<N; i++){
            line = br.readLine();
            char[] cArr = line.toCharArray();
            for(int j = 0; j<line.length(); j++) {
                arr[i][j]=cArr[j]-'0';
            }
        }
        divide(N,0,0);
        if(answer.equals("(0000)")) answer = "0";
        if(answer.equals("(1111)")) answer = "1";

        bw.write(answer);
        bw.flush();
        bw.close();
    }

    public static void divide(int length,int rowIdx, int columnIdx){
        if(length==1){
            answer+=arr[rowIdx][columnIdx];
            return;
        }
        int chk = -1;
        boolean trigger;
        answer+="(";
        for(int i = 1; i<=2; i++){
            for(int j = 1; j<=2; j++){
                trigger=true;
                chk = arr[rowIdx+(i-1)*length/2][columnIdx+(j-1)*length/2];
                for(int k = rowIdx+(i-1)*length/2; k<rowIdx+i*length/2; k++){
                    for(int l = columnIdx+(j-1)*length/2; l<columnIdx+j*length/2; l++){
                        if(chk!=arr[k][l]){
                            trigger=false;
                            break;
                        }
                    }
                    if(!trigger) break;
                }
                if(trigger) answer+=chk;
                if(!trigger) divide(length/2,rowIdx+(i-1)*length/2,columnIdx+(j-1)*length/2);
            }
        }
        answer+=")";
    }

}

