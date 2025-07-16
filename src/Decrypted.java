import java.io.*;
import java.util.Scanner;

public class Decrypted {
    public static void decrypted() throws IOException {
        System.out.println("Введите адрес файла для его расшифровки");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Введите ключ");
        Integer key = Integer.parseInt((scanner.nextLine()));
        System.out.println("Введите адрес файла куда записать результат");
        String dst = scanner.nextLine();
        CaesarCipher2 caesarCipher2 = new CaesarCipher2();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String decrypt = caesarCipher2.decrypt(string, key);
                bufferedWriter.write(decrypt);
                bufferedWriter.newLine();
            }
        }
        System.out.println("Ваш файл был дешифрован");
    }
}
