//Prim + 인접리스트 + 우선순위큐
import java.util.*;

public class 최소신장트리_PrimPQ {
	static ArrayList<Vertex>[] G; // 인접 행렬	
	static int[] D;				// 간선의 가중치 저장
	static int[] P; 			// 간선 정보 저장
	static boolean[] visited;
	static int V, E;			// 정점수, 간선수
	//----------------------------------------------------
	// 인접리스트, 우선순위 큐에 저장할 클래스
	static class Vertex implements Comparable<Vertex>{
		int v, d;		// 정점 번호, 가중치
		Vertex(int a, int b){
			v = a; d = b;
		}		
		public int compareTo(Vertex arg) {			
			return d - arg.d;
		}
	}	
	//----------------------------------------------------
	public static int mstPrim(int s)	//  s: 시작점
	{									// MST 가중치 반환 
		for(int i = 0; i <= V; i++){
			D[i] = 0xfffff;
			P[i] = i;
		}
		D[s] = 0;	// 시작점 D[] 초기화		
		PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();
		PQ.add(new Vertex(s, D[s]));
		
		int cost = 0;		// MST 간선들 가중치 합
		while(!PQ.isEmpty())
		{
			// 트리에서 가장 가까운 정점 가져오기
			Vertex obj = PQ.poll();
			if(visited[obj.v]) continue;
			visited[obj.v] = true;
			
			cost += obj.d;	// == D[obj.v]				
			
			for(Vertex adj: G[obj.v]) {				
				if(D[adj.v] > adj.d) {
					D[adj.v] = adj.d;
					P[adj.v] = obj.v;
					PQ.add(new Vertex(adj.v, D[adj.v]));
				}
			}
		}
		return cost;
	}	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			V = sc.nextInt();
			E = sc.nextInt();
			
			// 필요한 저장 공간 생성			
			G = new ArrayList[V + 1];
			for(int i = 0; i <= V; i++)
				G[i] = new ArrayList<Vertex>();			
			D = new int[V + 1];
			P = new int[V + 1];
			visited = new boolean[V + 1];		// 트리 정점들 표시
			
			int u, v, w;		// 간선(u,v), 가중치 w
			for(int i = 0; i < E; i++)
			{
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();				
				G[u].add(new Vertex(v, w));
				G[v].add(new Vertex(u, w));
			}
			
			System.out.printf("#%d %d\n", tc, mstPrim(0));
		}
		sc.close();		
	}	
}
