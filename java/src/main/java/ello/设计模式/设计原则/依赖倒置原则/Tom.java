package ello.设计模式.设计原则.依赖倒置原则;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/27  16:09
 * @since 1.0.0
 */

public class Tom {

    public void study(ICourse course){
        course.study();
    }


//构造器方式注入：
//    private ICourse course;
//
//    public Tom(ICourse course) {
//        this.course = course;
//    }
//    public void study(){
//        course.study();
//    }



    public static void main(String[] args) {
        Tom t=new Tom();
        t.study(new JavaCourse());
        t.study(new PythonCourse());
    }
}
