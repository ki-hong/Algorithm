package programers.lv2;

public class 최댓값_최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int max=0;
        int min=0;
        for(int i = 0; i<sArr.length; i++){
            int inner = Integer.parseInt(sArr[i]);
            if(i==0) {
                max = inner;
                min = inner;
            }
            if(i!=0) {
                if(max<inner) max= inner;
                if(min>inner) min= inner;
            }
        }
        answer = min + " " + max;

        return answer;
    }
}
