package programers.lv1;

import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        //1. nums-> 폰켓몬들
        //2. 같은 종류의 폰켓몬 같은 숫자
        //3. N/2개 최대한 많은 종류의 폰켓몬
        int length = nums.length;
        HashSet<Integer> set= new HashSet<>();
        for(int i =0; i<nums.length; i++){
            set.add(nums[i]);
        }
        if(set.size()>=length/2){
            return length/2;
        }



        return set.size();
    }
}
