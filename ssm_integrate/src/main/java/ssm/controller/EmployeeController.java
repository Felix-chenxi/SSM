package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssm.mapper.EmployeeMapper;
import ssm.pojo.Employee;
import ssm.service.EmployeeService;

import java.util.List;

/**
 * @Author: Felix_ChuChen
 * @Data: 2022/7/21 18:02
 * @Description: "路漫漫其修远兮,吾将上下而求索"
 *
 * 查询所有员工信息-->/employee--->get
 * 根据员工id查询员工信息-->/employee/1--->get
 * 跳转到添加页面-->/to/add--->get
 * 添加员工信息-->/employee--->post
 * 修改员工信息-->employee--->put
 * 删除员工信息-->employee/1--->delete
 *
 */

/**
 * 使用注解标记 ioc容器  标注在java类上将其定义为Spring Bean
 * 这四个注解没有区别主要用于区分不同架构层之间便于区分
 * @Controller  该注解通常用于控制层
 * @Service  该注解通常用于Service层
 * @Repository  该注解通常用于数据访问层即Dao层
 * @Component  该注解通常用于除了三层架构外的类
 */
@Controller
public class EmployeeController {
    @Autowired    //自动装配
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list",list);
        //跳转到employee_list.html
        return "employee_list";

    }


}
