package com.nocoder.community.controller.interceptor;

import com.nocoder.community.entity.User;
import com.nocoder.community.service.DataService;
import com.nocoder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataInterceptor implements HandlerInterceptor {
    @Autowired
    private DataService dateService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统计UV
        String ip = request.getRemoteHost();
        dateService.recordUV(ip);

        // 统计DAU
        User user = hostHolder.getUser();
        if (user != null) {
            dateService.recordDAU(user.getId());
        }

        return true;
    }
}
