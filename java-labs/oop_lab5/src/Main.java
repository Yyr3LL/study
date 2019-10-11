public class Main {
    public static void main(String args[]){

        if (args.length > 0) {
            if (args[0].equals("-a") || args[0].equals("-auto") || args[1].equals("-a") || args[1].equals("-auto")) {
                Auto_mode.auto();
            }
        }

        Menu.menu();
    }
}
