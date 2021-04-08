package com.uver.pymes.object;

public class LoginResponse {
    private Integer code;
    private String status;
    private Entity entity;

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

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", entity=" + entity +
                '}';
    }
}
