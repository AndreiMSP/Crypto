public class CaesarCipher {
    private static String ALPHABET = "";

    public String encrypt(String message, int key) {
        char[] arrays = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arrays.length; i++) {
            int index = ALPHABET.indexOf(arrays[i]);
            if (index >= 0) {
                int newIndex = (index + key) % ALPHABET.length();
                char charAt = 0;
                if (newIndex < 0) {
                    charAt = ALPHABET.charAt(newIndex + ALPHABET.length());
                } else {
                    charAt = ALPHABET.charAt(newIndex);
                }
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, key * -1);
    }
}