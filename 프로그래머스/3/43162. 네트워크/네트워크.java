import java.util.*;

class Solution {
    boolean[] visited;
    int[][] computers;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        this.computers = computers;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i] && computers[i][j] == 1){
                    answer++;
                    bfs(i);
                }
            }
        }
        
        return answer;
    }
    
    private void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        
        while(!queue.isEmpty()){
            int index = queue.poll();
            
            if(!visited[index]){
                visited[index] = true;
                
                for(int k = 0; k<computers.length; k++){
                    if(computers[index][k] == 1 && !visited[k]){
                        queue.add(k);
                    }
                }
            }
        }
        
    }
}