package com.jbos.infrastructure.websecurity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WebSecurityFilter
 * @author youfu.wang
 * @date 2019-10-28
 */
public class WebSecurityFilter implements Filter {
    private FilterConfig filterConfig;
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    private String loginUrl;
    private String[] excludeUrlPatterns;
    private WebSecurityManager webSecurityManager;

    public void setWebSecurityManager(WebSecurityManager webSecurityManager){
        this.webSecurityManager=webSecurityManager;
    }
    //Filter initialize
    public void init(FilterConfig config) throws ServletException {
        try{
            this.filterConfig=config;
            if(this.filterConfig!=null){
                this.loginUrl=this.filterConfig.getInitParameter("loginUrl");
                this.excludeUrlPatterns=this.filterConfig.getInitParameter("excludeUrlPatterns").split(",");
            }
        }catch(Exception e){
            throw new ServletException("HttpRequestFilter init() Exception", e);
        }

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        webSecurityManager.setRequest(httpRequest);
        webSecurityManager.setResponse(httpResponse);
        String reqURI=null;
        String contextPath=null;
        try{
            reqURI=httpRequest.getRequestURI();
            if(reqURI==null){
                chain.doFilter(request, response);
                return;
            }else{
                contextPath=httpRequest.getContextPath();
                //如果请求是根URI,就直接跳过验证
                if(reqURI.equals(contextPath+"/")||reqURI.equals(contextPath)){
                    chain.doFilter(request, response);
                    return;
                }
                //如果请求的样式,图片和JS文件，直接跳过验证
                if(reqURI.equals(".ico")|reqURI.equals(".js")||reqURI.equals(".css")||reqURI.equals(".jpg")
                    ||reqURI.equals(".jpeg")||reqURI.equals("png")||reqURI.equals("gif")){
                    chain.doFilter(request, response);
                    return;
                }
                //如果请求的是无需验证的文件，直接跳过验证
                if(this.isExcludeUrlPatterns(contextPath,reqURI)){
                    chain.doFilter(request, response);
                    return;
                }
                //验证请求URI的有效性
                if(webSecurityManager.getSessionManager().isSessionTimeout()){
                    httpResponse.sendRedirect(contextPath+loginUrl);
                    return;
                }
                chain.doFilter(request, response);
                return;
            }
        }catch(Exception e){
            try {
                e.printStackTrace();
                httpResponse.setContentType(CONTENT_TYPE);
                PrintWriter pw = httpResponse.getWriter();
                pw.println("Server internal exception:" + e.getMessage());
                pw.println("<a href=\"javascript:window.history.back()\">[go back]</a>");
                pw.close();
                return;
            } catch (Exception ex1) {
                filterConfig.getServletContext().log(ex1.getMessage());
            }
        }
    }
    //Destroy filter
    public void destroy() {
        filterConfig=null;
        loginUrl=null;
        excludeUrlPatterns=null;
        webSecurityManager=null;
    }
    private boolean isExcludeUrlPatterns(String contextPath,String reqURI){
        boolean bool=false;
        if(null==this.excludeUrlPatterns){
            return bool;
        }
        for(String urlPattern:this.excludeUrlPatterns){
            urlPattern=contextPath+urlPattern.toLowerCase();
            if(reqURI.toLowerCase().matches(urlPattern.replace("*",".*"))){
                bool=true;
                break;
            }
        }
        return bool;
    }
}
