import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESCrypto {

    public static String encrypt(String data, SecretKey key) throws Exception {
        // Cria uma instância de um objeto de criptografia AES
        Cipher cipher = Cipher.getInstance("AES");
        // Inicializa o Cipher para o modo de criptografia
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // Criptografa os dados
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        // Retorna os dados criptografados em formato Base6
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        // Cria uma instância de um objeto de descriptografia AES
        Cipher cipher = Cipher.getInstance("AES");
        // Inicializa o Cipher para o modo de descriptografia
        cipher.init(Cipher.DECRYPT_MODE, key);
        // Decodifica os dados de Base64 para bytes
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        // Descriptografa os dados
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        // Converte os bytes descriptografados de volta para string
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String originalData = "SegurancaDaInformacao009";

        // Gerando uma chave AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        // Tamanho da chave (128, 192 ou 256 bits)
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        //Gera o resultado em Base64
        System.out.println("Chave AES: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        // Criptografando os dados
        String encryptedData = encrypt(originalData, secretKey);
        //Gera o resultado em Base64
        System.out.println("Dados Criptografados: " + encryptedData);

        // Descriptografando os dados
        String decryptedData = decrypt(encryptedData, secretKey);
        // Exibe os dados descriptografados
        System.out.println("Dados Descriptografados: " + decryptedData);
    }
}
