package cn.njyazheng.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author cuining
 * @date 2021/10/15 15:42
 */
public class Oper {
    @ExcelProperty("操作员名称")
    private String oper;
    @ExcelProperty("所属餐饮公司")
    private String company;

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
