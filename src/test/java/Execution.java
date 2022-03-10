import solution.Dictionary;

import java.io.IOException;
import java.util.List;

public class Execution {

    public static void main(String[] args) throws IOException {

        List<String> var = Dictionary.readDictionary();
        Dictionary.findOptions("array", var).stream().distinct().forEach(System.out::println);
    }

}
