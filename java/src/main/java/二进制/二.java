package 二进制;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/1/30  15:13
 * @since 1.0.0
 */

public class 二 {
    public static void 位移(){
        //左位移 << :乘与2  5<<2:5*2*2  int 4个字节：00000000 00000000 00000000 00000010  左移，高位丢弃低位补零 00000100 换上为4
        System.out.println(5<<2);
        //右位移：>>:除于2
        //无符号右移：>>>
    }

    public static void main(String[] args) {
        位移();
    }

}
