package cn.njyazheng.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import org.springframework.util.StringUtils;

import static cn.njyazheng.util.Tools.leftComplement;

/**
 * @author cuining
 * @date 2021/10/15 14:42
 */
public class Consums {
    @ExcelProperty("修改时间")
    private String modifytime;
    @ExcelProperty("用户编码")
    private String usercode;
    @ExcelProperty("用户名称")
    private String username;
    @ExcelProperty("订餐单号")
    private String ordercode;
    @ExcelProperty("备注")
    private String mark;
    @ExcelProperty("所属食堂名称")
    private String refers;
    @ExcelProperty("交易时间")
    private String ordertime;

    @ExcelProperty("扣款金额")
    private Float koukuan;

    @ExcelProperty("充值消费金额")
    private Float czxfje;

    @ExcelProperty("工作餐消费金额")
    private Float gzcxfje;

    @ExcelProperty("补贴餐消费金额")
    private Float btxfje;

    @ExcelProperty("数据来源")
    private String source;

    @ExcelProperty("数据来源单号")
    private String datacode;

    @ExcelProperty("识别单号")
    private String recgcode;

    @ExcelProperty("经手人")
    private String saller;
    @ExcelProperty("饭卡卡号")
    private String card;

    private String danme;

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getRefers() {
        return refers;
    }

    public void setRefers(String refers) {
        this.refers = refers;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Float getKoukuan() {
        return koukuan;
    }

    public void setKoukuan(Float koukuan) {
        this.koukuan = koukuan;
    }

    public Float getCzxfje() {
        return czxfje;
    }

    public void setCzxfje(Float czxfje) {
        this.czxfje = czxfje;
    }

    public Float getGzcxfje() {
        return gzcxfje;
    }

    public void setGzcxfje(Float gzcxfje) {
        this.gzcxfje = gzcxfje;
    }

    public Float getBtxfje() {
        return btxfje;
    }

    public void setBtxfje(Float btxfje) {
        this.btxfje = btxfje;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDatacode() {
        return datacode;
    }

    public void setDatacode(String datacode) {
        this.datacode = datacode;
    }

    public String getRecgcode() {
        return recgcode;
    }

    public void setRecgcode(String recgcode) {
        this.recgcode = recgcode;
    }

    public String getSaller() {
        return saller;
    }

    public void setSaller(String saller) {
        this.saller = saller;
    }

    public String getCard() {
        if (StringUtils.isEmpty(card)) {
            card = "00000000";
        } else if (card.length() < 8) {
            leftComplement(8, card, "0");
        }
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Consums{" +
                "modifytime='" + modifytime + '\'' +
                ", usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", ordercode='" + ordercode + '\'' +
                ", mark='" + mark + '\'' +
                ", refers='" + refers + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", koukuan=" + koukuan +
                ", czxfje=" + czxfje +
                ", gzcxfje=" + gzcxfje +
                ", btxfje=" + btxfje +
                ", source='" + source + '\'' +
                ", datacode='" + datacode + '\'' +
                ", recgcode='" + recgcode + '\'' +
                ", saller='" + saller + '\'' +
                ", card='" + getCard() + '\'' +
                '}';
    }

    public String getDanme() {
        return danme;
    }

    public void setDanme(String danme) {
        this.danme = danme;
    }
}
