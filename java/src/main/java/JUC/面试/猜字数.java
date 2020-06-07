package JUC.面试;

import java.util.*;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/17  17:01
 * @since 1.0.0
 */

public class 猜字数 {
    static Set<Integer> set=new HashSet <>();

    public static String getRandom(){
        // 随机数
        Random random = new Random();
        while (set.size() < 4) {
            int i=random.nextInt(10);
            set.add(i);
        }

        StringBuffer s= new StringBuffer();
        Iterator it = set.iterator();
        while (it.hasNext()) {
           s.append(String.valueOf(it.next()));
        }
        return s.toString();
    }

    static int a, b, c, d;
    static boolean[] isGetTrue=new boolean[5040];//是否命中

    static int nums[]=new int[5040*4];//一共有10*9*8*7 *4
    static {
        int one=0;
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                if (i == j)continue;
                for (int k = 0; k <10 ; k++) {
                    if (i == k||j==k)continue;
                    for (int l = 0; l <10 ; l++) {
                        if (i == l||j==l||k==l)continue;
                        nums[one++] = i;
                        nums[one++] = j;
                        nums[one++] = k;
                        nums[one++] = l;
                    }
                }
            }
        }
        Arrays.fill(isGetTrue,true);//都有可能
    }
    //输出为aAbB
    public static String resFlag(String inputStr,String randomNum){
        int A=0,B=0;
        for (int i=0;i<randomNum.length();i++) {
            if (inputStr.toCharArray()[i]==randomNum.toCharArray()[i])A++;
            else if (randomNum.contains(String.valueOf(inputStr.toCharArray()[i])))B++;
        }
        return new StringBuffer().append(A).append("A").append(B).append("B").toString();
    }
    //猜数字
    public static String getGussNun() {
        int others = 0;
        int pos = 0;

        for (int i = 0; i <5040 ; i++) {
            if (isGetTrue[i]){//为true即正好匹配到 others==1
                if (others>0){ others++;break;}
                else others++;pos=i;
            }
        }

        if (others == 1) {
            int i = pos * 4;
            //正好匹配上
            return new StringBuffer().append(nums[i++]).append(nums[i++]).append(nums[i++]).append(nums[i++]).toString();
        }

        for (int i = 0; i < 5040; i++) {//从0开始遍历返回第一个为true的并保存
            if (isGetTrue[i]){
                i = i * 4;
                a = nums[i];
                b = nums[i + 1];
                c = nums[i + 2];
                d = nums[i + 3];
                return new StringBuffer().append(nums[i++]).append(nums[i++]).append(nums[i++]).append(nums[i++]).toString();
            }
        }
        return null;
    };

    //返回(xAxB)
    public static void setGuessReuslt(int x, int y) {
        if (x == 4) {//4A0B
            return;
        }
        for (int pos = 0; pos < 5040; pos++) {//标记false即排查
            if (!isGetTrue[pos])continue;//标记false即排查
            if (getMyX(pos) != x) {//遍历所有元素数否匹配到x个a
                isGetTrue[pos] = false;//未匹配到的所有标记为false
                continue;
            }
            if (getMyY(pos) != y) {//遍历所有元素数否匹配到y个b
                isGetTrue[pos] = false;//未匹配到的所有标记为false
                continue;
            }
        }
    }
    //测试，把每个可能值都与上次猜测值比较，就会得到这个可能值与猜测值是几个a的关系
    private static int getMyX(int pos) {
        int myx = 0;
        pos =pos * 4;
        if (nums[pos++] == a)
            myx++;
        if (nums[pos++] == b)
            myx++;
        if (nums[pos++] == c)
            myx++;
        if (nums[pos++] == d)
            myx++;
        return myx;
    }
    //测试，把每个可能值都与上次猜测值比较，就会得到这个可能值与猜测值是几个b的关系
    private static int getMyY(int pos) {
        int myy = 0;
        pos =pos * 4;
        if (nums[pos] == b || nums[pos] == c || nums[pos] == d)//不会存在重复数字
            myy++;
        if (nums[pos + 1] == a || nums[pos + 1] == c || nums[pos + 1] == d)
            myy++;
        if (nums[pos + 2] == a || nums[pos + 2] == b || nums[pos + 2] == d)
            myy++;
        if (nums[pos + 3] == a || nums[pos + 3] == b || nums[pos + 3] == c)
            myy++;
        return myy;
    }
    public static void main(String[] args) {
        System.out.println("产生一个随机无重复4位数字："+getRandom());
        int i=1;
        while (true){
            String check=resFlag(getGussNun(),getRandom());
            System.out.println("第" + i++ + "次猜， 这个数是" + getGussNun() +" 回应："+check);
            setGuessReuslt(Integer.valueOf(check.substring(0,1)), Integer.valueOf(check.substring(2,3)));
            if (Integer.valueOf(check.substring(0,1)) == 4) {
                System.out.println("----------END--------");
                System.exit(0);
            }
            //System.exit(0);

        }


    }
}
