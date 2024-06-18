import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        for(int i = 0; i<query.length; i++){
            if(i%2 == 0){
                arr = cutTail(arr, query[i]);
            } else {
                arr = cutHead(arr, query[i]);
            }
        }
        answer = arr;
        return answer;
    }
    
    public int[] cutTail(int[] arr, int index){
        int[] arr1 = new int[arr.length - (arr.length - (index+1))];
        for(int i = 0; i<=index; i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }
    
    public int[] cutHead(int[] arr, int index){
        int[] arr1 = new int[arr.length - index];
        for(int i = 0; i<arr1.length; i++){
            arr1[i] = arr[index + i];
        }
        return arr1;
    }
}