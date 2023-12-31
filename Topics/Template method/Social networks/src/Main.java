import java.util.Scanner;

abstract class SocialNetwork {

    public void connect() {
        // write your code here ...
        LogIn();
        Post();
        LogOut();
    }

      // write your code here ...
    abstract void LogIn();
    abstract void Post();
    abstract void LogOut();

}

class Instagram extends SocialNetwork{
     // write your code here ...

    @Override
    void LogIn() {
        System.out.println("Log into Instagram");
    }

    @Override
    void Post() {
        System.out.println("Post: Hello, Instagram!");
    }

    @Override
    void LogOut() {
        System.out.println("Log out of Instagram");
    }
}


class Facebook extends SocialNetwork{
  // write your code here ...

    @Override
    void LogIn() {
        System.out.println("Log into Facebook");
    }

    @Override
    void Post() {
        System.out.println("Post: Hello, Facebook!");
    }

    @Override
    void LogOut() {
        System.out.println("Log out of Facebook");
    }
}

// Do not change the code below
class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        SocialNetwork network = null;
        if ("facebook".equalsIgnoreCase(type)) {
            network = new Facebook();
        } else if ("instagram".equalsIgnoreCase(type)) {
            network = new Instagram();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        network.connect();
    }
}