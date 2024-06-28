import java.util.*;

class Solution {
    // ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<Map<String, Integer>> mapList = new ArrayList<>();
        
        for(int[] d : data){
            Map<String, Integer> map = new HashMap<>();
            map.put("code", d[0]);
            map.put("date", d[1]);
            map.put("maximum", d[2]);
            map.put("remain", d[3]);
            mapList.add(map);
        }
        
        List<Map<String, Integer>> newMapList = new ArrayList<>();
        for(Map<String, Integer> map : mapList){
            if(map.get(ext) < val_ext){
                newMapList.add(map);
            }
        }
        newMapList.sort(
	        Comparator.comparing((Map<String, Integer> map) -> (Integer) map.get(sort_by))
        );
        
        // for(int i = 0; i<newMapList.size(); i++){
        //     Map<String, Integer> map = newMapList.get(i);
        //     for(int j = i+1; j<newMapList.size(); j++){
        //         Map<String, Integer> nextMap = newMapList.get(j);
        //         if(map.get(sort_by) > nextMap.get(sort_by)){
        //             Map<String, Integer> temp = nextMap;
        //             newMapList.set(j, map);
        //             newMapList.set(i, temp);
        //         }
        //     }
        // }
        System.out.println(newMapList);
        
        answer = new int[newMapList.size()][4];
        int idx = 0;
        for(Map<String, Integer> map : newMapList){
            answer[idx][0] = map.get("code");
            answer[idx][1] = map.get("date");
            answer[idx][2] = map.get("maximum");
            answer[idx][3] = map.get("remain");
            idx++;
        }
        
        return answer;
    }
}