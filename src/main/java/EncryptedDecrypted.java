import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptedDecrypted {
    @SneakyThrows
    public static void encryptedDecrypted(boolean flag) {
        String text = "Введите адрес файла для его ";
        ConsoleHelper.writeMessage(text + (flag ? "шифрования" : "расшифровывания"));

        String src = ConsoleHelper.readString();
        System.out.println("Введите ключ шифрования:");
        int key = ConsoleHelper.readInt();
        Path dst = ConsoleHelper.buildFileName(src, flag ? "_e" : "_d");

        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = flag ?
                        caesarCipher.encrypt(string, key) :
                        caesarCipher.decrypt(string, key);
//                if (flag) {
//                    result = caesarCipher.encrypt(string, key);
//                } else {
//                    result = caesarCipher.decrypt(string, key);
//                }
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
        System.out.println("Ваш файл был " + (flag ? "зашифрован" : "расшифрован"));
    }
}
