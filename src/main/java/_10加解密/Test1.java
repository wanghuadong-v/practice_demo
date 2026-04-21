package _10加解密;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Test1 {
    public static void main(String[] args){
        // 工号
        String employeeId = "123456";

        try {
            // 加密工号
            String encryptedToken = encryptEmployeeId(employeeId);
            System.out.println("加密后的token: " + encryptedToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密工号：先AES加密，再Base64加密
     */
    public static String encryptEmployeeId(String employeeId) throws Exception {
        // 接口文档提供的IV和Key（Base64编码）
        String ivStr = "MIIBIjANBgkqhkiG";
        String keyStr = "MIIEvwIBADANBgkq";

        try {
            // 解码Base64
//            byte[] iv = Base64.getDecoder().decode(ivStr);
//            byte[] key = Base64.getDecoder().decode(keyStr);
            byte[] iv = ivStr.getBytes(StandardCharsets.UTF_8);
            byte[] key = keyStr.getBytes(StandardCharsets.UTF_8);

            // 验证密钥长度
            if (key.length != 16) {
                throw new IllegalArgumentException("AES-128密钥长度必须为16字节，当前长度: " + key.length);
            }
            if (iv.length != 16) {
                throw new IllegalArgumentException("IV长度必须为16字节，当前长度: " + iv.length);
            }

            // 初始化AES加密器
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            // 加密
            byte[] encrypted = cipher.doFinal(employeeId.getBytes(StandardCharsets.UTF_8));

            // Base64加密
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (IllegalArgumentException e) {
            System.err.println("密钥或IV格式错误: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("加密过程出错: " + e.getMessage());
            throw e;
        }
    }
}
