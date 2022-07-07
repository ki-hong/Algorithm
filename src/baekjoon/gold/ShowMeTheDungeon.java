package baekjoon.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShowMeTheDungeon {
    static int n;
    static int k;
    static int[] A;
    static int[] P;
    static long max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //마을의 개수
        n=Integer.parseInt(st.nextToken());
        //체력
        k=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        A = new int[n];
        P = new int[n];
        for(int i =0; i<n; i++){
            A[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st2.nextToken());
        }

        for(int i= 0; i<n; i++){
            if(k>=A[i]){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                if(max<P[i]) max=P[i];
                dfs(list,A[i],P[i],k-A[i]);

            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
    public static void dfs(ArrayList<Integer> list, int sum, int people, int k){
        if(k<sum) return;
        for(int i =0; i<n;i++){
            if(!list.contains(i)&&k>=sum+A[i]){
                list.add(i);
                sum+=A[i];
                k-=sum;
                people+=P[i];
                if(max<people) max=people;
                dfs(list,sum,people,k);
                people-=P[i];
                k+=sum;
                sum-=A[i];
                list.remove((Integer)i);
            }
        }
    }
}
