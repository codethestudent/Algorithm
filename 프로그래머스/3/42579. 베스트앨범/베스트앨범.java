import java.util.*;

class Solution {
    // 속한 노래가 많이 재생된 장르 먼저
    // 
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 장르별로 정렬하기 위한 맵
        Map<String, Integer> map = new HashMap<>();
        // 각 장르안에 고유번호들을 플레이 순으로 정렬하기 위한 맵을 가진 맵
        Map<String, Map<Integer, Integer>> doubleMap = new HashMap<>();
        
        // genres, plays를 각각 map , doubleMap에 저장해준다.
        for(int i = 0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> innerMap;
            
            if(doubleMap.get(genres[i]) == null){
                innerMap = new HashMap<>();
            } else {
                innerMap = doubleMap.get(genres[i]);
            }
            innerMap.put(i, plays[i]);
            doubleMap.put(genres[i], innerMap);
        }
        
        // map을 정렬한다.        
        List<String> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort(new Comparator<String>(){   
            public int compare(String o1, String o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        // keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));
        List<Integer> answerList = new ArrayList<>();
        
        for(String key : keySet){
            Map<Integer, Integer> innerMap = doubleMap.get(key);
            List<Integer> innerKeySet = new ArrayList<>(innerMap.keySet());
            // innerKeySet.sort((o1, o2) -> 
            //                  doubleMap.get(m.getKey()).get(o2)
            //                  .compareTo(doubleMap.get(m.getKey()).get(o1)));
            
            innerKeySet.sort(new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2){
                    return innerMap.get(o2).compareTo(innerMap.get(o1));
                }
            });
            System.out.println(innerKeySet.toString());
            for(int i = 0; i<(innerKeySet.size() > 2 ? 2 : innerKeySet.size()); i++){
                answerList.add(innerKeySet.get(i));
            }
        }
        
        return answerList.stream().mapToInt(o -> o).toArray();
    }
}