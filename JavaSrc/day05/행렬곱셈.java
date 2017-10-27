import java.util.Scanner;

public class 행렬곱셈 {
	static final int MAXN = 20;	
	static int[] p = new int[MAXN + 1];	
	static int[][] memo = new int[MAXN + 1][MAXN + 1];
	static int N;

	// 재귀 + 메모
	static int multi_memo(int i, int j){
		if (i == j) return 0;
		if (memo[i][j] != -1) return memo[i][j];
		
		int min = Integer.MAX_VALUE;
		
		for (int k = i; k < j; k++)	{
			int sum = multi_memo(i, k);
			sum += multi_memo(k + 1, j);
			sum += p[i - 1] * p[k] * p[j];

			if (min > sum) min = sum;
		}
		return memo[i][j] = min;
	}
	// 반복
	static int multi_iter(){
		
		for(int i = 1; i <= N; i++) memo[i][i] = 0;
		
		for (int l = 1; l < N; l++){
			
			for (int i = 1; i + l <= N; i++)
			{
				int j = i + l;
				
				int min = Integer.MAX_VALUE;
				
				for(int k = i; k < j; k++) {
				 	int sum = memo[i][k] + memo[k + 1][j] + p[i-1]*p[k]*p[j];
					if (min > sum) min = sum;					
				}
				memo[i][j] = min;
			}
		}
		return memo[1][N];
	}
	public static void main(String[] args)
	{	
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for(int tc = 1; tc <= T; tc++)
	    {
		    N = sc.nextInt();
		    boolean ok = true;
		    for(int i = 1; i <= N; i++) {
		    	int row = sc.nextInt();
		    	int col = sc.nextInt();
		    	if(i == 1) {
		    		p[0] = row; p[1] = col;
		    	}else if(p[i - 1] == row) {
		    		p[i] = col;
		    	}else ok = false;		    	
		    }
		    if(ok){
			    // memo[][] -1로 초기화
				for(int i = 1; i <= N; i++)
					for(int j = 1; j <= N; j++)
						memo[i][j] = -1;
			    
				System.out.printf("#%d %d\n", tc, multi_iter());		
				//System.out.printf("#%d %d\n", tc, multi_memo(1, N));
		    }else
		    	System.out.printf("#%d 0\n", tc);
	    }		
	    sc.close();		
	}
}
