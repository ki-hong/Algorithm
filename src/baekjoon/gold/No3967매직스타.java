package baekjoon.gold;

import java.io.*;
import java.util.LinkedList;

public class No3967매직스타 {
    static char[][] star = new char[5][9];
    static boolean[] used = new boolean[13];
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<Integer> answer = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i= 0; i<5; i++){
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j<9; j++){
                star[i][j]=cArr[j];
                if(65<=cArr[j]&&76>=cArr[j]){
                    used[cArr[j]-64]=true;
                    list.add(cArr[j]-64);
                }
                if(cArr[j]=='x'){
                    list.add(0);
                }
            }
        }
        makeStar();

        for(int i= 0; i<5; i++){
            for(int j =0; j<9; j++){
                if(star[i][j]!='.'){
                    star[i][j]=(char)(list.pop()+'@');
                }
            }
            for(int j =0; j<9; j++){
                bw.write(String.valueOf(star[i][j]));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
    public static boolean chk(){
        boolean chk = true;
        if(list.get(0)!=0&&list.get(2)!=0&&list.get(5)!=0&&list.get(7)!=0){
            if(list.get(0)+list.get(2)+list.get(5)+list.get(7)!=26){
                return false;
            }
        }
        if(list.get(0)!=0&&list.get(3)!=0&&list.get(6)!=0&&list.get(10)!=0){
            if(list.get(0)+list.get(3)+list.get(6)+list.get(10)!=26){
                return false;
            }
        }
        if(list.get(1)!=0&&list.get(2)!=0&&list.get(3)!=0&&list.get(4)!=0){
            if(list.get(1)+list.get(2)+list.get(3)+list.get(4)!=26){
                return false;
            }
        }
        if(list.get(7)!=0&&list.get(8)!=0&&list.get(9)!=0&&list.get(10)!=0){
            if(list.get(7)+list.get(8)+list.get(9)+list.get(10)!=26){
                return false;
            }
        }
        if(list.get(1)!=0&&list.get(5)!=0&&list.get(8)!=0&&list.get(11)!=0){
            if(list.get(1)+list.get(5)+list.get(8)+list.get(11)!=26){
                return false;
            }
        }
        if(list.get(4)!=0&&list.get(6)!=0&&list.get(9)!=0&&list.get(11)!=0){
            if(list.get(4)+list.get(6)+list.get(9)+list.get(11)!=26){
                return false;
            }
        }


        return chk;
    }
    public static void makeStar(){
        if(!list.contains(0)&&chk())
        {
            answer=list;
        }
        for(int i = 1; i<=12; i++){
            if(!used[i]){
                int idx= list.indexOf(0);
                list.set(idx,i);
                used[i]=true;
                if(chk()){
                    makeStar();
                    if(!answer.isEmpty())break;
                }
                list.set(idx,0);
                used[i]=false;

            }
        }
    }
}
