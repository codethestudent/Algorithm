import java.util.*;

/*
1. map 을 만든다,
2. bfs 를 실행한다.
*/
class Solution {
    int[][] map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new boolean[102][102];
        
        int rectangleCount = rectangle.length;
        
        for(int k = 0; k < rectangleCount; k++){
            for(int i = 2*rectangle[k][1]; i <= 2*rectangle[k][3]; i++){
                for(int j = 2*rectangle[k][0]; j <= 2*rectangle[k][2]; j++){
                    if(map[i][j] == 2) continue;
                    if(j == 2*rectangle[k][0] || j == 2*rectangle[k][2] || i == 2*rectangle[k][1] || i == 2*rectangle[k][3]){
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        answer = bfs(characterX * 2, characterY*2, itemX*2, itemY*2)/2;

        return answer;
    }
    
    private int bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(characterX, characterY, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.getX() == itemX && node.getY()== itemY){
                return node.getDepth();
            }
            if(!visited[node.getY()][node.getX()]){
                visited[node.getY()][node.getX()] = true;
                
                for(int k = 0; k<4; k++){
                    if(map[node.getY() + dy[k]][node.getX() + dx[k]] == 1){
                        queue.add(new Node(node.getX() + dx[k], node.getY() + dy[k], node.getDepth() + 1));
                    }
                }
            }
        }
        return 0;
    }
    
    class Node{
        int x;
        int y;
        int depth;
        
        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public int getDepth(){
            return depth;
        }
    }
}