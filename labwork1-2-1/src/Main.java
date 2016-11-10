public class Main {
    private static void example2() {
        String a = "  ***\n"
                + "    *\n"
                + "    *\n"
                + "*   *\n"
                + " *** \n";

        String b = "  *  \n"
                + "*   *\n"
                + "*   *\n"
                + "*****\n"
                + "*   *\n";

        String c = "*   *\n"
                + "*   *\n"
                + "*   *\n"
                + " * * \n"
                + "  *  \n";

        String[] linesA = a.split("\n");
        String[] linesB = b.split("\n");
        String[] linesC = c.split("\n");

        for (int i = 0; i < linesA.length; i++) {
            System.out.println(linesA[i] + " " + linesB[i] + " " + linesC[i] + " " + linesB[i]);
        }

    }

    private static void example1() {
        System.out.println("  ***   *   *   *  *  ");
        System.out.println("    * *   * *   * *   *");
        System.out.println("    * *   * *   * *   *");
        System.out.println("*   * *****  * *  *****");
        System.out.println(" ***  *   *   *   *   *");
    }

    public static void main(String[] args) {
        Main.example1();
        System.out.println("--------------------------------------");
        example2();
    }
}
