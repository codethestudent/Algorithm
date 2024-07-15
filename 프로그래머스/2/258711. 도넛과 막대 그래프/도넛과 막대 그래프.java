import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> node = new HashMap<>();
        int[] answer = {0, 0, 0, 0};
        
        // 노드별로 int[] 배열을 생성해서 넣어줌
        for(int[] edge : edges) {
            int outNode = edge[0];
            int inNode = edge[1];
            
            if(!node.containsKey(outNode)) {
                node.put(outNode, new int[] {0, 0});
            }
            if(!node.containsKey(inNode)) {
                node.put(inNode, new int[] {0, 0});
            }
            
            // node별로 들어오는 개수와 나가는 개수를 계산
            node.get(outNode)[0]++;
            node.get(inNode)[1]++;
        }
        
        // 모든 노드를 탐색
        for(int key : node.keySet()) {
            int[] count = node.get(key);
            
            // 나가는 간선이 2개 이상이고, 들어오는 간선이 없을 경우
            // = 생성한 정점
            if(count[0] >= 2 && count[1] == 0) {
                answer[0] = key;
            }
            // 나가는 간선이 없고, 들어오는 간선이 있을 경우
            // = 막대 그래프
            else if(count[0] == 0 && count[1] > 0) {
                answer[2]++;
            }
            // 들어오는 것과 나가는 것이 각 2개 이상일 경우
            // = 8자 그래프
            else if(count[0] >= 2 && count[1] >= 2) {
                answer[3]++;
            }
        }
        
        // 정점에서 나가는 간선의 개수에서 막대와 8자를 제외한 경우
        // = 도넛 그래프
        answer[1] = node.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}