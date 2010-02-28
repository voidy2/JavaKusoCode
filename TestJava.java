class Out{
    interface Z{
        double getValue();
    }
    class A implements Z{
        double value = 1.0;
        @Override
        public double getValue() {
            return value;
        }
    }
    class B implements Z{
        double value = -1.0;
        @Override
        public double getValue() {
            return value;
        }
    }
}
public class TestJava {

    double callValue(int n) {
        return (n > 0 ? new Out().new A() : new Out().new B()).getValue();
    }
    public static void main (String [] args) {
        TestJava tj = new TestJava();
        System.out.println(tj.callValue(-1));
    }
}

