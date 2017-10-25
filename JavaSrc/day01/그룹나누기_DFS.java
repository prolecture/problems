import java.util.Scanner;

public class 그룹나누기_DFS {
	static int[][] G;	    // 인접 행렬, 인접리스트 ArrayList
	static int[] visited;	// 방문 정보
	static int cnt; 		// 연결 컴포넌트의 수
	static int N, M;
	
	static void DFS(int v) {
		visited[v] = cnt;
		
		for(int i = 1; i <= N; i++) {
			if(G[v][i] == 1 && visited[i] == 0)
				DFS(i);
		}
	}
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			M = sc.nextInt();
			G = new int[N + 1][N + 1];
			visited = new int[N + 1];
			
			for(int i = 0; i < M; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				G[u][v] = G[v][u] = 1;
			}
			cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(visited[i] == 0) {
					cnt++;
					DFS(i);
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();
	}	
}
