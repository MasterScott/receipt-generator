import java.util.Random;

public class UniqueId {
    private static Random random = new Random();
    public static Long getId() {
        return random.nextLong();
    }
}
