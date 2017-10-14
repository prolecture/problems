import java.util.*;

public class 최장거리 {
	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 방문 정보
	static int[] indeg;			// 진입 차수
	static int[] D;
	static int N, E;			// 마지막 정점번호, 간선수
	
	public static void solve()
	{
		D[0] = 0;
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		for(int i = 0; i <= N; i++)		
			if(indeg[i] == 0) Q.add(i); // 진입 차수 0인 정점 큐에 저장
		
		while(!Q.isEmpty())
		{
			int v = Q.poll();			
			
			for(int i = 0; i <= N; i++)	// 인접 정점의 진입 차수 차감
			{
				if(G[v][i] != 0 && indeg[i] != 0)
				{
					D[i] = Math.max(D[i], D[v] + G[v][i]);
					indeg[i]--;
					if(indeg[i] == 0) Q.add(i);	// 진인 차수가 0이 되면 큐에 저장
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
			G = new int[N + 1][N + 1];	// 정점 번호 0 ~ (V-1)			
			indeg = new int[N + 1];
			D = new int[N + 1];		
			
			int u, v, w;
			for(int i = 0; i < E; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				G[u][v] = w;	// 유향 그래프
				indeg[v]++;
			}
			solve();
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
		
	}
}