package cn.bpzzr.change.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private MD5Util() {

    }

    public static String md5(String pwd) {
        String hexString = null;
        try {
            StringBuffer sb = new StringBuffer();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(pwd.getBytes());
            for (byte b : digest) {
                int temp = b & 0xFF;
                hexString = Integer.toHexString(temp);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return pwd;
        }
    }

}
