import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//doesn't work??

public class PriorityDemo extends Thread{

	private int id;
	private volatile static double d;
	private int countDown = 5;
	private int priority;
	
	public PriorityDemo(int id, int priority){
		this.id = id;
		this.priority = priority;
	}
	
	public String toString(){
		return Thread.currentThread()+": "+countDown;
	}
	
	public void run(){
		Thread.currentThread().setPriority(priority);
		for(;countDown>0;countDown--){

			for(int i=1; i<100000; i++){
				d += (Math.PI + Math.E) / i;
				if(i%1000 == 0)
					Thread.yield();
			}
				
			System.out.println(this);
			if(countDown == 0) return;
		}
			
	}
	
	public static void main(String[] args){
		
		ExecutorService exec = Executors.newCachedThreadPool();

		exec.execute(new PriorityDemo(5, MAX_PRIORITY));
		for(int i=0; i<5; i++)
			exec.execute(new PriorityDemo(i, MIN_PRIORITY));
		exec.shutdown();
		
	}
	
}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//doesn't work??

public class PriorityDemo extends Thread{

	private int id;
	private volatile static double d;
	private int countDown = 5;
	private int priority;
	
	public PriorityDemo(int id, int priority){
		this.id = id;
		this.priority = priority;
	}
	
	public String toString(){
		return Thread.currentThread()+": "+countDown;
	}
	
	public void run(){
		Thread.currentThread().setPriority(priority);
		for(;countDown>0;countDown--){

			for(int i=1; i<100000; i++){
				d += (Math.PI + Math.E) / i;
				if(i%1000 == 0)
					Thread.yield();
			}
				
			System.out.println(this);
			if(countDown == 0) return;
		}
			
	}
	
	public static void main(String[] args){
		
		ExecutorService exec = Executors.newCachedThreadPool();

		exec.execute(new PriorityDemo(5, MAX_PRIORITY));
		for(int i=0; i<5; i++)
			exec.execute(new PriorityDemo(i, MIN_PRIORITY));
		exec.shutdown();
		
	}
	
}
