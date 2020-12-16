package com.abc.common;

public enum  ResEnum {
    SUCCESS(200,"success"),
    SUCCESS_USER_EXIST(201,"user exist success"),
    SUCCESS_EMP_BATCH(200,"success"),
    ERROR_USER_EXIST(501,"user exist error"),
    ERROR_EMP_BATCH(201,"error"),
    ERROR_PARAMS_IN_DELBATCH(404,"集合数据为空"),
    ERROR(500,"error");

    private final int status;
    private final String msg;

    ResEnum(int status, String msg  ) {
        this.status=status;
        this.msg=msg;
    }
    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

}
