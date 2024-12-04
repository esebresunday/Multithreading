import java.io.*;
import java.util.concurrent.*;
public class ExcutorService
{
    public static void main(String[] args)
    {
        PrintJob[] jobs = {new PrintJob("sunday"), new PrintJob("monday"), new PrintJob("tuesday")};
        ExecutorService executor = Executors.newFixedThreadPool(jobs.length);
        for (PrintJob job : jobs)
        {
            executor.submit(job);
        }


    }
}
class PrintJob extends Thread
{
    String name;
    PrintJob(String name)
    {
        this.name = name;
    }
    @Override
    public void run()
    {
        System.out.println(name+" Job started by thread "+Thread.currentThread().getName());
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        //System.out.println(name+" Job completed by thread "+Thread.currentThread().getName());
    }
}
