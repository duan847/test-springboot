package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.common.Query;
import com.example.demo.pojo.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author duanjw
 * @since 2019-06-04
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * 分页查询
     *
     * @param query 分页对象
     * @return List数组
     */
    List<Teacher> selectPage(Query query);

    Teacher getById(@Param("id") Long id);
}
