package cn.njyazheng.mapper;

import cn.njyazheng.domain.GuestCard;
import org.apache.ibatis.jdbc.SQL;

public class GuestCardSqlProvider {

    public String insertSelective(GuestCard record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("R_GUESTCARD");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDepartmentId() != null) {
            sql.VALUES("department_id", "#{departmentId,jdbcType=INTEGER}");
        }
        
        if (record.getCardNumber() != null) {
            sql.VALUES("card_number", "#{cardNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getBalance() != null) {
            sql.VALUES("balance", "#{balance,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("is_delete", "#{isDelete,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GuestCard record) {
        SQL sql = new SQL();
        sql.UPDATE("R_GUESTCARD");
        
        if (record.getDepartmentId() != null) {
            sql.SET("department_id = #{departmentId,jdbcType=INTEGER}");
        }
        
        if (record.getCardNumber() != null) {
            sql.SET("card_number = #{cardNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{balance,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("is_delete = #{isDelete,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}