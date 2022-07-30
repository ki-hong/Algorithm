package baekjoon.gold;

import java.io.*;
import java.util.Arrays;

public class No2447별찍기 {
    static int N;
    static String[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        answer= new String[N][N];

        for(int i = 0; i<N; i++){
            Arrays.fill(answer[i]," ");
        }
        printStar(N,0,0);

        for(int i =0; i<N; i++){
            for(int j = 0; j<N; j++){
                bw.write(answer[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void printStar(int length, int row, int column){
        if(length==3){
            for(int i = row; i<row+3; i++){
                for(int j = column; j<column+3; j++){
                    if(!(i%3==1&&j%3==1)){
                        answer[i][j]="*";
                    }
                }
            }
            return;
        }
        for(int i=1; i<=3; i++){
            for(int j=1; j<=3; j++){
                if(!(i==2&&j==2)){
                    printStar(length/3,row+(i-1)*length/3,column+(j-1)*length/3);
                }
            }
        }


    }
}
