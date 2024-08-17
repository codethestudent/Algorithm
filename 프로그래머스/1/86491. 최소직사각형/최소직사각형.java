import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size : sizes){
            int w = Math.max(size[0], size[1]); // 가로와 세로 중 큰 값을 가로로 고정
            int h = Math.min(size[0], size[1]); // 가로와 세로 중 작은 값을 세로로 고정
            
            maxW = Math.max(maxW, w); // 가장 큰 가로 길이 갱신
            maxH = Math.max(maxH, h); // 가장 큰 세로 길이 갱신
        }
        
        return maxW * maxH; // 최소 지갑 크기
    }
}