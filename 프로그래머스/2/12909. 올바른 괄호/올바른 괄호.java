import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] a = s.toCharArray();
        
        if(a[0] == ')'){
            return false;
        }
        
        int temp = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i] == '('){
                temp++;
            } else {
                temp--;
            }
            if(temp < 0) {
                return false;  // 닫는 괄호가 더 많아지는 경우, 즉시 false 반환
            }
        }
        if(a[a.length-1] == '('){
            return false;
        }
        return temp==0;
    }
}