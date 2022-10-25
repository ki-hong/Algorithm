package programers.lv2;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr= s.toCharArray();
        for(char a : arr){
            if(a=='['||a=='{'||a=='('){
                stack.push(a);
            }else{
                if(stack.isEmpty()) return false;
                if(a==']'&&stack.pop()!='[') return false;
                if(a=='}'&&stack.pop()!='{') return false;
                if(a==')'&&stack.pop()!='(') return false;
            }
        }
        if(!stack.isEmpty()) return false;

        return true;

    }
}
