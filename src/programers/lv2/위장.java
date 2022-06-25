package programers.lv2;
import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 0;
        //조합의 문제
        HashMap<String,Integer> cMap = new HashMap<>();
        for(int i = 0; i<clothes.length; i++){
            if(!cMap.containsKey(clothes[i][1])){
                cMap.put(clothes[i][1],1);
            }else{
                cMap.put(clothes[i][1],cMap.get(clothes[i][1])+1);
            }
        }
        int[] cnt = new int[cMap.size()];
        int chk = 0;
        for(Map.Entry<String, Integer> etr : cMap.entrySet()){
            cnt[chk]=etr.getValue();
            chk++;
        }
        for(int i = 0; i<cnt.length; i++){
            if(answer==0){
                answer=cnt[i]+1;
            }else{answer=answer*(cnt[i]+1);
            }
        }
        answer=answer-1;


        return answer;
    }
}
