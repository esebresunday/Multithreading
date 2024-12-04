import java.io.*;
import java.util.concurrent.*;
public class CallableClass
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        MyCallable[] jobs = {new MyCallable(5), new MyCallable(6), new MyCallable(7), new MyCallable(8)};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (MyCallable job : jobs)
        {
            Future future = executor.submit(job);
            System.out.println(future.get());
        }
    }
}
class MyCallable implements Callable
{
    int num;
    MyCallable(int num)
    {
        this.num = num;
    }
    public Object call() throws Exception
    {
        System.out.println(Thread.currentThread().getName() + ": finds the sum of first " + num + " numbers");
        int sum = 0;
        for (int i = 1; i <= num; i++)
        {
            sum = sum + i;
        }
        return sum;
    }
}
