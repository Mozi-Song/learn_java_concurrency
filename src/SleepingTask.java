import java.lang.Runnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * P1126
 * This class is written to try the sleeping function of TimeUnit.
 * Somehow it does terminates prematurely and does not show the 
 * expected results in Eclipse SDK (Version 4.2.2).
 * A sample result of running it with java in command:
 * 0(5) 1(5) 4(5) 3(5) 2(5) 0(4) 1(4) 4(4) 3(4) 2(4) 0(3) 1(3) 4(3)
 * 3(3) 2(3) 0(2) 1(2) 4(2) 3(2) 2(2) 0(1) 1(1) 4(1) 3(1) 2(1) 0(finished!) 
 * 1(finished!) 4(finished!) 3(finished!) 2(finished!)
 * It shows perfect distribution among threads.
 *
 */
public class SleepingTask implements Runnable{

	private int countDown = 5;
	private int id;
	
	public SleepingTask(int id){
		
		this.id = id;
	}
	
	public void run(){
		
		while(countDown > 0){
			System.out.print(id+"("+countDown+") ");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
//				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println("interrupted!");
			}
			countDown--;
		}
		
		System.out.print(id + "(finished!) ");
		return;
	}
	
	public static void main(String[] args){
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++)
			exec.execute(new SleepingTask(i));
		exec.shutdown();
	}
	
}
