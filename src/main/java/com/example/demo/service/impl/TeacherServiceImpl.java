package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Query;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.pojo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author duanjw
 * @since 2019-06-04
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    public TeacherMapper teacherMapper;

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public Page<Teacher> selectPage(Query<Teacher> query) {
      return query.setRecords(teacherMapper.selectPage(query));
    }


    @Transactional
    @Override
    @Async
    public Teacher updateAndGet(Teacher teacher) {
        updateById(teacher);
        try {
            return getById(teacher.getId());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Teacher getById(Long id) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        Future<Teacher> teacherFuture = fixedThreadPool.submit(() -> {
                    Teacher byId = teacherMapper.getById(id);
                    return byId;
                });
        fixedThreadPool.shutdown();
        while (true) {
            if (fixedThreadPool.isTerminated()) {
                System.out.println(teacherFuture.get().getName());
                break;
            }
        }
        return null;
    }
}
