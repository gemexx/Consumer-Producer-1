import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Consumer implements Runnable {
    private Stack<Candy> candyStack;
    private ArrayList<Thread> threads;
    private Statistics statistics;

    public Consumer(Stack<Candy> candyStack, ArrayList<Thread> threads,Statistics statistics) {
        this.candyStack = candyStack;
        this.threads = threads;
        this.statistics = statistics;
    }

    public void run() {
        try {
            while (true) {
                try {
                    Candy candy = candyStack.pop();
                    System.out.println(candy.toString());
                } catch (EmptyStackException e) {
                    Main.StopThreads(threads, statistics);
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException  e) {}
    }
}
