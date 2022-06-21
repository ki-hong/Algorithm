package programers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //대기트럭
        Queue daegi = new LinkedList();
        for(int i = 0; i<truck_weights.length;i++){
            daegi.offer(truck_weights[i]);
        }

        //weight 체크

        //다리를 건너는 트럭
        Queue goTruck = new LinkedList();
        //다리 위에 있는 트럭 무게
        int goWeight = 0;

        //경과된 시간 체크(bridge_length)
        ArrayList<Integer> times = new ArrayList<Integer>();
        int totalTime = 0;
        while(!daegi.isEmpty()||!goTruck.isEmpty()){
            if(!times.isEmpty()&&times.get(0)==bridge_length){
                goWeight=goWeight-(int)goTruck.poll();
                times.remove(0);
            }

            if(goWeight<weight&&!daegi.isEmpty()){
                if(weight>=((int)daegi.peek()+goWeight)){
                    goTruck.offer((int)daegi.peek());
                    goWeight=goWeight+(int)daegi.poll();
                    times.add(times.size(),0);
                }
            }
            if(times.size()!=0){
                for(int i = 0; i<times.size(); i++){
                    times.set(i,times.get(i)+1);
                }
            }
            totalTime++;
        }


        return totalTime;
    }
}
