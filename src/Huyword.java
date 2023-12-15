import java.util.Scanner;

class Huyword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите ваше слово");
            String word = scanner.nextLine();
            System.out.println("Хуй" + word + ".");
            if (word.equals("Хуй")) {
                break;
            }
        }
    }
}