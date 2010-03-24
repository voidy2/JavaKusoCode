class Tuple<X,Y> {
    public X x;
    public Y y;
    Tuple(X x,Y y) {
        this.x = x;
        this.y = y;
    }
}

public class TupleTest {
    public static void main (String[] args) {
        Tuple<Integer,String> tuple = new Tuple(404,"test");
        System.out.println(tuple.x + "," + tuple.y);
    }
}
