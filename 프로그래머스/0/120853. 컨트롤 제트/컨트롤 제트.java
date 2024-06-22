class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] allItems = s.split(" ");
        
        for(int i = 0; i<allItems.length; i++){
            if("Z".equals(allItems[i])){
                answer -= Integer.parseInt(allItems[i-1]);
            } else {
                int temp = Integer.parseInt(allItems[i]);
                answer += temp;
            }
        }
        return answer;
    }
}