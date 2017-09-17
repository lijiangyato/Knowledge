package com.knowledge.common.database.surface;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:数据简析统一接口
 */

public class SurfaceDataBack<T> {

    private boolean isSucess;    //是否成功（bool）
    private int errCode;        //错误代码
    private String errMsg;     //错误消息

    public boolean isSucess() {
        return isSucess;
    }

    public void setSucess(boolean sucess) {
        isSucess = sucess;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }


}
