package org.example.jdk.encrypt;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: RSAEncryptionTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2025/7/10 10:12
 */
class RSAEncryptionTest {
    RSAEncryption rsaEncryption = new RSAEncryption();
    // 1. 生成密钥对（2048位）
    KeyPair keyPair = RSAEncryption.generateKeyPair();
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();

    RSAEncryptionTest() throws Exception {
    }

    @Test
    void encrypt() throws Exception {
        // 2. 原始数据
        String originalText = "Java非对称加密示例";
        System.out.println("原始文本: " + originalText);

        // 3. 使用公钥加密
        String encryptedText = rsaEncryption.encrypt(originalText, publicKey);
        System.out.println("加密结果: " + encryptedText);
        // 4. 使用私钥解密
        String decryptedText = rsaEncryption.decrypt(encryptedText, privateKey);
        System.out.println("解密结果: " + decryptedText);
    }

}