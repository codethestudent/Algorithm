import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
//         double temp = 0.0;
//         double max;
//         int index = 0;
//         Map<Double, Integer> map = new HashMap<>();
        
//         for(int i = 0; i<numbers.length; i++){
//             for(int j = 1; j<=100000; j = j*10){
//                 if(numbers[i]/j >= 1 && numbers[i]/j < 10){
//                     temp = (double) j;
//                     break;
//                 }
//             }
//             if(map.get(numbers[i]/temp) != null){
//                 if(numbers[map.get(numbers[i]/temp)] > numbers[i]){
//                     map.put(numbers[i]/temp + 0.1, i);
//                 } else {
//                     map.put(numbers[i]/temp - 0.1, i);
//                 }
//             } else {
//                 map.put(numbers[i]/temp, i);
//             }
//         }
        
//         List<Double> keySet = new ArrayList<>(map.keySet());
        
//         keySet.sort(new Comparator<Double>(){
//             public int compare(Double d1, Double d2){
//                 return d2.compareTo(d1);
//             }
//         });
        
//         for(Double key : keySet){
//             answer += numbers[map.get(key)];
//         }
        
        String[] str = new String[numbers.length];
        for(int i =0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1+o2));
        for(String a: str){
            answer+= a;
        }
        if(str[0].equals("0")){
            return "0";
        }
        return answer;
    }
}