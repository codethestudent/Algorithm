import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String s : completion){
            if(!map.containsKey(s)){
                map.put(s, 1);
            } else {
                map.replace(s, map.get(s) + 1);
            }
        }

        for(int i = 0; i<participant.length; i++){
            if(map.containsKey(participant[i]) && map.get(participant[i]) != 0){
                map.replace(participant[i], map.get(participant[i]) - 1);
                continue;
            } else {
                return participant[i];
            }
        }
        return "";
    }
}