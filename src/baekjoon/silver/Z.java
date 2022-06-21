package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = (int)Math.pow(2, n);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int cnt = 0;
        findZ(n,0,0, cnt,r,c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    public static void findZ(int depth,int row, int columm, int cnt,  int r, int c){
        if(depth==1){
            for(int i = row; i<row+2; i++){
                for(int j =columm; j<columm+2; j++ ){
                    if(i==r&&j==c) result=cnt;
                    cnt++;
                }
            }
            return;
        }
        int cur =(int)Math.pow(2, depth);
        int aft =(int)Math.pow(2, depth-1);
        for(int i = row; i<row+cur; i+=aft){
            for(int j = columm; j<columm+cur; j+=aft){
                if(i<=r&&r<i+aft&&j<=c&&c<j+aft) {
                    findZ(depth - 1, i, j,cnt,r,c);
                }else{
                    cnt+=aft*aft;
                }
            }
        }
    }

}
