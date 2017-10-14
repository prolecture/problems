// ����>> ���� �׷���
import java.util.*;

public class �ִܰŸ�_Dijkstra {
	static ArrayList<Vertex>[] G;	// ���� ���
	static int[] D;					// �Ÿ� ����	
	static int N, E;				// ������, ������
	
	// �켱 ���� ť�� ����Ǵ� ����
	private static class Vertex implements Comparable<Vertex>{
		int v;	// ���� ��ȣ
		int d;	// ���������� �Ÿ�
		Vertex(int a, int b) {
			v = a; d = b; 
		}
		public int compareTo(Vertex arg) {			 
			return d - arg.d;
		}		
	}
	// ���ͽ�Ʈ�� + �켱���� ť
	public static void dijkstra(int v)
	{
		for(int i = 0; i <= N; i++)
			D[i] = 0xffffff;		// D[] �迭 �ʱ�ȭ
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
