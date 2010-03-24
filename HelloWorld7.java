class HelloWorld7 {
    static {
        try {
            if( 
                System.out.getClass().getMethod(
                    "println",
                    String.class
                ).invoke(
                    System.out,
                    "Hello,World!!!!1"
                ) == null
                &&
                Class.forName(
                    "java.lang.System"
                ).getMethod(
                    "exit",
                    int.class
                ).invoke(
                    null,
                    0
                ) == null
            ) {}
        } catch(Exception e) {
        }
    }
}
