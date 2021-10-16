package cn.njyazheng.dao;

import cn.njyazheng.domain.Department;
import org.apache.ibatis.jdbc.SQL;

public class DepartmentSqlProvider {

    public String insertSelective(Department record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("department_info");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }

        if (record.getDepartmentName() != null) {
            sql.VALUES("department_name", "#{departmentName,jdbcType=VARCHAR}");
        }

        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }

        if (record.getParentIdList() != null) {
            sql.VALUES("parent_id_list", "#{parentIdList,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }

        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=INTEGER}");
        }

        if (record.getUpdateUser() != null) {
            sql.VALUES("update_user", "#{updateUser,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Department record) {
        SQL sql = new SQL();
        sql.UPDATE("department_info");

        if (record.getDepartmentName() != null) {
            sql.SET("department_name = #{departmentName,jdbcType=VARCHAR}");
        }

        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }

        if (record.getParentIdList() != null) {
            sql.SET("parent_id_list = #{parentIdList,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }

        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{createUser,jdbcType=INTEGER}");
        }

        if (record.getUpdateUser() != null) {
            sql.SET("update_user = #{updateUser,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        sql.WHERE("company_id = #{companyId,jdbcType=INTEGER}");

        return sql.toString();
    }
}
