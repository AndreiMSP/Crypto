public class CaesarCipher2 {
    private static String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    public String encrypt(String message, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char element = message.charAt(i);
            int index = ALPHABET.indexOf(element);
            if (index >=0) {
                int newIndex = index + key;
                if (newIndex < 0) {
                    while (newIndex < 0) {
                        newIndex = newIndex + ALPHABET.length();
                    }
                } else {
                    while (newIndex >= ALPHABET.length()) {
                        newIndex = newIndex - ALPHABET.length();
                    }
                }
                char encryptElement = ALPHABET.charAt(newIndex);
                stringBuilder.append(encryptElement);
            }

        }
        return stringBuilder.toString();
    }

    public String decrypt(String message, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char element = message.charAt(i);
            int index = ALPHABET.indexOf(element);
            if (index >= 0) {

                int newIndex = index - key;
                if (newIndex > 0) {
                    while (newIndex >= ALPHABET.length()) {
                        newIndex = newIndex - ALPHABET.length();
                    }
                } else {
                    while (newIndex < 0) {
                        newIndex = newIndex + ALPHABET.length();
                    }
                }
                char encryptElement = ALPHABET.charAt(newIndex);
                stringBuilder.append(encryptElement);
            }
        }
        return stringBuilder.toString();
    }


}
