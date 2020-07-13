package com.uver.pymes.object;

public class GenericResponse {
    private Integer code;
    private String status;
    private Object entity;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "CognitoLoginResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
