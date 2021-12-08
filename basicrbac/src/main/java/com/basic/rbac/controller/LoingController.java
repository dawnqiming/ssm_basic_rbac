package com.basic.rbac.controller;

import com.basic.rbac.entity.AJAXResult;
import com.basic.rbac.entity.Permission;
import com.basic.rbac.entity.User;
import com.basic.rbac.service.PermissionService;
import com.basic.rbac.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Description
 * @Author T480
 * @Version
 * @Date 2021/11/16
 */
@Controller
public class LoingController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session) {
        AJAXResult result = new AJAXResult();

        //获取登陆用户信息
        User dbUser = userService.queryLoginUser(user);
        if ( dbUser != null ) {
            session.setAttribute("loginUser", dbUser);
            // 获取用户权限信息
            List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
            Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
            Permission root = null;
            Set<String> uriSet = new HashSet<String>();
            for ( Permission permission : permissions ) {
                permissionMap.put(permission.getId(), permission);
                if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
                    uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
                }
            }
            session.setAttribute("authUriSet", uriSet);
            for ( Permission permission : permissions ) {
                Permission child = permission;
                if ( child.getPid() == 0 ) {
                    root = permission;
                } else {
                    Permission parent = permissionMap.get(child.getPid());
                    parent.getChildren().add(child);
                }
            }
            session.setAttribute("rootPermission", root);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 执行登陆
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin( User user, Model model ) throws Exception {

        String loginacct = user.getLoginacct();

        // 将乱码字符串按照错误的编码方式转换为原始的字节码序列
        //byte[] bs = loginacct.getBytes("ISO8859-1");

        // 将原始的字节码序列按照正确的编码转换为正确的文字即可。
        //loginacct = new String(bs, "UTF-8");

        // 1) 获取表单数据
        // 1-1) HttpServletRequest
        // 1-2) 在方法参数列表中增加表单对应的参数，名称相同
        // 1-3) 就是将表单数据封装为实体类对象

        // 2) 查询用户信息
        User dbUser = userService.queryLoginUser(user);
        // 3) 判断用户信息是否存在
        if ( dbUser != null ) {
            // 登陆成功，跳转到主页面
            return "main";
        } else {
            // 登陆失败，跳转回到登陆页面，提示错误信息
            String errorMsg = "登陆账号或密码不正确，请重新输入";
            model.addAttribute("errorMsg", errorMsg);
            return "redirect:login";
        }


    }
}