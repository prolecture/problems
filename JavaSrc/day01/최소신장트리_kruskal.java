import java.util.*;

public class 최소신장트리_kruskal {
	static int[] p = null;		// Disjoint-set 부모 저장
	static int[] r = null;		// 랭크값 저장	
	static int V,  E;			// 마지막 정점번호, 간선수
	
	// 간선 정보를 위한 Edge 클래스
	public static class Edge implements Comparable<Edge>{
		int u, v, w;
		Edge(int _u, int _v, int _w){ u = _u; v = _v; w = _w;}
		
		public int compareTo(Edge arg) {
			return w - arg.w;			
		}		
	}
	static LinkedList<Edge> edges = new LinkedList<Edge>();	// 모든 간선들
	static LinkedList<Edge> tree = new LinkedList<Edge>();	// MST 간선들
	
	//---------------------------------------------
	// Disjoint-Set
	public static void make_set()
	{
		p = new int[V + 1];		
		r = new int[V + 1];
		
		for(int i = 0; i <= V; i++)
		{
			p[i] = i;
			r[i] = 0;
		}
	}
	public static int find_set(int x)
	{
		if( x != p[x]) p[x] = find_set(p[x]);
		
		return p[x]; 
	}
	public static void union(int a, int b)
	{
		//int a = find_set(a); 
		//int b = find_set(b);
		//if(a == b) return;
		
		if(r[a] > r[b]) 
			p[b] = a;
		else {
			p[a] = b;
			if(r[a] == r[b]) r[b]++;
		}
	}
	//---------------------------------------------
	
	public static int kruskal()	// MST 가중치 합 반환
	{
		int cost = 0;			// 가중치 합 저장
		
		Collections.sort(edges);// 간선 정렬
		
		make_set();				// Disjoint-Set 초기화
		
		int cnt = V;		// 정점수 - 1 개	
		
		while(cnt > 0)
		{
			Edge e = edges.removeFirst(); // 가중치 순으로 간선을 가져온다.
			
			int a = find_set(e.u);		// u, v 집합의 대표자 찾기
			int b = find_set(e.v);
			
			if(a == b) continue;		// 같은 집합이면 Skip
			
			union(a, b);				// 다른 집합이면 합친다.
			cost += e.w;
			
			tree.add(e);				// 선택된 간선을 저장
			cnt--;
		}
		return cost;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			V = sc.nextInt();
			E = sc.nextInt();
			
			int u, v, w;
			for(int i = 0; i < E; i++)
			{
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();				
				edges.add(new Edge(u, v, w));
			}									
			System.out.printf("#%d %d\n", tc, kruskal());
			
			//for(Edge e: tree)
				//System.out.println(e);
			edges.clear();
			tree.clear();
		}
		sc.close();
	}
}
