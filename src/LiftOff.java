//P1117-1123
/**
 * Uncomment one of the 4 paragraphs in main()
 * to implement different variants of running 
 * five LiftOff tasks.
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class LiftOff implements Runnable{
	
	private int countDown = 10;
	private static int nmThreads = 0;
	private final int id;
	
	public LiftOff(){
		this.id = nmThreads++;
	}
	
	public void run(){
		
		while(countDown-- > 0){
			
			System.out.print(id+"("+
					((countDown > 0)? countDown:"LiftOff!")
					+") ");
			Thread.yield();
		}
		
		
	}
	
	public static void main(String[] args){ 
		
		
//		for(int i=0; i<5; i++){
//			Runnable run = new LiftOff();
//			new Thread(run).start();
//		}
		
//		ExecutorService executor = Executors.newCachedThreadPool();
//		for(int i=0; i<5; i++)
//			executor.execute(new LiftOff());
		
//		ExecutorService executor = Executors.newFixedThreadPool(4);
//		for(int i=0; i<5; i++)
//			executor.execute(new LiftOff());
		
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		for(int i=0; i<5; i++)
//			executor.execute(new LiftOff());
	}

}
