import java.util.*;

class Solution {
    
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> personality = new HashMap<>();
        Map<Integer, Integer> scoreMap = new HashMap<>(); 
        String[] chars = new String[] {"R", "T", "C", "F", "J", "M", "A", "N"};
        
        int score = 3;
        for(int i = 1; i<=7; i++){
            if(i > 4){
                score = score < 0 ? 0 : score;
                scoreMap.put(i, ++score);
            } else {
                scoreMap.put(i, score--);    
            }
        }
        
        for(int i = 0; i<survey.length; i++){
            String[] str = survey[i].split("");
            System.out.println(Arrays.toString(str));
            int choice = choices[i];
            
            if(choice < 4){
                personality.merge(str[0], scoreMap.get(choice), Integer::sum);
            }else {
                personality.merge(str[1], scoreMap.get(choice), Integer::sum);
            }
        }
        
        for(String s : chars){
            personality.computeIfAbsent(s, key -> 0);
        }
        
        System.out.println(personality);
        System.out.println(scoreMap);
        
        StringBuilder ans = new StringBuilder();
        ans.append(personality.get("R") >= personality.get("T") ? "R" : "T");
        ans.append(personality.get("C") >= personality.get("F") ? "C" : "F");
        ans.append(personality.get("J") >= personality.get("M") ? "J" : "M");
        ans.append(personality.get("A") >= personality.get("N") ? "A" : "N");

        return ans.toString();
    }
}