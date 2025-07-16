import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    public static void encryptedDecrypted(boolean flag) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (flag) {
            System.out.println("Введите адрес файла для его шифрования");
        } else {
            System.out.println("Введите адрес файла для его расшифровывания");
        }
        String src = scanner.nextLine();
        System.out.println("Введите ключ шифрования:");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес файла куда аписать результат:");
        String dst = scanner.nextLine();
        CaesarCipher2 caesarCipher2 = new CaesarCipher2();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = flag ?
                        caesarCipher2.encrypt(string, key) :
                        caesarCipher2.decrypt(string, key);
//                if (flag) {
//                    result = caesarCipher2.encrypt(string, key);
//                } else {
//                    result = caesarCipher2.decrypt(string, key);
//                }
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
        System.out.println("Ваш файл был " + (flag ? "зашифрован" : "расшифрован"));
    }
}
