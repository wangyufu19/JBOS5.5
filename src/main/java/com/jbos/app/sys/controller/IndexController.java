package com.jbos.app.sys.controller;
import com.jbos.app.sys.shiro.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * IndexController
 * @author youfu.wang
 * @date 2019-03-01
 */
@Controller
public class IndexController extends BaseController{
    /**
     * 得到主页面
     * @return
     */
    @RequestMapping("/index")
    public String main(HttpServletRequest request) {
        return "index";
    }
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        return "welcome";
    }
    @RequestMapping("/logout")
    public String logout() {
        ShiroUtils.getSubject().logout();
        return "login";
    }
}
