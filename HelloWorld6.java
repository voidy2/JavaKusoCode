import static java.lang.System.*;
import java.io.PrintStream;

class HelloWorld6 {
    static {
        new PrintStream(out) {
            void hello(){
                println("Hello, World6!");
                exit(0);
            }
        }.hello();
    }
}
