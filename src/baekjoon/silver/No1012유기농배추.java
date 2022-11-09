package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1012유기농배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            //0.입력
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int column =Integer.parseInt(st.nextToken());
                map[row][column] = 1;
            }
            //1. 전체 순환
//            traceMap(map);
            //2. 조건 판단
            //3. 출력
            bw.write(String.valueOf(traceMap(map)));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
    //배추있는 곳을 조사해서 붙어있으면 전부 0으로 만든다.
    public static void changeBaechu(int[][] map, int row, int column){
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        map[row][column]=0;
        rowQueue.add(row);
        columnQueue.add(column);
        while(!rowQueue.isEmpty()){
            row=rowQueue.poll();
            column=columnQueue.poll();
            checkBaechu(map,row,column,rowQueue,columnQueue);
        }
    }
    //배추가 있는 곳을 찾는다 (동서남북)
    public static void checkBaechu(int[][] map, int row, int column, Queue rowQueue, Queue columnQueue){
        if(column+1<map[0].length&&map[row][column+1]==1){
            map[row][column+1]=0;
            rowQueue.add(row);
            columnQueue.add(column+1);
        }
        if(column-1>=0&&map[row][column-1]==1){
            map[row][column-1]=0;
            rowQueue.add(row);
            columnQueue.add(column-1);
        }
        if(row+1<map.length&&map[row+1][column]==1){
            map[row+1][column]=0;
            rowQueue.add(row+1);
            columnQueue.add(column);
        }
        if(row-1>=0&&map[row-1][column]==1){
            map[row-1][column]=0;
            rowQueue.add(row-1);
            columnQueue.add(column);
        }
    }
    //배추 밭을 순환한다.
    public static int traceMap(int[][] map){
        int cnt = 0;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (map[row][column] == 1) {
                    cnt++;
                    changeBaechu(map,row,column);
                }
            }
        }
        return cnt;
    }
}
