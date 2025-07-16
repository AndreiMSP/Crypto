import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие введя его номер");
            System.out.println("1. Зашифровать текст в файле");
            System.out.println("2. Расшифровать текст в файле");
            System.out.println("3. Подобрать ключ к зашифрованному файлу");
            System.out.println("4. Расшифровать файл с помощью статистического анализа");
            System.out.println("5. Выйти из программы");

            String answer = scanner.nextLine();
            if (answer.equals("1")) {
               EncryptedDecrypted.encryptedDecrypted(true);
            } else if (answer.equals("2")) {
                EncryptedDecrypted.encryptedDecrypted(false);
            } else if (answer.equals("3")) {
                System.out.println("action3");
            } else if (answer.equals("4")) {
                System.out.println("answer4");
            } else if (answer.equals("5")) {
                break;
            }

        }

    }
}