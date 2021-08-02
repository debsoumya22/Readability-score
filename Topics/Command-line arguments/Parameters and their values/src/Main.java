class Problem {
    public static void main(String[] args) {
        for (int i = 0, j = 1; j < args.length; i += 2, j += 2) {
            System.out.println(args[i] + "=" + args[j]);
        }
    }
}
