package ello.设计模式.代理模式.静态代理_多数据源;

/**
 * @author longchenggong
 * @description 动态切换数据源
 * @create 2020/3/27  17:09
 * @since 1.0.0
 */

public class DynamicDataSourceEntry {

//默认数据源
    public final static String DEFAULT_SOURCE=null;
    private final static ThreadLocal<String> local=new ThreadLocal <String>();

    private DynamicDataSourceEntry() { }

    //清空数据源
    public static void clear(){
        local.remove();
    }
    //正在使用的数据源
    static String get(){
        return local.get();
    }
    //还原当前切换的数据源
    static void restore(){
        local.set(DEFAULT_SOURCE);
    }
    //设置已知名称的数据源
    static void set(String source){
        local.set(source);
    }
    //根据年份动态设置数据源
    static void set(int year){
        local.set("DB_"+year);
    }
}
