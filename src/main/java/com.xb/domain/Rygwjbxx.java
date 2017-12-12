package com.xb.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Rygwjbxx {
    private String ryId;

    private String ryName;

    private String ryEgName;

    private Integer rySex;
    
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date ryCsrq;

    private Integer ryIdentity;

    private Integer ryZzmm;

    private String ryJg;

    private Integer ryNation;

    private Integer ryXl;

    private String ryFamily;

    private String ryContact;

    private String ryImg;

    private Integer ryPhone;

    private String ryDqFamily;

    private Integer ryJtPhone;

    private Integer ryHyzk;

    private Integer ryJjPhone;

    private Integer ygNumber;

    private Integer ygRzType;

    private String ygGzgw;

    private String ygJzGw;

    private Integer ygGzDq;

    private String ygGzEmp;

    private Integer ygGzPhone;
    
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date ygRzDate;

    private Date ygZzDate;

    private Integer ygForm;

    private Integer fjBlood;

    private Integer fjTz;

    private String fjBySchool;

    private String fjMail;

    private Integer fjHeight;

    private String fjMajor;

    private String fjFj;

    private String fjRemark;

    public String getRyId() {
        return ryId;
    }

    public void setRyId(String ryId) {
        this.ryId = ryId == null ? null : ryId.trim();
    }

    public String getRyName() {
        return ryName;
    }

    public void setRyName(String ryName) {
        this.ryName = ryName == null ? null : ryName.trim();
    }

    public String getRyEgName() {
        return ryEgName;
    }

    public void setRyEgName(String ryEgName) {
        this.ryEgName = ryEgName == null ? null : ryEgName.trim();
    }

    public Integer getRySex() {
        return rySex;
    }

    public void setRySex(Integer rySex) {
        this.rySex = rySex;
    }

    public Date getRyCsrq() {
        return ryCsrq;
    }

    public void setRyCsrq(Date ryCsrq) {
        this.ryCsrq = ryCsrq;
    }

    public Integer getRyIdentity() {
        return ryIdentity;
    }

    public void setRyIdentity(Integer ryIdentity) {
        this.ryIdentity = ryIdentity;
    }

    public Integer getRyZzmm() {
        return ryZzmm;
    }

    public void setRyZzmm(Integer ryZzmm) {
        this.ryZzmm = ryZzmm;
    }

    public String getRyJg() {
        return ryJg;
    }

    public void setRyJg(String ryJg) {
        this.ryJg = ryJg == null ? null : ryJg.trim();
    }

    public Integer getRyNation() {
        return ryNation;
    }

    public void setRyNation(Integer ryNation) {
        this.ryNation = ryNation;
    }

    public Integer getRyXl() {
        return ryXl;
    }

    public void setRyXl(Integer ryXl) {
        this.ryXl = ryXl;
    }

    public String getRyFamily() {
        return ryFamily;
    }

    public void setRyFamily(String ryFamily) {
        this.ryFamily = ryFamily == null ? null : ryFamily.trim();
    }

    public String getRyContact() {
        return ryContact;
    }

    public void setRyContact(String ryContact) {
        this.ryContact = ryContact == null ? null : ryContact.trim();
    }

    public String getRyImg() {
        return ryImg;
    }

    public void setRyImg(String ryImg) {
        this.ryImg = ryImg == null ? null : ryImg.trim();
    }

    public Integer getRyPhone() {
        return ryPhone;
    }

    public void setRyPhone(Integer ryPhone) {
        this.ryPhone = ryPhone;
    }

    public String getRyDqFamily() {
        return ryDqFamily;
    }

    public void setRyDqFamily(String ryDqFamily) {
        this.ryDqFamily = ryDqFamily == null ? null : ryDqFamily.trim();
    }

    public Integer getRyJtPhone() {
        return ryJtPhone;
    }

    public void setRyJtPhone(Integer ryJtPhone) {
        this.ryJtPhone = ryJtPhone;
    }

    public Integer getRyHyzk() {
        return ryHyzk;
    }

    public void setRyHyzk(Integer ryHyzk) {
        this.ryHyzk = ryHyzk;
    }

    public Integer getRyJjPhone() {
        return ryJjPhone;
    }

    public void setRyJjPhone(Integer ryJjPhone) {
        this.ryJjPhone = ryJjPhone;
    }

    public Integer getYgNumber() {
        return ygNumber;
    }

    public void setYgNumber(Integer ygNumber) {
        this.ygNumber = ygNumber;
    }

    public Integer getYgRzType() {
        return ygRzType;
    }

    public void setYgRzType(Integer ygRzType) {
        this.ygRzType = ygRzType;
    }

    public String getYgGzgw() {
        return ygGzgw;
    }

    public void setYgGzgw(String ygGzgw) {
        this.ygGzgw = ygGzgw == null ? null : ygGzgw.trim();
    }

    public String getYgJzGw() {
        return ygJzGw;
    }

    public void setYgJzGw(String ygJzGw) {
        this.ygJzGw = ygJzGw == null ? null : ygJzGw.trim();
    }

    public Integer getYgGzDq() {
        return ygGzDq;
    }

    public void setYgGzDq(Integer ygGzDq) {
        this.ygGzDq = ygGzDq;
    }

    public String getYgGzEmp() {
        return ygGzEmp;
    }

    public void setYgGzEmp(String ygGzEmp) {
        this.ygGzEmp = ygGzEmp == null ? null : ygGzEmp.trim();
    }

    public Integer getYgGzPhone() {
        return ygGzPhone;
    }

    public void setYgGzPhone(Integer ygGzPhone) {
        this.ygGzPhone = ygGzPhone;
    }

    public Date getYgRzDate() {
        return ygRzDate;
    }

    public void setYgRzDate(Date ygRzDate) {
        this.ygRzDate = ygRzDate;
    }

    public Date getYgZzDate() {
        return ygZzDate;
    }

    public void setYgZzDate(Date ygZzDate) {
        this.ygZzDate = ygZzDate;
    }

    public Integer getYgForm() {
        return ygForm;
    }

    public void setYgForm(Integer ygForm) {
        this.ygForm = ygForm;
    }

    public Integer getFjBlood() {
        return fjBlood;
    }

    public void setFjBlood(Integer fjBlood) {
        this.fjBlood = fjBlood;
    }

    public Integer getFjTz() {
        return fjTz;
    }

    public void setFjTz(Integer fjTz) {
        this.fjTz = fjTz;
    }

    public String getFjBySchool() {
        return fjBySchool;
    }

    public void setFjBySchool(String fjBySchool) {
        this.fjBySchool = fjBySchool == null ? null : fjBySchool.trim();
    }

    public String getFjMail() {
        return fjMail;
    }

    public void setFjMail(String fjMail) {
        this.fjMail = fjMail == null ? null : fjMail.trim();
    }

    public Integer getFjHeight() {
        return fjHeight;
    }

    public void setFjHeight(Integer fjHeight) {
        this.fjHeight = fjHeight;
    }

    public String getFjMajor() {
        return fjMajor;
    }

    public void setFjMajor(String fjMajor) {
        this.fjMajor = fjMajor == null ? null : fjMajor.trim();
    }

    public String getFjFj() {
        return fjFj;
    }

    public void setFjFj(String fjFj) {
        this.fjFj = fjFj == null ? null : fjFj.trim();
    }

    public String getFjRemark() {
        return fjRemark;
    }

    public void setFjRemark(String fjRemark) {
        this.fjRemark = fjRemark == null ? null : fjRemark.trim();
    }
}