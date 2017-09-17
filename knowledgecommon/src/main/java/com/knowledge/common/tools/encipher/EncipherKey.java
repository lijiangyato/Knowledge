package com.knowledge.common.tools.encipher;

import java.util.Map;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:得到密钥
 */

public class EncipherKey {
    private byte[] publicKey1;
    private byte[] privateKey1;
    private byte[] publicKey2;
    private byte[] privateKey2;


    public EncipherKey() {
        encipherDhutil = new EncipherDhutil();
    }


    public Map<String, Object> map1;
    public Map<String, Object> map2;

    public EncipherDhutil encipherDhutil;

    private void armourpublickey() {
        try {
            map1 = encipherDhutil.armourInitKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        publicKey1 = encipherDhutil.getPublickey(map1);
        privateKey1 = encipherDhutil.getPrivatekey(map1);

    }


    /*甲本地密钥*/
    public byte[] armourthiskey() {
        armourpublickey();
        alreadypublickey();
        byte[] secretKey1;
        try {
            secretKey1 = encipherDhutil.getSecretKey(publicKey2, privateKey1);
            return secretKey1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void alreadypublickey() {
        map2 = encipherDhutil.secondInitKey(publicKey1);
        publicKey2 = encipherDhutil.getPublickey(map2);
        privateKey2 = encipherDhutil.getPrivatekey(map2);
    }


    /*已本地密码*/
    public byte[] alreadythiskey() {
        armourpublickey();
        alreadypublickey();
        byte[] secretKey2;
        try {
            secretKey2 = encipherDhutil.getSecretKey(publicKey1, privateKey2);
            return secretKey2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}