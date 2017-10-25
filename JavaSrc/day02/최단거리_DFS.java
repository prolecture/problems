import java.util.*;

public class 최단거리_DFS {
	static int[][] G;		// 인접 행렬
	static int[] D;			// 최단 거리 저장	
	static int N, E;		// 마지막정점, 간선수
	
	public static void DFS(int v)
	{
		if(D[v] >= D[N]) return;
		
		for(int i = 0; i <= N; i++)	{
			if(G[v][i] != 0 && D[i] > D[v] + G[v][i])
			{
				D[i] = D[v] + G[v][i];	
				DFS(i);
			}	
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
			
			int u, v, w;
			for(int i = 0; i < E; i++){
				u = sc.nextInt();
				v = sc.nextInt();				
				w = sc.nextInt();				
				G[u][v] = w;
			}
			for(int i = 0; i <= N; i++)
				D[i] = 0xffffff;		// D[] 초기화 
			D[0] = 0;					// 시작점 거리 초기화
			DFS(0);
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
	}
}
