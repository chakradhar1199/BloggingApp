package Exception;

public class CheckedException {
    public static void main(String[] args)  throws UNException{
        if (true) {
            throw new UNException("simple custom unchecked exception");
        }

    }
}
