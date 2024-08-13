import java.io.*;
import java.util.*;

class Main {
	private static String[][] screen;
	private static boolean[][] visited;
	private static final int[] dWidth = {-1, 1, 0, 0};
	private static final int[] dHeight = {0, 0, -1, 1};
	private static int width;
	private static int height;
	private static int maxSize;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		
		width = Integer.parseInt(size[0]);
		height = Integer.parseInt(size[1]);
		
		screen = new String[height][width];
		visited = new boolean[height][width];
		
		for(int i = 0; i<height; i++){
			String[] sentence = br.readLine().split("");
			for(int j = 0; j<width; j++){
				screen[i][j] = sentence[j];
			}
		}
		int count = 0;
		for(int i = 0; i<height; i++){
			for(int j = 0; j<width; j++){
				if(!visited[i][j] && screen[i][j].equals("#")){
					count++;
					bfs(i, j);
					// System.out.println("bfs 끝");
				}
			}
		}
		// System.out.println("Hello Goorm! Your input is " + input);
		// for(int i = 0; i<height; i++){
		// 	System.out.println(Arrays.toString(screen[i]));
		// }
		System.out.println(count + "\n" + maxSize);
	}
	
	private static void bfs(int i, int j){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		int tempSize = 0;
		
		while(!queue.isEmpty()){
			int[] poll = queue.poll();
			
			int curX = poll[1];
			int curY = poll[0];
			
			if(!visited[curY][curX]){
				// System.out.println(curY + ", " + curX);
				visited[curY][curX] = true;
				tempSize++;
				
				for(int k = 0; k<4; k++){
					int nextY = dHeight[k] + curY;
					int nextX = dWidth[k] + curX;
					if(nextX >=0 && nextX < width && nextY >= 0 && nextY < height && screen[nextY][nextX].equals("#")){
						queue.add(new int[]{nextY, nextX});
					}
				}
			}
		}
		if(tempSize > maxSize){
			maxSize = tempSize;
		}
	}
}