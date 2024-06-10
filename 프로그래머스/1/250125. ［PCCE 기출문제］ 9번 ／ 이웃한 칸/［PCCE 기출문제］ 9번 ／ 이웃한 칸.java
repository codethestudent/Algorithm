
class Solution {  // h = 몇번째 배열인지? w = 몇번째 요소인지?
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        
        int[] dh = {1, -1, 0, 0};
        int[] dw = {0, 0, 1, -1};
        int w_check = 0;
        int h_check = 0;
        for(int i = 0; i<4; i++){
            w_check = w + dw[i];
            h_check = h + dh[i];
            
            if(0 <= h_check && h_check < board.length && 0 <= w_check && w_check < board.length){
                if(color.equals(board[h_check][w_check])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}