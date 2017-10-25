import java.util.*;

public class 최단거리_BFS {
	static int[][] G;		// 인접 행렬
	static int[] D;			// 최단 거리 저장	
	static int N, E;		// 마지막정점, 간선수
	
	public static void BFS(int v)
	{
		for(int i = 0; i <= N; i++)
			D[i] = 0xffffff;		// D[] 초기화 
		D[v] = 0;					// 시작점 거리 초기화
		
		Queue<Integer> Q = new LinkedList<Integer>();		
		Q.add(v);
		
		while(!Q.isEmpty())
		{
			int t = Q.poll();
			
			for(int i = 0; i <= N; i++)
			{
				if(G[t][i] != 0 && D[i] > D[t] + G[t][i])
				{
					D[i] = D[t] + G[t][i];	
					Q.add(i);
				}	
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
			for(int i = 0; i < E; i++)
			{
				u = sc.nextInt();
				v = sc.nextInt();				
				w = sc.nextInt();
				
				G[u][v] = w;
			}		
			BFS(0);
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
	}
}
