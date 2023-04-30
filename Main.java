import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Statistics statistics = new Statistics();
        ArrayList<Thread> threads = new ArrayList<>();
        Stack<Candy> candyStack = new Stack<>();

        for (int index = 0; index < Integer.parseInt(args[0]); index++)
        {
            System.out.printf("Producer spawned - %d\n", index);
            Thread producer = new Thread(new Producer(candyStack, statistics));
            producer.start();
            threads.add(producer);
        }

        Thread.sleep(1500);

        for (int index = 0; index < Integer.parseInt(args[1]); index ++){
            System.out.printf("Consumer spawned - %d\n", index);
            Thread consumer = new Thread (new Consumer(candyStack, threads, statistics));
            consumer.start();
            threads.add(consumer);
        }

        Scanner scanner = new Scanner(System.in);

        while (scanner.nextInt() != 666) {
            /* Es wurde kien 666 eingegeben */

            System.out.println(candyStack.size());
        }
        // Es wurde 666 eingegeben.

        StopThreads(threads,statistics);

        System.out.printf("Hello and welcome!");
    }

    public static void StopThreads(ArrayList<Thread> threads, Statistics statistics) {
        for (Thread thread : threads) {
            thread.interrupt();
        }

        System.out.printf("Das Programm lief %d Sekunden\n", statistics.getElapsedTime());
        System.out.printf("%d Objekte wurden erzeugt.\n", statistics.objectsSpawned);
        System.exit(0);
    }
}
