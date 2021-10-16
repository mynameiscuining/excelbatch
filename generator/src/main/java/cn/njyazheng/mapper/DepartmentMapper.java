package cn.njyazheng.mapper;

import cn.njyazheng.domain.Department;
import cn.njyazheng.domain.DepartmentKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DepartmentMapper {
    @Delete({
        "delete from department_info",
        "where id = #{id,jdbcType=INTEGER}",
          "and company_id = #{companyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(DepartmentKey key);

    @Insert({
        "insert into department_info (id, company_id, ",
        "department_name, parent_id, ",
        "parent_id_list, status, ",
        "create_user, update_user, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{companyId,jdbcType=INTEGER}, ",
        "#{departmentName,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
        "#{parentIdList,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{createUser,jdbcType=INTEGER}, #{updateUser,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Department record);

    @InsertProvider(type=DepartmentSqlProvider.class, method="insertSelective")
    int insertSelective(Department record);

    @Select({
        "select",
        "id, company_id, department_name, parent_id, parent_id_list, status, create_user, ",
        "update_user, create_time, update_time",
        "from department_info",
        "where id = #{id,jdbcType=INTEGER}",
          "and company_id = #{companyId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id_list", property="parentIdList", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.INTEGER),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Department selectByPrimaryKey(DepartmentKey key);

    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update department_info",
        "set department_name = #{departmentName,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "parent_id_list = #{parentIdList,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=INTEGER},",
          "update_user = #{updateUser,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}",
          "and company_id = #{companyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department record);
}