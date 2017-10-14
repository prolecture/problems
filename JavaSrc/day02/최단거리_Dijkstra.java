// 주의>> 유향 그래프
import java.util.*;

public class 최단거리_Dijkstra {
	static ArrayList<Vertex>[] G;	// 인접 행렬
	static int[] D;					// 거리 저장	
	static int N, E;				// 정점수, 간선수
	
	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex>{
		int v;	// 정점 번호
		int d;	// 시작점에서 거리
		Vertex(int a, int b) {
			v = a; d = b; 
		}
		public int compareTo(Vertex arg) {			 
			return d - arg.d;
		}		
	}
	// 다익스트라 + 우선순위 큐
	public static void dijkstra(int v)
	{
		for(int i = 0; i <= N; i++)
			D[i] = 0xffffff;		// D[] 배열 초기화
		D[v] = 0;
		
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
				//G[v].add(new Vertex(u, w));
			}		
			dijkstra(0);
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
	}
}
