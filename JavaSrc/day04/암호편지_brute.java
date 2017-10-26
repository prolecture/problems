import java.util.Scanner;

public class 암호편지_brute {  

	static String today = "today";
	static String tomorrow = "tomorrow";
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			String str = sc.next();
			
			int i, j, pos;
			boolean aflag = true;
			pos = 0;
			for(i = 0; i < today.length(); i++){				
				for(j = pos; j < str.length(); j++)
					if(today.charAt(i) == str.charAt(j)){
						pos = j; break;
					}
				if(j >= str.length()){
					aflag = false; break;
				}
				pos++;
			}
			
			boolean bflag = true;
			pos = 0;
			
			for(i = 0; i < tomorrow.length(); i++){				
				for(j = pos; j < str.length(); j++)
					if(tomorrow.charAt(i) == str.charAt(j)){
						pos = j; break;
					}
				if(j >= str.length()){
					bflag = false; break;
				}
				pos++;
			}
			System.out.printf("#%d ", tc);
			if(aflag) System.out.println(today);
			else if(bflag) System.out.println(tomorrow);
			else System.out.println("none");
		}
		sc.close();
	}

}
