class Cuth extends Thread
{
    String name;
    static Integer cusId = 0;
    private static ThreadLocal t = new ThreadLocal()
    {
        protected Integer initialValue()
        {
            return ++cusId;
        }
    };
    Cuth(String name)
    {
        this.name = name;
    }
    public void run()
    {
        System.out.println(name +" executing with customer Id:"+t.get());
    }
}
class Main
{
    public static void main(String[] args)
    {
        Cuth c1 = new Cuth("Customer 1");
        Cuth c2 = new Cuth("Customer 2");
        Cuth c3 = new Cuth("Customer 3");
        c1.start();
        c2.start();
        c3.start();
    }
}