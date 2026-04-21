package test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Test29 {
    
    public static void main(String[] args) throws Exception {
        // 原始字符串
        String originalText = "Hello, AES and Base64 Encryption!";
        System.out.println("原始文本: " + originalText);
        
        // 生成AES密钥
        SecretKey secretKey = generateAESKey();
        byte[] keyBytes = secretKey.getEncoded();
        
        // 加密
        String encryptedText = encrypt(originalText, keyBytes);
        System.out.println("加密后(Base64): " + encryptedText);
        
        // 解密
        String decryptedText = decrypt(encryptedText, keyBytes);
        System.out.println("解密后: " + decryptedText);
    }
    
    /**
     * 生成AES密钥
     */
    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 128位密钥
        return keyGenerator.generateKey();
    }
    
    /**
     * AES加密后Base64编码
     */
    public static String encrypt(String text, byte[] keyBytes) throws Exception {
        // 创建AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        
        // 初始化加密器
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        
        // 加密
        byte[] encryptedBytes = cipher.doFinal(text.getBytes("UTF-8"));
        
        // Base64编码
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    /**
     * Base64解码后AES解密
     */
    public static String decrypt(String encryptedText, byte[] keyBytes) throws Exception {
        // Base64解码
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        
        // 创建AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        
        // 初始化解密器
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        
        // 解密
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        
        return new String(decryptedBytes, "UTF-8");
    }
}