package JUC.threalLocla_Test;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/14  14:27
 * @since 1.0.0
 */

public class ThreadLocalSingleton {
    private ThreadLocalSingleton() { }
    public static ThreadLocalSingleton getInstance(){
        return THREAD_LOCAL_INSTANCE.get();
    }

    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL_INSTANCE=new ThreadLocal <ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

    }
}
