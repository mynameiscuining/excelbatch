package cn.njyazheng.mapper;

import cn.njyazheng.domain.GuestCard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GuestCardMapper {
    @Delete({
        "delete from R_GUESTCARD",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into R_GUESTCARD (id, department_id, ",
        "card_number, balance, ",
        "status, is_delete, ",
        "create_date)",
        "values (#{id,jdbcType=INTEGER}, #{departmentId,jdbcType=INTEGER}, ",
        "#{cardNumber,jdbcType=VARCHAR}, #{balance,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{isDelete,jdbcType=INTEGER}, ",
        "#{createDate,jdbcType=VARCHAR})"
    })
    int insert(GuestCard record);

    @InsertProvider(type=GuestCardSqlProvider.class, method="insertSelective")
    int insertSelective(GuestCard record);

    @Select({
        "select",
        "id, department_id, card_number, balance, status, is_delete, create_date",
        "from R_GUESTCARD",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="card_number", property="cardNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.VARCHAR)
    })
    GuestCard selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GuestCardSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GuestCard record);

    @Update({
        "update R_GUESTCARD",
        "set department_id = #{departmentId,jdbcType=INTEGER},",
          "card_number = #{cardNumber,jdbcType=VARCHAR},",
          "balance = #{balance,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "is_delete = #{isDelete,jdbcType=INTEGER},",
          "create_date = #{createDate,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GuestCard record);
}