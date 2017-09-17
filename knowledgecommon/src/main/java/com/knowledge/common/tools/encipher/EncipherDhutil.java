package com.knowledge.common.tools.encipher;



import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;


/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class EncipherDhutil {

    public EncipherDhutil() {

    }

    //甲
    public static final String PUBLIC_KEY = "DHPublicKey";
    public static final String PRIVATE_KEY = "DHPrivatekey";

    //甲返回密钥对
    public static Map<String, Object> armourInitKey() throws Exception {
        //实例话生成器
        KeyPairGenerator mkeyPairGenerator = KeyPairGenerator.getInstance("DH");
        //初始化密钥生成器，默认是1024位
        mkeyPairGenerator.initialize(256);
        //生成密钥对
        KeyPair mkeyPair = mkeyPairGenerator.generateKeyPair();
        //得到甲方公钥
        DHPublicKey mdhPublicKey = (DHPublicKey) mkeyPair.getPublic();
        //得到甲方私钥
        DHPrivateKey mdhPrivateKey = (DHPrivateKey) mkeyPair.getPrivate();
        //将公钥和私钥放在map里方便我们使用
        Map<String, Object> mkeyMap = new HashMap<String, Object>();
        mkeyMap.put(PUBLIC_KEY, mdhPublicKey);
        mkeyMap.put(PRIVATE_KEY, mdhPrivateKey);

        return mkeyMap;
    }

    public static Map<String, Object> secondInitKey(byte[] key) {
        //将甲方公钥从字节数组转化为publickey
        X509EncodedKeySpec mkeySpec = new X509EncodedKeySpec(key);
        //实例化密钥工厂
        KeyFactory mkeyFactory = null;
        try {
            mkeyFactory = KeyFactory.getInstance("DH");

            //产生甲方公钥
            DHPublicKey mdhPublicKey = (DHPublicKey) mkeyFactory.generatePublic(mkeySpec);
            //部析甲方公钥，得到其参数
            DHParameterSpec mdhParameterSpec = mdhPublicKey.getParams();
            //实例化密钥生成器
            KeyPairGenerator mkeyPairGenerator = KeyPairGenerator.getInstance("DH");
            //用甲方公钥初始密钥产生密钥对
            mkeyPairGenerator.initialize(mdhParameterSpec);
            //产生密钥
            KeyPair mkeyPair = mkeyPairGenerator.generateKeyPair();
            //得到已方的公钥
            DHPublicKey mdhPublcKey = (DHPublicKey) mkeyPair.getPublic();
            //得到已方的私钥
            DHPrivateKey mdhPrivateKey = (DHPrivateKey) mkeyPair.getPrivate();
            //将公钥和私钥装在map中
            Map<String, Object> mkeyMap = new HashMap<String, Object>();
            mkeyMap.put(PUBLIC_KEY, mdhPublcKey);
            mkeyMap.put(PRIVATE_KEY, mdhPrivateKey);
            return mkeyMap;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*生成本地密钥*/
    public byte[] getSecretKey(byte[] publickey, byte[] privatekey) throws Exception {

        //实例化密钥工厂
        KeyFactory mkeyFactory = KeyFactory.getInstance("DH");
        //将公钥钥从字节数组转化为PublicKey
        X509EncodedKeySpec mx509EncodedKeySpec = new X509EncodedKeySpec(publickey);
        PublicKey mpubkey = mkeyFactory.generatePublic(mx509EncodedKeySpec);
        //将私钥从字节数组转化为Privaterkey
        PKCS8EncodedKeySpec mpkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privatekey);
        PrivateKey mpivkey = mkeyFactory.generatePrivate(mpkcs8EncodedKeySpec);
        //准备根据以上公钥和私钥生成本地密钥
        KeyAgreement mkeyAgreement = KeyAgreement.getInstance("DH");
        //用自己的私钥初始化KeyAgreement
        mkeyAgreement.init(mpivkey);
        //先实例化KeyAgreement

        //集合对方额公钥进行运算
        mkeyAgreement.doPhase(mpubkey, true);
        //开始生成本地SecretKey 密钥算法为对称加密算法
        SecretKey msecretKey = mkeyAgreement.generateSecret("AES");
        return msecretKey.getEncoded();

    }


    /*从Map中取公钥*/
    public byte[] getPublickey(Map<String, Object> keyMap) {
        DHPublicKey key = (DHPublicKey) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /*从Map中取私钥*/
    public byte[] getPrivatekey(Map<String, Object> keyMap) {
        DHPrivateKey key = (DHPrivateKey) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

}
