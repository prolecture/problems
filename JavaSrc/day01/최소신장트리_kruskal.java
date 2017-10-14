import java.util.*;

public class �ּҽ���Ʈ��_kruskal {
	static int[] p = null;		// Disjoint-set �θ� ����
	static int[] r = null;		// ��ũ�� ����	
	static int V,  E;			// ������ ������ȣ, ������
	
	// ���� ������ ���� Edge Ŭ����
	public static class Edge implements Comparable<Edge>{
		int u, v, w;
		Edge(int _u, int _v, int _w){ u = _u; v = _v; w = _w;}
		
		public int compareTo(Edge arg) {
			return w - arg.w;			
		}		
	}
	static LinkedList<Edge> edges = new LinkedList<Edge>();	// ��� ������
	static LinkedList<Edge> tree = new LinkedList<Edge>();	// MST ������
	
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
	
	public static int kruskal()	// MST ����ġ �� ��ȯ
	{
		int cost = 0;			// ����ġ �� ����
		
		Collections.sort(edges);// ���� ����
		
		make_set();				// Disjoint-Set �ʱ�ȭ
		
		int cnt = V;		// ������ - 1 ��	
		
		while(cnt > 0)
		{
			Edge e = edges.removeFirst(); // ����ġ ������ ������ �����´�.
			
			int a = find_set(e.u);		// u, v ������ ��ǥ�� ã��
			int b = find_set(e.v);
			
			if(a == b) continue;		// ���� �����̸� Skip
			
			union(a, b);				// �ٸ� �����̸� ��ģ��.
			cost += e.w;
			
			tree.add(e);				// ���õ� ������ ����
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
