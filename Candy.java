import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Candy {
    private int hell;
    private String hope;
    private int producerID;

    // constructor
    public Candy() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.hell = random.nextInt(-9999, 9999);
        this.hope = UUID.randomUUID().toString().substring(16);
        this.producerID = hashCode();
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append("    hell=" + this.hell)
                .append("\n")
                .append("    hope=" + this.hope)
                .append("\n")
                .append("    producerID=" + this.producerID)
                .append("\n")
                .append("------------------------------------\n")
                .toString();
    }
}
