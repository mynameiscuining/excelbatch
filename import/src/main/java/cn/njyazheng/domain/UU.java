package cn.njyazheng.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author cuining
 * @date 2021/10/15 22:55
 */
public class UU {
    @ExcelProperty("用户编码")
    private String usercode;

    @ExcelProperty("用户名称")
    private String username;

    @ExcelProperty("卡类型名称")
    private String cardtype;

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

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    @Override
    public String toString() {
        return "UU{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", cardtype='" + cardtype + '\'' +
                '}';
    }
}
