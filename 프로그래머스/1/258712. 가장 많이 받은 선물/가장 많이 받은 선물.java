import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 선물 지수 = 이번달까지 자신이 친구들에게 준 선물 수 - 받은 선물 수
class Solution { 
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i=0; i<friends.length; i++){
            nameMap.put(friends[i], i);
        }
        Integer[][] eachGiftTable = new Integer[friends.length][friends.length];
        Integer[][] giftTable = new Integer[friends.length][3];
        for(int i = 0; i<friends.length; i++){
            Arrays.fill(eachGiftTable[i], 0);
            Arrays.fill(giftTable[i], 0);
        }
        for(int i = 0; i<gifts.length; i++){
            String[] splitedElement = gifts[i].split(" ");
            eachGiftTable[nameMap.get(splitedElement[0])][nameMap.get(splitedElement[1])]++;
        }
        System.out.println(Arrays.deepToString(eachGiftTable));
        int sum;
        for(int i = 0; i<friends.length; i++){
            sum = 0;
            for(int j = 0; j<friends.length; j++){
                sum = sum + eachGiftTable[i][j];
            }
            giftTable[i][0] = sum;
            sum = 0;
            for(int k = 0; k<friends.length; k++){
                sum = sum + eachGiftTable[k][i];
            }
            giftTable[i][1] = sum;
            giftTable[i][2] = giftTable[i][0] - giftTable[i][1];
        }
        System.out.println(Arrays.deepToString(giftTable));
        int temp;
        int previous = 0;
        for(int i = 0; i<friends.length; i++){
            temp = 0;
            for(int j = 0; j<friends.length; j++){
                if(eachGiftTable[i][j] == eachGiftTable[j][i]){
                    if(giftTable[i][2] > giftTable[j][2]){
                        temp++;
                    }
                } else if(eachGiftTable[i][j] > eachGiftTable[j][i]){
                    temp++;
                }
            }
            
            if(temp > previous){
                previous = temp;
            }
        }
        answer = previous;
        return answer;
    }
}