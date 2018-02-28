package cn.bpzzr.change.util;

import android.support.annotation.NonNull;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import cn.bpzzr.change.util.blankj.DeviceUtils;

/**
 * Created by Administrator on 2018/2/28.
 * AES加密工具类
 */

public class AESUtil {
    private static final String TAG = "AESUtil";
    /**
     * 密码
     */
    private Cipher cipher;
    /**
     * 加密的钥匙
     */
    private SecretKeySpec key;
    /**
     * 加密算法参数
     */
    private AlgorithmParameterSpec spec;
    /**
     * 采用sha-256加密算法
     */
    private static final String ALGORITHM_SHA_256 = "SHA-256";
    /**
     * 编解码中间字符集UTF-8
     */
    private static final String CHARSET_NAME = "UTF-8";
    /**
     * 模式
     */
    private static final String CBC_PK_CS_5_PADDING = "AES/CBC/PKCS5Padding";
    /**
     * 加密类型AES
     */
    private static final String AES = "AES";
    /**
     * 加密或解密失败返回字符串
     */
    public static final String FAIL_RETURN_STR = "AES_UTIL_FAIL";

    public AESUtil(String appSecret) {
        //获取信息摘要
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance(ALGORITHM_SHA_256);
            //根据密钥获取摘要
            localMessageDigest.update(appSecret.getBytes(CHARSET_NAME));
            byte[] arrayOfByte = new byte[32];
            System.arraycopy(localMessageDigest.digest(), 0, arrayOfByte, 0, arrayOfByte.length);
            this.cipher = Cipher.getInstance(CBC_PK_CS_5_PADDING);
            this.key = new SecretKeySpec(arrayOfByte, AES);
            this.spec = getIV();
        } catch (Exception e) {
            LogUtil.e(TAG, "init AES fail >> " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 解密的方法
     *
     * @param paramString 要解密的字符串
     * @return 返回解密串
     */
    public String decrypt(String paramString) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            byte[] arrayOfByte = Base64.decode(paramString, Base64.DEFAULT);
            return new String(cipher.doFinal(arrayOfByte), CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, "ase decrypt is failure ! >> " + e.getMessage());
            return MD5Util.md5(FAIL_RETURN_STR);
        }
    }

    /**
     * 加密的方法
     *
     * @param paramString 要加密的字符串
     * @return 返回加密串
     */
    public String encrypt(String paramString) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, spec);
            return new String(Base64.encode(cipher.doFinal(
                    paramString.getBytes(CHARSET_NAME)), Base64.DEFAULT), CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, "ase encrypt is failure ! >> " + e.getMessage());
            return MD5Util.md5(FAIL_RETURN_STR);
        }
    }

    /**
     * 获取32位的偏移量
     */
    @NonNull
    private AlgorithmParameterSpec getIV() {
        return new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
}
