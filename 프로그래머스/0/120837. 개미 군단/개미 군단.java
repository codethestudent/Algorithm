class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        // 장군 = 5
        // 병정 = 3
        // 일개미 = 1
        
        return hp/5 + hp%5/3 + hp%5%3/1;
    }
}