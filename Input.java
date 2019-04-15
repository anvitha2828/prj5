package prj5;

public class Input {
    private static DataReader dr;


    public static void main(String[] args) {
        if (args.length == 2) {
            dr = new DataReader(args[1], args[2]);
        }
        else {
            dr = new DataReader("?????", "???????");
        }
    }
}
