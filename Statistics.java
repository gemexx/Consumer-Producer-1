public class Statistics {
    public long objectsSpawned;
    public long startTime;

    public Statistics() {
        objectsSpawned = 0;
        startTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return (System.nanoTime() - this.startTime) / 1000_000_000;
    }

}
