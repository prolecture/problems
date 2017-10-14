import java.util.*;

public class ����Ÿ� {
	static int[][] G;			// ���� ���
	static boolean[] visited;	// �湮 ����
	static int[] indeg;			// ���� ����
	static int[] D;
	static int N, E;			// ������ ������ȣ, ������
	
	public static void solve()
	{
		D[0] = 0;
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		for(int i = 0; i <= N; i++)		
			if(indeg[i] == 0) Q.add(i); // ���� ���� 0�� ���� ť�� ����
		
		while(!Q.isEmpty())
		{
			int v = Q.poll();			
			
			for(int i = 0; i <= N; i++)	// ���� ������ ���� ���� ����
			{
				if(G[v][i] != 0 && indeg[i] != 0)
				{
					D[i] = Math.max(D[i], D[v] + G[v][i]);
					indeg[i]--;
					if(indeg[i] == 0) Q.add(i);	// ���� ������ 0�� �Ǹ� ť�� ����
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
			G = new int[N + 1][N + 1];	// ���� ��ȣ 0 ~ (V-1)			
			indeg = new int[N + 1];
			D = new int[N + 1];		
			
			int u, v, w;
			for(int i = 0; i < E; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				G[u][v] = w;	// ���� �׷���
				indeg[v]++;
			}
			solve();
			System.out.printf("#%d %d\n", tc, D[N]);
		}
		sc.close();
		
	}
}