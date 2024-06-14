import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        List<int[]> arrayList = getCombinations(nums, 3);
        for(int[] a : arrayList){
            if(isPrime(sum(a))){
                answer++; 
            }
        }

        return answer;
    }
    
    public List<int[]> getCombinations(int[] nums, int k){
        int n = nums.length;
        List<int[]> arrayList = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int m = j+1; m<n; m++){
                    arrayList.add(new int[] {nums[i], nums[j], nums[m]});
                }
            }
        }
        return arrayList;
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}