package cn.njyazheng.domain;

import java.util.Date;

public class Renew {
    private  String table ;
    private Integer serno;

    private String subscriptionid;

    private String loginaccount;

    private String productid;

    private Integer campaignid;

    private Integer strategyid;

    private Integer ruleid;

    private String param;

    private Date firstsubscribetime;

    private Date lastsubscribetime;

    private Integer renewtimes;

    private Integer renewtype;

    private Integer period;

    private Integer fee;

    private Integer realfee;

    private Integer paytype;

    private Integer processstatus;

    private Date moddate;

    public Integer getSerno() {
        return serno;
    }

    public void setSerno(Integer serno) {
        this.serno = serno;
    }

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid == null ? null : subscriptionid.trim();
    }

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount == null ? null : loginaccount.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public Integer getCampaignid() {
        return campaignid;
    }

    public void setCampaignid(Integer campaignid) {
        this.campaignid = campaignid;
    }

    public Integer getStrategyid() {
        return strategyid;
    }

    public void setStrategyid(Integer strategyid) {
        this.strategyid = strategyid;
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public Date getFirstsubscribetime() {
        return firstsubscribetime;
    }

    public void setFirstsubscribetime(Date firstsubscribetime) {
        this.firstsubscribetime = firstsubscribetime;
    }

    public Date getLastsubscribetime() {
        return lastsubscribetime;
    }

    public void setLastsubscribetime(Date lastsubscribetime) {
        this.lastsubscribetime = lastsubscribetime;
    }

    public Integer getRenewtimes() {
        return renewtimes;
    }

    public void setRenewtimes(Integer renewtimes) {
        this.renewtimes = renewtimes;
    }

    public Integer getRenewtype() {
        return renewtype;
    }

    public void setRenewtype(Integer renewtype) {
        this.renewtype = renewtype;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getRealfee() {
        return realfee;
    }

    public void setRealfee(Integer realfee) {
        this.realfee = realfee;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getProcessstatus() {
        return processstatus;
    }

    public void setProcessstatus(Integer processstatus) {
        this.processstatus = processstatus;
    }

    public Date getModdate() {
        return moddate;
    }

    public void setModdate(Date moddate) {
        this.moddate = moddate;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}