
public class 이진힙 {
	public static void main(String[] args){
		int[] arr = new int[]{23, 45, 2, 5, 88, 12, 7, 49, 45, 16};	
		for(int val: arr)
			enQueue(val);
		while(hsize != 0)
			System.out.println(deQueue());
	}
	static int SIZE = 100;
	static int[] Heap = new int[SIZE];
	static int hsize = 0;
	static void swap(int i, int j){ int t = Heap[i]; Heap[i] = Heap[j]; Heap[j] = t;}
	static void enQueue(int item){
		// full 체크: hsize == SIZE - 1;
		Heap[++hsize] = item;
		
		int p = hsize / 2; int c = hsize;
		
		while(p != 0 && Heap[p] > Heap[c]){
			swap(p, c);
			c = p;
			p = c/2;
		}
	}
	static int deQueue(){
		// empty 체크: hsize == 0
		int ret = Heap[1];
		Heap[1] = Heap[hsize--];
		int p = 1; int c = p * 2;
		while(c <= hsize){
			if( (c + 1 <= hsize) && (Heap[c] > Heap[c + 1]))
				c++;
			if(Heap[p] > Heap[c]){				
				swap(p, c);
				p = c; 
				c = p * 2;
			}
			else break;			
		}
		return ret;
	}
}
