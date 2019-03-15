package cn.njyazheng.domain;

import java.util.Date;

public class User {
    private String loginaccount;

    private String username;

    private String email;

    private String phonenum;

    private String address;

    private Integer certtype;

    private String certificate;

    private Date createtime;

    private Date modifytime;

    private String createoperator;

    private String modifyoperator;

    private Integer languagepref;

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount == null ? null : loginaccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getCerttype() {
        return certtype;
    }

    public void setCerttype(Integer certtype) {
        this.certtype = certtype;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getCreateoperator() {
        return createoperator;
    }

    public void setCreateoperator(String createoperator) {
        this.createoperator = createoperator == null ? null : createoperator.trim();
    }

    public String getModifyoperator() {
        return modifyoperator;
    }

    public void setModifyoperator(String modifyoperator) {
        this.modifyoperator = modifyoperator == null ? null : modifyoperator.trim();
    }

    public Integer getLanguagepref() {
        return languagepref;
    }

    public void setLanguagepref(Integer languagepref) {
        this.languagepref = languagepref;
    }
}