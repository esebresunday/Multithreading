import java.util.concurrent.*;
public class Executor {
    public static void main(String[] args)
    {
        MyThread[] jobs = {new MyThread(4), new MyThread(5), new MyThread(6), new MyThread(7)};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (MyThread job : jobs)
        {
            executor.submit(job);
        }
        executor.shutdown();
    }
}
class MyThread extends Thread
{
    int number;
    MyThread(int number)
    {
        this.number = number;
    }
    public void run()
    {
        System.out.println("The square of " + number + " is " +number*number+" ran by: "+Thread.currentThread().getName());
    }
}
