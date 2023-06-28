class Problem {
    public static void main(String[] args) {
        String a = args[0];
        String sb = args[1];
        int b = Integer.parseInt(sb);
        String sc = args[2];
        int c = Integer.parseInt(sc);
        switch(a) {
            case "+" -> System.out.println(b + c);
            case "-" -> System.out.println(b - c);
            case "*" -> System.out.println(b * c);
            default -> System.out.println("Unknown operator");
        }
    }
}
