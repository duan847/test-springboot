package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.common.Query;
import com.example.demo.pojo.entity.Teacher;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author duanjw
 * @since 2019-06-04
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 分页查询
     *
     * @param query 分页对象
     * @return 分页对象
     */
    Page<Teacher> selectPage(Query<Teacher> query);


    /**
     *撒发生地方
     * @param teacher
     */
    Teacher updateAndGet(Teacher teacher);

}
