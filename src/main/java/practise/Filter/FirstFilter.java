package practise.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project: SomethingAboutJava
 * Package: practise.Filter
 * Author: Alan Ruan
 * Date: 2019-03-30  16:28
 * Description: //TODO
 */
public class FirstFilter implements Filter {

    public FirstFilter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("故意造成一个异常");
        Object o = null;
        o.toString();

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;

        String ip = request.getRemoteAddr();
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = new Date();
        String date = simpleDateFormat.format(d);

        System.out.printf("%s %s 访问了 %s%n", date, ip, url);
        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}
