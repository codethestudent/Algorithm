import java.io.*;
import java.util.*;

class Main {
	// N인 정사각형 모양의 마을, M을 만듦
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] houses;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		houses = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i<n; i++){
			input = br.readLine();
			String[] line = input.split(" ");
			for(int j = 0; j<n; j++){
				houses[i][j] = Integer.parseInt(line[j]);
			}
		}
		int gen = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(houses[i][j] == 1 && !visited[i][j]){
					gen++;
					bfs(i, j);
				}
			}
		}
		
		System.out.print(gen);
	}
	
	private static void bfs(int j, int i){
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[]{j, i});
		
		while(!queue.isEmpty()){
			int[] poll = queue.poll();
			
			int curX = poll[1];
			int curY = poll[0];
			if(!visited[curY][curX]){
				visited[curY][curX] = true;
				for(int k = 0; k<4; k++){
					if(curX + dx[k] >=0 && 
						 curX + dx[k] < houses.length && 
						 curY + dy[k] >= 0 && 
						 curY + dy[k] < houses.length &&
						 houses[curY + dy[k]][curX + dx[k]] == 1){
						queue.add(new int[] {curY + dy[k] , curX + dx[k]});
					}
				}
			}
		}
	}
	
}