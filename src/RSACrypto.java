import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSACrypto {

    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String originalData = "SegurancaDaInformacao";

        // Gerando o par de chaves RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Tamanho da chave
        KeyPair pair = keyGen.generateKeyPair();

        // Criptografando os dados
        String encryptedData = encrypt(originalData, pair.getPublic());
        System.out.println("Dados Criptografados com RSA: " + encryptedData);

        // Descriptografando os dados
        String decryptedData = decrypt(encryptedData, pair.getPrivate());
        System.out.println("Dados Descriptografados com RSA: " + decryptedData);
    }
}
