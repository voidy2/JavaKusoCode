public class NotifyTest {
    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();
        System.out.println(args[0]);
        String[] strs = {
            "notify-send",
            "-i",
            "/home/voidy21/Pictures/49c40452.png",  //画像を指定
            "どうだろう",
            "このように\n改行もできます\n3\n4\n5\n6\n7\n8\n9\n一度に表示出来るのは10行までっぽい",
        };
        r.exec(strs);
    }
}
