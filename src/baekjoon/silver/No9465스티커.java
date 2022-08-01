package baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No9465스티커 {
    static int T;
    static ArrayList<int[][]> list= new ArrayList<>();
    static ArrayList<int[][]> dplist= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int i = 0; i<T; i++){
            st=new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int[][] iarr= new int[2][column+1];
            int[][] dp= new int[2][column+1];
            st=new StringTokenizer(br.readLine());
            StringTokenizer st2= new StringTokenizer(br.readLine());
            for(int j = 1; j<=column; j++){
                iarr[0][j]=Integer.parseInt(st.nextToken());
                iarr[1][j]=Integer.parseInt(st2.nextToken());
            }
            list.add(iarr);
            dplist.add(dp);
        }

        for(int i =0; i<T; i++){
            int[][] arr = list.get(i);
            int[][] dp = dplist.get(i);
            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int k =2; k<arr[0].length; k++){
                dp[0][k] = Math.max(dp[1][k-1],dp[1][k-2]) + arr[0][k];
                dp[1][k] = Math.max(dp[0][k-1],dp[0][k-2]) + arr[1][k];
            }
            bw.write(Math.max(dp[0][arr[0].length-1], dp[1][arr[0].length-1])+"");
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}
