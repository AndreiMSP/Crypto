import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Encrypted {
    public static void encrypted() throws IOException {
        System.out.println("Введите адрес файла для его зашифровки");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Введите ключ");
        Integer key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес файла куда записать результат");
        String dst = scanner.nextLine();
        CaesarCipher2 caesarCipher2 = new CaesarCipher2();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            while (bufferedReader.ready()) {

                String string = bufferedReader.readLine();
                String encrypt = caesarCipher2.encrypt(string, key);
                bufferedWriter.write(encrypt);
                bufferedWriter.newLine();
            }

        }
        System.out.println("Ваш файл был зашифрован");
    }
}