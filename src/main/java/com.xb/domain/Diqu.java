package com.xb.domain;

public class Diqu {
    private String tId;

    private String tDiquname;

    private String tEgName;

    private String tBeizhu;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public String gettDiquname() {
        return tDiquname;
    }

    public void settDiquname(String tDiquname) {
        this.tDiquname = tDiquname == null ? null : tDiquname.trim();
    }

    public String gettEgName() {
        return tEgName;
    }

    public void settEgName(String tEgName) {
        this.tEgName = tEgName == null ? null : tEgName.trim();
    }

    public String gettBeizhu() {
        return tBeizhu;
    }

    public void settBeizhu(String tBeizhu) {
        this.tBeizhu = tBeizhu == null ? null : tBeizhu.trim();
    }
}