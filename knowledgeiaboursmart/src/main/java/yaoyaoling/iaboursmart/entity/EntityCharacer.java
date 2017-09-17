package yaoyaoling.iaboursmart.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class EntityCharacer implements MultiItemEntity {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    public int inemtType;//数目
    private String face;//人脸识别
    private String character;//文字识别
    private String imageg;//图像审核
    private String imageRecognition;//图像识别
    private String imageSearch;//图像搜索




    public String getFace() {
        return face;
    }

    public String getCharacter() {
        return character;
    }

    public String getImageg() {
        return imageg;
    }

    public String getImageRecognition() {
        return imageRecognition;
    }

    public String getImageSearch() {
        return imageSearch;
    }



    public void setFace(String face) {
        this.face = face;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setImageg(String imageg) {
        this.imageg = imageg;
    }

    public void setImageRecognition(String imageRecognition) {
        this.imageRecognition = imageRecognition;
    }

    public void setImageSearch(String imageSearch) {
        this.imageSearch = imageSearch;
    }



    public void setInemtType(int inemtType) {
        this.inemtType = inemtType;
    }
    @Override
    public int getItemType() {
        return inemtType;
    }
}
