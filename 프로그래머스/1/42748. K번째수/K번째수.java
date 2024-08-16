import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int i, j, k;
        List<Integer> answerList = new ArrayList<>();
        
        for(int index = 0; index<commands.length; index++){
            i = commands[index][0];
            j = commands[index][1];
            k = commands[index][2];
            
            answerList.add(Arrays.stream(array)
                           .limit(j)
                           .skip(i-1)
                           .sorted()
                           .toArray()[k-1]
                          );
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}