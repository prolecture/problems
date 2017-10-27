import java.util.Scanner;

public class 최소이동거리_순열 {
	static int MAXN = 10;
	static int N;
	static int[][] G = new int[MAXN + 1][MAXN + 1];		// 정점 번호 = 1 ~ N
	static int min;
	static int S; 		// 전체 집합 저장
	// k: visit에서 마지막 방문 정점, visit: 방문한 정점들 집합, dist: 거리
	static void TSP(int prev, int visit, int dist) {
		if(dist >= min) return;
		if(visit == S) { // 경유 가능한 모든 정점을 방문?
			dist += G[prev][1];
			min = Math.min(min, dist);
			return;
		}
		for(int i = 2; i <= N; i++) {
			if((visit & (1 << i)) != 0) continue; // 이미 방문한 정점인가?
			if(G[prev][i] == 0) continue;
			// i번 정점을 방문
			TSP(i, visit | (1 << i), dist + G[prev][i]);
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++)
					G[i][j] = sc.nextInt();
			}
			S = (1 << (N + 1)) - 2; 	// 전체 집합 저장
			min = Integer.MAX_VALUE;
			
			TSP(1, 2, 0); //1: 방문한 정점수, 2 => 1번 정점을 방문한 상태 
			
			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();		
	}
	
}
