import java.util.*;

class Solution {
    // 1. 주사위를 가져가는(각 주사위의 조합을 만드는 1,2 || 1,3 || ...) 반복문이 필요함.
    // 2. 각 주사위의 조합별로 array에다가 저장 후 모든 조합을 만듦
    // 3. 각 A, B에 들어있는 2중 배열을 가지고 depth를 활용하여 재귀적으로 모두 더했을떄의 경우의 수를 구함
    // 4. 모든 경우의 수를 listA, listB에 저장하고 listB를 정렬하여 bisection 활용하여 
    
    static int N;
    static int[][] dices;
    static List<Integer> listA;
    static List<Integer> listB;
    static List<Integer> choice;
    static int[] answer;
    static int max = Integer.MIN_VALUE;
    
    private void setAllSums(int[][] arr, int depth, List<Integer> list, int sum){
        if(depth == N/2){
            list.add(sum);
            return;
        }
        for(int i=0; i<6; i++){
            int newSum = sum + arr[depth][i];
            setAllSums(arr, depth+1, list, newSum);
        }
    }
    
    private void setArrays(){
        int[][] arrA = new int[N/2][6];
        int[][] arrB = new int[N/2][6];
        int indexA = 0;
        int indexB = 0;
        for(int i=0; i<N; i++){
            if(choice.contains(i)){
                arrA[indexA++] = dices[i];
            } else {
                arrB[indexB++] = dices[i];
            }
        }

        listA = new ArrayList<>();
        listB = new ArrayList<>();
        
        setAllSums(arrA, 0, listA, 0);
        setAllSums(arrB, 0, listB, 0);
    }
    
    // 이분법 사용해서 listA의 각 요소 보다 작은 listB요소 갯수 구하기
    private int getWinningNum(){
        int count = 0;
        setArrays();
        
        Collections.sort(listB);
        for(int i=0; i<listA.size(); i++){
            int left = 0;
            int right = listB.size() - 1;
            int number = listA.get(i);
            
            int index = Integer.MIN_VALUE;
            while(left <= right){
                int middle = (left + right) / 2;
                
                if(listB.get(middle) < number){
                    left = middle + 1;
                    index = Math.max(index, middle);
                } else {
                    right = middle - 1;
                }
            }
            if (index != Integer.MIN_VALUE) {
                count += index + 1;
            }
        }
        return count;
    }
    
    private void choiceDice(int depth, int diceNum){
        if(depth == N/2){
            int winningNum = getWinningNum();
            
            if(max < winningNum){
                max = winningNum;
                for(int i = 0; i<choice.size(); i++){
                    answer[i] = choice.get(i) + 1;
                }
            }
            return;
        }
        for(int i=diceNum; i<N; i++){
            choice.add(i);
            choiceDice(depth + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }
    
    public int[] solution(int[][] dice) {
        N = dice.length;
        answer = new int[N/2];
        choice = new ArrayList<>();
        dices = dice;
        choiceDice(0, 0);
        return answer;
    }
}

