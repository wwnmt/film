package com.wwn.film.gateway.response;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:04
 */
public class ResponseType<M> {
    // 返回状态【0-成功，1-业务失败，999-表示系统异常】
    private int status;
    // 返回信息
    private String msg;
    // 返回数据实体;
    private M data;

    private ResponseType() {
    }

    public static <M> ResponseType<M> success(M m) {
        ResponseType<M> responseVO = new ResponseType<>();
        responseVO.setStatus(0);
        responseVO.setData(m);

        return responseVO;
    }

    public static <M> ResponseType<M> success(String msg) {
        ResponseType<M> responseVO = new ResponseType<>();
        responseVO.setStatus(0);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static <M> ResponseType<M> serviceFail(String msg) {
        ResponseType<M> responseVO = new ResponseType<>();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static <M> ResponseType<M> appFail(String msg) {
        ResponseType<M> responseVO = new ResponseType<>();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }
}
