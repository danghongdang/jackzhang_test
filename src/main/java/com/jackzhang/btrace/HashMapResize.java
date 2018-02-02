//package com.jackzhang.btrace;
//
//import com.sun.btrace.annotations.*;
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class HashMapResize {
//
//    @OnMethod(
//            clazz="com.jackzhang.TreadMain",
//            method="newRun",
//            location = @Location(Kind.RETURN)
//    )
//    public static void func(String param, @Return String result) {
//        // println is defined in BTraceUtils
//        // you can only call the static methods of BTraceUtils
//        println("hashmap resize");
//        println("param value " + param);
//        println("result " + result);
//    }
//}
