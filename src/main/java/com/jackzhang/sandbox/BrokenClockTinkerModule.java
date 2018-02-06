package com.jackzhang.sandbox;

import com.alibaba.jvm.sandbox.api.Information;
import com.alibaba.jvm.sandbox.api.Module;
import com.alibaba.jvm.sandbox.api.ProcessControlException;
import com.alibaba.jvm.sandbox.api.event.Event;
import com.alibaba.jvm.sandbox.api.filter.NameRegexFilter;
import com.alibaba.jvm.sandbox.api.http.Http;
import com.alibaba.jvm.sandbox.api.listener.EventListener;
import com.alibaba.jvm.sandbox.api.resource.ModuleEventWatcher;
import com.google.gson.Gson;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Information(id = "broken-clock-tinker")
public class BrokenClockTinkerModule implements Module {

    @Resource
    private ModuleEventWatcher moduleEventWatcher;

    @Http("/repairCheckState")
    public void repairCheckState() {

        moduleEventWatcher.watch(

            // 匹配到Clock$BrokenClock#checkState()
            new NameRegexFilter("com\\.jackzhang\\.sandbox\\.Clock\\$BrokenClock", "checkState"),

            // 监听THROWS事件并且改变原有方法抛出异常为正常返回
            new EventListener() {
                public void onEvent(Event event) throws Throwable {
                    // 立即返回
                    ProcessControlException.throwReturnImmediately(null);
                }
            },

            // 指定监听的事件为抛出异常
            Event.Type.THROWS
        );
    }

    private static Gson GSON = new Gson();

    @Http("/repairDelay")
    public void repairDelay(final HttpServletRequest req,
                            final HttpServletResponse resp) {

        final String classNamePattern = req.getParameter("class");
        if (classNamePattern != null && classNamePattern.length() != 0) {
            System.out.println(GSON.toJson(classNamePattern));
        }

        final String methodNamePattern = req.getParameter("method");
        if (methodNamePattern != null && methodNamePattern.length() != 0) {
            System.out.println(GSON.toJson(methodNamePattern));
        }

        final String watchExpress = req.getParameter("watch");
        if (watchExpress != null && watchExpress.length() != 0) {
            System.out.println(GSON.toJson(watchExpress));
        }

        moduleEventWatcher.watch(

                // 匹配到Clock$BrokenClock#checkState()
                new NameRegexFilter("com\\.jackzhang\\.sandbox\\.Clock\\$BrokenClock", "delay"),

                // 监听THROWS事件并且改变原有方法抛出异常为正常返回
                new EventListener() {

                    public void onEvent(Event event) throws Throwable {

                        System.out.println("沙箱修复延迟：：：：：：：：：：：：：：：：：：：：：：：" + event);
                        System.out.println("沙箱修复延迟：：：：：：：：：：：：：：：：：：：：：：：" + this);
                        // 在这里延时1s
                        Thread.sleep(1000L);

                        // 然后立即返回，因为监听的是BEFORE事件，所以此时立即返回，方法体将不会被执行
                        ProcessControlException.throwReturnImmediately(null);
                    }
                },

                // 指定监听的事件为方法执行前
                Event.Type.BEFORE

        );

    }
}
