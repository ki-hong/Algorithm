package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1389케빈베이컨6단계법칙 {
    /**
     * 문제 유형 : Graph
     * 엣지 카운트
     * 모든 관계의 사람과 다 케빈베이컨 수를 구하여 합이 가장 작은 인원을 구하라
     * 그래프에는 노드가 있고
     * 인접한 노드들로 관계가 설정이 된다.
     * bfs로 진행박식을 설정할 것 (최소가 되기 위해서)
     */

    public static void main(String[] args) throws IOException {
        //0. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] friendship = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            friendship[first][second]=1;
            friendship[second][first]=1;
        }

        int result=bfs(friendship,N);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int bfs(int[][] friendship, int N){
        int minSum=0;
        int minNumber=N+1;
        for (int i = 1; i < N+1; i++) {
            boolean[] marked = new boolean[N+1];
            int[] count = new int[N+1];
            Queue<Integer> queue= new LinkedList<>();
            Queue<Integer> nextLevel = new LinkedList<>();
            queue.add(i);
            marked[i]=true;
            int cnt = 1;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for (int j = 1; j < N+1; j++) {
                    if(!marked[j]&&friendship[node][j]==1){
                        nextLevel.add(j);
                        marked[j]=true;
                        count[j]=cnt;
                    }
                }
                if(queue.isEmpty()){
                    while(!nextLevel.isEmpty()){
                        queue.add(nextLevel.poll());
                    }
                    cnt++;
                }
            }
            int sum = 0;
            for (int j = 1; j < N+1; j++) {
                sum+=count[j];
            }
            if(i==1){
                minSum=sum;
                minNumber=i;
            }
            if(minSum>sum){
                minSum=sum;
                minNumber=i;
            }
        }
        return minNumber;
    }
}

