import java.util.*;

class Solution {
    boolean[] visited;
    String[] words;
    int number;
    int answer;
    String target;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        number = begin.split("").length - 1;
        
        this.words = words;
        this.target = target;
        
        boolean containsTarget = false;
        for(String w : words){
            if(w.equals(target)) containsTarget = true;
        }
        
        if(!containsTarget) return 0;
        
        // for(int i = 0; i<words.length; i++){
        //     if(!visited[i] && isBeginChangeable(begin, words[i])){
        //         bfs(i);
        //     }
        // }
        
        return bfs(begin);
    }
    
    private boolean isBeginChangeable(String begin, String target){
        String[] begins = begin.split("");
        String[] targets = target.split("");
        int count = 0;
        for(int i = 0; i<begins.length; i++){
            if(begins[i].equals(targets[i])) count++;
        }
        return count == number;
    }
    
    private int bfs(String begin){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(node.word.equals(target)){
                return node.depth;
            }
            
            for(int k = 0; k < words.length; k++){
                if(!visited[k] && isBeginChangeable(words[k], node.word)){
                    visited[k] = true;
                    queue.add(new Node(words[k], node.depth + 1));
                }
            }
        }
        return 0;
    }
    
    class Node{
        String word;
        int depth;
        
        public Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
}