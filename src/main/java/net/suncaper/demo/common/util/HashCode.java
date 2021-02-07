package net.suncaper.demo.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCode {
    /*public static String GetHashCode(String str) throws NoSuchAlgorithmException {

        try {
            //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
            //信息摘要是安全的单向哈希函数，它接收 任意大小的数据，并输出固定长度的哈希值。
            //MessageDigest 对象开始被初始化。
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            //通过使用 update 方法处理数据
            mDigest.update(str.getBytes());
            //调用 digest 方法之一完成哈希计算同时将Byte数组转换成16进制
            System.out.println("hash"+bytesToHexString(mDigest.digest()));

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MessageDigest mDigest = MessageDigest.getInstance("MD5");
        //通过使用 update 方法处理数据
        mDigest.update(str.getBytes());
        //调用 digest 方法之一完成哈希计算同时将Byte数组转换成16进制
        System.out.println("hash"+bytesToHexString(mDigest.digest()));
        return bytesToHexString(mDigest.digest());
    }
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //MD5加密后bytes长度16转换成32位16进制字符串
        for (int i = 0; i < bytes.length; i++) {

            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }*/
    public static int GetHashCode(String key) {
        int arraySize = 11113; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        return hashCode;
    }
}
