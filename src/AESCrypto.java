import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESCrypto {

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String originalData = "SegurancaDaInformacao";

        // Gerando uma chave AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Tamanho da chave (128, 192 ou 256 bits)
        SecretKey secretKey = keyGen.generateKey();

        // Criptografando os dados
        String encryptedData = encrypt(originalData, secretKey);
        System.out.println("Dados Criptografados: " + encryptedData);

        // Descriptografando os dados
        String decryptedData = decrypt(encryptedData, secretKey);
        System.out.println("Dados Descriptografados: " + decryptedData);
    }
}
