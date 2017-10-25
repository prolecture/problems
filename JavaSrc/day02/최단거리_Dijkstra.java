import java.util.*;

public class 최단거리_Dijkstra {
	static ArrayList<Vertex>[] G;	// 인접 리스트
	static int[] D;					// 최단 거리 저장	
	static int N, E;				// 마지막정점, 간선수
	
	// 우선 순위 큐에 저장하기 위한 객체 
	private static class Vertex implements Comparable<Vertex>{
		int v, d;	// 정점, 거리		
		Vertex(int a, int b) {
			v = a; d = b; 
		}
		public int compareTo(Vertex arg) {			 
			return d - arg.d;
		}		
	}
	
	public static void dijkstra(int v)
	{
		for(int i = 0; i <= N; i++)
			D[i] = 0xffffff;		// D[] 초기화 
		D[v] = 0;					// 시작점 거리 초기화
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();		
		Q.add(new Vertex(v, D[v]));
		
		while(!Q.isEmpty())
		{
			Vertex from = Q.poll();
			if(from.d > D[from.v]) continue;
			
			for(Vertex to: G[from.v])
			{
				if(D[to.v] > D[from.v] + to.d)
				{
					D[to.v] = D[from.v] + to.d;				
					Q.add(new Vertex(to.v, D[to.v]));
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
			
			G = new ArrayList[N + 1];
			for(int i = 0; i <= N; i++)
				G[i] = new ArrayList<Vertex>();
			
			D = new int[N + 1];			
			
			int u, v, w;
			for(int i = 0; i < E; i++)
			{
				u = sc.nextInt();
				v = sc.nextInt();				
				w = sc.nextInt();
				
				G[u].add(new Vertex(v, w));
			}		
			dijkstra(0);
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
	}
}
