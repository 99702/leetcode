import java.util.function.Supplier;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class Util {
    public static <T> void print(String functionName, Supplier<T> function) {
        long startTime = System.nanoTime();
        T result = function.get();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("*******"+functionName+" *********");
        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Value : " + result  );
        System.out.println("\n");
    }
}