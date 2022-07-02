package programers.lv2;
import java.util.*;
public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int myRank = priorities[location];
        Queue pq = new LinkedList();
        HashMap<Integer,Integer> chkMap = new HashMap<Integer,Integer>();
        int higher = 0;
        for(int i = 1; i<10 ;i++){
            chkMap.put(i,0);
        }
        for(int i =0; i<priorities.length; i++){
            if(i!=location){
                pq.offer(priorities[i]);
            }else{
                pq.offer(0);
            }
            chkMap.put(priorities[i],chkMap.get(priorities[i])+1);
            if(higher<priorities[i]){
                higher=priorities[i];
            }
        }
        int rank =higher;
        int cnt =0;
        if(rank==myRank){
            cnt++;
            while((int)pq.peek()!=0){
                if((int)pq.poll()==myRank){
                    cnt++;
                }
            }
            return cnt;
        }
        while(!pq.isEmpty()){
            if(rank==myRank){
                break;
            }
            if((int)pq.peek()==rank){
                pq.poll();
                chkMap.put(rank,chkMap.get(rank)-1);
                if(chkMap.get(rank)==0){
                    rank--;
                    while(chkMap.get(rank)==0){
                        rank--;
                    }
                }
                cnt++;
            }else if((int)pq.peek()!=rank){
                pq.offer(pq.poll());

            }
        }
        while((int)pq.peek()!=0){
            if((int)pq.poll()==myRank){
                cnt++;
            }
        }
        cnt++;
        return cnt;
    }
}
