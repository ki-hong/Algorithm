package baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class No2096내려가기 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        long [] beforeMax= new long[3];
        long [] Max = new long[3];
        long [] beforeMin = new long[3];
        long [] Min = new long[3];
        st = new StringTokenizer(br.readLine());
        beforeMax[0] = Long.parseLong(st.nextToken());
        beforeMin[0] = beforeMax[0];
        beforeMax[1] = Long.parseLong(st.nextToken());
        beforeMin[1] = beforeMax[1];
        beforeMax[2] = Long.parseLong(st.nextToken());
        beforeMin[2] = beforeMax[2];

        for(int i =1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<3; j++){
                long current = Long.parseLong(st.nextToken());
                if(j==0){
                    Max[0]=Math.max(beforeMax[0],beforeMax[1])+ current;
                    Min[0]=Math.min(beforeMin[0],beforeMin[1])+current;
                }
                if(j==1){
                    Max[1]=Math.max(Math.max(beforeMax[0],beforeMax[1]),beforeMax[2])+ current;
                    Min[1]=Math.min(Math.min(beforeMin[0],beforeMin[1]),beforeMin[2])+current;
                }
                if(j==2){
                    Max[2]=Math.max(beforeMax[1],beforeMax[2])+ current;
                    Min[2]=Math.min(beforeMin[1],beforeMin[2])+current;
                }
            }
            for (int j = 0; j < 3; j++) {
                beforeMax[j]=Max[j];
                beforeMin[j]=Min[j];
            }
        }

        bw.write(Math.max(Math.max(beforeMax[0],beforeMax[1]),beforeMax[2])+" "+Math.min(Math.min(beforeMin[0],beforeMin[1]),beforeMin[2]));

        bw.flush();
        bw.close();
    }
}
