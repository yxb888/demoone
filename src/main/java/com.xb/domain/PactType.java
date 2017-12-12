package com.xb.domain;

public class PactType {
    private String pacttypeid;

    private String pacttypename;

    private String pacttypeaccess;

    public String getPacttypeid() {
        return pacttypeid;
    }

    public void setPacttypeid(String pacttypeid) {
        this.pacttypeid = pacttypeid == null ? null : pacttypeid.trim();
    }

    public String getPacttypename() {
        return pacttypename;
    }

    public void setPacttypename(String pacttypename) {
        this.pacttypename = pacttypename == null ? null : pacttypename.trim();
    }

    public String getPacttypeaccess() {
        return pacttypeaccess;
    }

    public void setPacttypeaccess(String pacttypeaccess) {
        this.pacttypeaccess = pacttypeaccess == null ? null : pacttypeaccess.trim();
    }
}