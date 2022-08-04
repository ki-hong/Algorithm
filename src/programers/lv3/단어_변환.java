package programers.lv3;

import java.util.*;
public class 단어_변환 {
    Queue<String> queue = new LinkedList<>();
    Queue<String> next = new LinkedList<>();
    boolean[] used;
    int depth = 1;
    public int solution(String begin, String target, String[] words) {
        boolean firstChk = true;//같은 단어가 없으면 true
        for(String str : words){
            if(str.equals(target)) firstChk=false;
        }
        if(firstChk) return 0;
        used=new boolean[words.length];
        makeChild(begin,words);
        while(!next.isEmpty()){
            queue.add(next.poll());
        }
        while(!queue.isEmpty()) {
            begin=queue.poll();
            if(begin.equals(target)) break;
            makeChild(begin,words);
            if(queue.isEmpty()){
                depth++;
                while(!next.isEmpty()){
                    queue.add(next.poll());
                }
            }
        }
        return depth;
    }

    public void makeChild(String begin, String[] words){
        char[] beArr = begin.toCharArray();
        char[] woArr;
        int cnt=0;
        for (int i = 0; i < words.length; i++) {
            woArr=words[i].toCharArray();
            for(int j = 0; j< beArr.length; j++){
                if(beArr[j]!=woArr[j]) cnt++;
            }
            if(cnt==1&&!used[i]){
                next.add(words[i]);
                used[i]=true;
            }
            cnt=0;
        }
    }
}
