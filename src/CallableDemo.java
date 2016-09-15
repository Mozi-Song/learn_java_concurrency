import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 
 * Exercise of the usage of Callable and 
 * ExecutorService.submit()
 * and Future.get()
 *
 */
class CallableTask implements Callable<String>{
	
	private int id;
	
	public CallableTask(int id){
		this.id = id;
	}
	
	@Override
	public String call(){
		return "result from " + id;
	}
	
}


public class CallableDemo {
	
	public static void main(String[] args){

		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for(int i=0; i<10; i++)
			results.add(executor.submit(new CallableTask(i)));
		for(Future<String> result: results){
			try{
				System.out.println(result.get());
			}
			catch (ExecutionException e){
				e.printStackTrace();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally{
				executor.shutdown();
			}
		}
	}	
}
