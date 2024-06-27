import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        
        // 약관 정보를 파싱하여 맵에 저장
        for (String term : terms) {
            String[] parts = term.split(" ");
            termsMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, format);
        
        int idx = 1;
        for (String privacy : privacies) {
            String[] parts = privacy.split(" ");
            LocalDate privacyDate = LocalDate.parse(parts[0], format);
            String termType = parts[1];
            
            // 유효 기간 계산
            int termMonths = termsMap.get(termType);
            LocalDate expirationDate = privacyDate.plusMonths(termMonths);
            
            // 만료 여부 확인
            if (!expirationDate.isAfter(todayDate)) {
                answerList.add(idx);
            }
            idx++;
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
    
    public void parseStringToMap(Map<String ,String> map, String seperator, String[] content){
        for(String s : content){
            String[] parts = s.split(seperator);
            map.put(parts[0], parts[1]);
        }
    }
}