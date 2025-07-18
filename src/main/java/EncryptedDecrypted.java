import lombok.SneakyThrows;

import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    @SneakyThrows
    public static void encryptedDecrypted(boolean flag) {
        String text = "Введите адрес файла для его ";
        ConsoleHelper.writeMessage(text + (flag ? "шифрования" : "расшифровывания"));

        String src = ConsoleHelper.readString();
        System.out.println("Введите ключ шифрования:");
        int key = ConsoleHelper.readInt();
        System.out.println("Введите адрес файла куда записать результат:");
        String dst = ConsoleHelper.readString();
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
