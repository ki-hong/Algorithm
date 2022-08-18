package baekjoon.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2206벽부수고이동하기 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i<N; i++){
            char[] cArr= br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j]=cArr[j]-'0';
            }
        }
        ///입력 완료
        //1. 이동 시의 조건,
        //1) 벽 부수기의 유무 판단 (boolean)
        boolean broken = false;
        //2) 갈 수 있는 곳 판단 (used[])
        boolean[][][] used = new boolean[N][M][2];
        //2-1) 0인 곳
        //2-2) 벽 부수기가 있다면 벽인 곳도 포함
        Queue<Object[]> queue = new LinkedList<>();
        Queue<Object[]> nextQueue = new LinkedList<>();
        //처음 지점도 넣어주고 시작
        //row,column,borken(boolean)
        queue.add(new Object[]{0,0,false});
        Object[] nodeContent;
        int row=0;
        int column=0;
        int depth=1;
        used[row][column][1]=true;
        used[row][column][0]=true;
        while(!queue.isEmpty()){
            nodeContent=queue.poll();
            row=(int)nodeContent[0];
            column=(int)nodeContent[1];
            broken=(boolean) nodeContent[2];
            if(row==N-1&&column==M-1) break;
            chkUse(row,column,nextQueue,broken,used);
            if(queue.isEmpty()){
                if(nextQueue.isEmpty()){
                    depth=-1;
                    break;
                }
                while(!nextQueue.isEmpty()){
                    queue.add(nextQueue.poll());
                }
                depth++;
            }
        }
        bw.write(String.valueOf(depth));

        //3) 이동 후 이동했던 자리는 다른 수로 변경 or boolean[] used -> 다시 복구를 시킬 필요가 있나? 없을 것으로 예상
        //3-1 ) 벽을 부쉈다가 다시 돌아왔다면 다시 false로 ->? 여기 벽이였어 ?
        //4) 만약 도달했다면, result 값과 비교하여 작은수를 다시 result


        bw.flush();
        bw.close();
    }

    public static void chkUse(int row, int column, Queue<Object[]> queue, boolean broken, boolean[][][] used){
        if(!broken){
            if(row-1>=0&&!used[row-1][column][0]){
                if(map[row-1][column]==1){
                    queue.add(new Object[]{row-1,column,true});
                    used[row-1][column][1]=true;
                }
                if(map[row-1][column]==0){
                    queue.add(new Object[]{row-1,column,false});
                    used[row-1][column][0]=true;
                }
            }
            if(column+1<M&&!used[row][column+1][0]){
                if(map[row][column+1]==1){
                    queue.add(new Object[]{row,column+1,true});
                    used[row][column+1][1]=true;
                }
                if(map[row][column+1]==0){
                    queue.add(new Object[]{row,column+1,false});
                    used[row][column+1][0]=true;
                }
            }
            if(row+1<N&&!used[row+1][column][0]){
                if(map[row+1][column]==1){
                    queue.add(new Object[]{row+1,column,true});
                    used[row+1][column][1]=true;
                }
                if(map[row+1][column]==0){
                    queue.add(new Object[]{row+1,column,false});
                    used[row+1][column][0]=true;
                }
            }
            if(column-1>=0&&!used[row][column-1][0]){
                if(map[row][column-1]==1){
                    queue.add(new Object[]{row,column-1,true});
                    used[row][column-1][1]=true;
                }
                if(map[row][column-1]==0){
                    queue.add(new Object[]{row,column-1,false});
                    used[row][column-1][0]=true;
                }
            }
        }
        if(broken){
            if(row-1>=0&&!used[row-1][column][1]){
                if(map[row-1][column]==0){
                    queue.add(new Object[]{row-1,column,true});
                    used[row-1][column][1]=true;
                }
            }
            if(column+1<M&&!used[row][column+1][1]){
                if(map[row][column+1]==0){
                    queue.add(new Object[]{row,column+1,true});
                    used[row][column+1][1]=true;
                }
            }
            if(row+1<N&&!used[row+1][column][1]){
                if(map[row+1][column]==0){
                    queue.add(new Object[]{row+1,column,true});
                    used[row+1][column][1]=true;
                }
            }
            if(column-1>=0&&!used[row][column-1][1]){
                if(map[row][column-1]==0){
                    queue.add(new Object[]{row,column-1,true});
                    used[row][column-1][1]=true;
                }
            }
        }
    }
}
