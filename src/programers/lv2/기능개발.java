package programers.lv2;

import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> pq = new LinkedList<>();
        Queue<Integer> sq = new LinkedList<>();

        for(int i = 0; i< progresses.length; i++){
            pq.offer(progresses[i]);
            sq.offer(speeds[i]);
        }
        int days = 1;
        int cnt = 0;
        ArrayList<Integer> res = new ArrayList();
        while(!pq.isEmpty()){
            if((int)pq.peek()+((int)sq.peek()*days)>=100){
                pq.poll();
                sq.poll();
                cnt++;
            }else {
                //cnt를 어디다 넣어주고
                if(cnt!=0){
                    res.add(cnt);
                }
                //cnt 초기화
                cnt=0;
                days++;
            }
        }
        res.add(cnt);
        int[] answer = new int[res.size()];
        for(int i = 0; i<answer.length;i++){
            answer[i]=res.get(i);
        }




        return answer;
    }
}
