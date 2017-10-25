import java.util.*;

public class 최단거리_Dijkstra_배열 {
	static int[][] G;		// 인접 행렬
	static int[] D;			// 최단 거리 저장
	static boolean[] visited;
	static int N, E;		// 마지막정점, 간선수
	
	static int getMin() {
		int t = 0, min = 0xffffff;
		for(int i = 0; i <= N; i++) {
			if(!visited[i] && min > D[i]) {
				min = D[i]; t = i;
			}
		}
		visited[t] = true;
		return t;
	}
	public static void dijkstra(int v)
	{
		for(int i = 0; i <= N; i++)
			D[i] = 0xffffff;		// D[] 초기화 
		D[v] = 0;					// 시작점 거리 초기화
		
		int cnt = N;
		while(cnt >= 0)
		{
			int t = getMin();
			
			for(int i = 0; i <= N; i++)
			{
				if(G[t][i] != 0 && !visited[i] && D[i] > D[t] + G[t][i])
					D[i] = D[t] + G[t][i];	
			}
			cnt--;
		}
	}
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			E = sc.nextInt();
			
			G = new int[N + 1][N + 1];			
			D = new int[N + 1];			
			visited = new boolean[N + 1];
			
			int u, v, w;
			for(int i = 0; i < E; i++)
			{
				u = sc.nextInt();
				v = sc.nextInt();				
				w = sc.nextInt();
				
				G[u][v] = w;
			}		
			dijkstra(0);
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
	}
}
