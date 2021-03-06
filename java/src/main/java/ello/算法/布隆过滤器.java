package ello.算法;

import java.util.BitSet;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/15  10:27
 * @since 1.0.0
 */

public class 布隆过滤器 {
    //位数组大小
    private static final int DEFAULT_SIZE=2<<24;

    //通过数组创建不同的hash函数
    private static final int[] SEEDS=new int[]{3,13,46,91,134};

    //位数组。元素只能是0或1
    private BitSet bits=new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func=new SimpleHash[SEEDS.length];

    //静态内部类。用于hash操作
    public static class SimpleHash{
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }
        //计算hash值
        public int hash(Object value){
            int h;
            return (value==null)?0:Math.abs(seed*(cap-1)&((h=value.hashCode())^(h>>>16)));
        };
    }

    //初始化多个包含 hash 函数的类的数组，每个类中的 hash 函数都不一样
    public 布隆过滤器() {
        //初始化多个不同的 hash 函数
        for (int i = 0; i <SEEDS.length ; i++) {
            func[i]=new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }

    //添加元素到位数组
    public void add(Object value){
        for (SimpleHash f : func) {
            bits.set(f.hash(value),true);
        }
    }

    //判断指定元素是否存在于位数组
    public boolean contains(Object value){
        boolean ret=true;
        for (SimpleHash f : func) {
            ret=ret&&bits.get(f.hash(value));
        }
        return ret;
    }


    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";

        布隆过滤器 filter = new 布隆过滤器();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        System.out.println(2<<24);
    }
}
