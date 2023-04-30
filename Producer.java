import java.util.Stack;

public class Producer implements Runnable {
    private Stack<Candy> candyStack;
    private Statistics statistics;

    public Producer(Stack<Candy> candyStack, Statistics statistics) {
        this.candyStack = candyStack;
        this.statistics = statistics;
    }

    public void run() {
        try {
            while (true) {
                candyStack.push(new Candy());
                this.statistics.objectsSpawned++;

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}
