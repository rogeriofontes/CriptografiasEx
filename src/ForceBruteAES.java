import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class ForceBruteAES {

    public static String decryptWithKey(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void bruteForce(String encryptedData, String knownPart) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // Tentativa de força bruta de uma chave simples de 3 caracteres
        for (char c1 : alphabet.toCharArray()) {
            for (char c2 : alphabet.toCharArray()) {
                for (char c3 : alphabet.toCharArray()) {
                    String trialKey = "" + c1 + c2 + c3 + "00000000000000"; // Exemplo de chave de 16 bytes
                    try {
                        String decryptedData = decryptWithKey(encryptedData, trialKey);
                        if (decryptedData.contains(knownPart)) {
                            System.out.println("Chave encontrada: " + trialKey);
                            System.out.println("Dados Descriptografados: " + decryptedData);
                            return;
                        }
                    } catch (Exception e) {
                        // Ignorar exceção para chaves inválidas
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String encryptedData = "A Seguranca é o melhor conhecimento"; // Coloque aqui o dado criptografado
        String knownPart = "Seguranca"; // Parte conhecida do texto original

        bruteForce(encryptedData, knownPart);
    }
}
