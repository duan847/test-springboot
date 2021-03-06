package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Query;
import com.example.demo.pojo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author duanjw
 * @since 2019-06-04
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 新增
     * @param  teacher  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> save(@RequestBody Teacher teacher) {
        return R.ok(teacherService.save(teacher));
    }

    /**
     * 根据id查看
     *
     * @param id ID
     * @return Teacher
     */
    @GetMapping("/{id}")
    public R<Teacher> getById(@PathVariable Long id) {
        return R.ok(teacherService.getById(id));
    }

    /**
     * 分页查询
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        return teacherService.selectPage(new Query(params));
    }

    /**
     * 根据id删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> removeById(@PathVariable Long id) {
       return R.ok(teacherService.removeById(id));
    }

    /**
     * 根据id修改
     * @param  teacher  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> updateById(@RequestBody Teacher teacher) {
        return R.ok(teacherService.updateById(teacher));

    }

    @PostMapping("join")
    public R<Teacher> updateAndGet(@RequestBody Teacher teacher) {
        return R.ok(teacherService.updateAndGet(teacher));
    }


}
