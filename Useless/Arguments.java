public class Arguments {
    public static void main (String[] args) {
        // this function needs 3 args when you run it with java
        // it runs like this:
        // java Arguments 123 foo bar
        int a = Integer.valueOf(args[0]);
        String b = args[1];
        String c = args[2];
        System.out.println("these are the variables you entered: \n"+a+"\n"+b+"\n"+c);
        String example = new String("string lolololol");
        System.out.println(example);
    }
}