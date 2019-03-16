package cn.njyazheng.domain;

import java.util.Date;

public class SubscribeInfo {

    private String table;

    private String subscriptionid;

    private String spid;

    private String orderid;

    private Integer orderflag;

    private String itemid;

    private String oa;

    private Integer oauserflag;

    private String da;

    private Integer dauserflag;

    private String fa;

    private Integer fatype;

    private String originid;

    private Integer status;

    private Date subscribetime;

    private Date effectivetime;

    private Date expiretime;

    private String suspendreason;

    private Date suspendtime;

    private Date resumetime;

    private String withdrawreason;

    private Date withdrawtime;

    private Integer issubscription;

    private Integer fee;

    private Integer realfee;

    private Integer paytype;

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid == null ? null : subscriptionid.trim();
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid == null ? null : spid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getOrderflag() {
        return orderflag;
    }

    public void setOrderflag(Integer orderflag) {
        this.orderflag = orderflag;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getOa() {
        return oa;
    }

    public void setOa(String oa) {
        this.oa = oa == null ? null : oa.trim();
    }

    public Integer getOauserflag() {
        return oauserflag;
    }

    public void setOauserflag(Integer oauserflag) {
        this.oauserflag = oauserflag;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da == null ? null : da.trim();
    }

    public Integer getDauserflag() {
        return dauserflag;
    }

    public void setDauserflag(Integer dauserflag) {
        this.dauserflag = dauserflag;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa == null ? null : fa.trim();
    }

    public Integer getFatype() {
        return fatype;
    }

    public void setFatype(Integer fatype) {
        this.fatype = fatype;
    }

    public String getOriginid() {
        return originid;
    }

    public void setOriginid(String originid) {
        this.originid = originid == null ? null : originid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubscribetime() {
        return subscribetime;
    }

    public void setSubscribetime(Date subscribetime) {
        this.subscribetime = subscribetime;
    }

    public Date getEffectivetime() {
        return effectivetime;
    }

    public void setEffectivetime(Date effectivetime) {
        this.effectivetime = effectivetime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public String getSuspendreason() {
        return suspendreason;
    }

    public void setSuspendreason(String suspendreason) {
        this.suspendreason = suspendreason == null ? null : suspendreason.trim();
    }

    public Date getSuspendtime() {
        return suspendtime;
    }

    public void setSuspendtime(Date suspendtime) {
        this.suspendtime = suspendtime;
    }

    public Date getResumetime() {
        return resumetime;
    }

    public void setResumetime(Date resumetime) {
        this.resumetime = resumetime;
    }

    public String getWithdrawreason() {
        return withdrawreason;
    }

    public void setWithdrawreason(String withdrawreason) {
        this.withdrawreason = withdrawreason == null ? null : withdrawreason.trim();
    }

    public Date getWithdrawtime() {
        return withdrawtime;
    }

    public void setWithdrawtime(Date withdrawtime) {
        this.withdrawtime = withdrawtime;
    }

    public Integer getIssubscription() {
        return issubscription;
    }

    public void setIssubscription(Integer issubscription) {
        this.issubscription = issubscription;
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

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "SubscribeInfo{" +
                "table='" + table + '\'' +
                ", subscriptionid='" + subscriptionid + '\'' +
                ", spid='" + spid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", orderflag=" + orderflag +
                ", itemid='" + itemid + '\'' +
                ", oa='" + oa + '\'' +
                ", oauserflag=" + oauserflag +
                ", da='" + da + '\'' +
                ", dauserflag=" + dauserflag +
                ", fa='" + fa + '\'' +
                ", fatype=" + fatype +
                ", originid='" + originid + '\'' +
                ", status=" + status +
                ", subscribetime=" + subscribetime +
                ", effectivetime=" + effectivetime +
                ", expiretime=" + expiretime +
                ", suspendreason='" + suspendreason + '\'' +
                ", suspendtime=" + suspendtime +
                ", resumetime=" + resumetime +
                ", withdrawreason='" + withdrawreason + '\'' +
                ", withdrawtime=" + withdrawtime +
                ", issubscription=" + issubscription +
                ", fee=" + fee +
                ", realfee=" + realfee +
                ", paytype=" + paytype +
                '}';
    }
}