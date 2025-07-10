package org.example.jdk.encrypt;


import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * ClassName: RSAEncryption
 * Description:
 *
 * @author Yuliang Lau
 * @date 2025/7/10 9:52
 */
public class RSAEncryption {
    /**
     * 生成RSA密钥对（2048位）
     */
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        // 安全标准建议至少2048位[1,7](@ref)
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    /**
     * 公钥加密
     *
     * @param plainText 明文
     * @param publicKey 公钥对象
     */
    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        // Base64编码便于传输[6,7](@ref)
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 私钥解密
     *
     * @param encryptedText 加密文本（Base64格式）
     * @param privateKey    私钥对象
     */
    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8");
    }

    /**
     * 从Base64字符串还原公钥（用于跨系统传输）
     */
    public static PublicKey getPublicKey(String base64PublicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(base64PublicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }

    /**
     * 从Base64字符串还原私钥
     */
    public static PrivateKey getPrivateKey(String base64PrivateKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(base64PrivateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePrivate(keySpec);
    }
}
