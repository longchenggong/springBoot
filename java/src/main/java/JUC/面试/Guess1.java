package JUC.面试;

import java.io.BufferedReader;

public class Guess1 {
    public static void main(String[] argv) throws Exception {
        GuessNum gn = new GuessNum();
        java.io.BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in, "GBK"));
        int i = 1;
        while (true) {
            String guessSeed = gn.getNextSeed();
            if (guessSeed.startsWith("我猜") || guessSeed.startsWith("你是")) {
                System.out.println(guessSeed);
                System.exit(0);
            }

            System.out.println();
            System.out.println("我第" + i++ + "次猜， 这个数是" + guessSeed);
            System.out.println("请你说位置及值都对的有几个?");
            String s = br.readLine();
            int a = Integer.parseInt(s);
            if (a == 4) {
                System.out.println("看，我猜对了吧，服不服，哈哈哈!!!");
                System.exit(0);
            }
            System.out.println("请你说值对但位置不对的有几个?");
            s = br.readLine();
            int b = Integer.parseInt(s);
            gn.setGuessReuslt(a, b);
        }
    }

}

class GuessNum {

    boolean[] isValid;  //是否有可能，为false时为不可能,true继续排除
    int[] nums;      //所有可能值，共5040 * 4长，每四个作一个可能值，上面的isValid记录这5040个可能性是否还有可能
    int a, b, c, d;  //上次猜测值，暂存

    public GuessNum() {
        isValid = new boolean[5040];
        java.util.Arrays.fill(isValid, true);  //刚开始时全有可能
        nums = new int[5040 * 4];
        int pos = 0;  //5040 * 4数组中的位置

//初始化，把所有可能值的a, b, c, d位全按四个一组放入nums中
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (a == b)
                    continue;
                for (int c = 0; c < 10; c++) {
                    if (a == c || b == c)continue;
                    for (int d = 0; d < 10; d++) {
                        if (a == d || b == d || c == d)
                            continue;
                        nums[pos++] = a;
                        nums[pos++] = b;
                        nums[pos++] = c;
                        nums[pos++] = d;
                    }
                }
            }
        }
    }


    /**
     * 得到下一个猜测目标，如果没有了可能性，证明操作者前面输入错误，如果可能性只有一，立即确定
     *
     * @return
     */
    public String getNextSeed() {
        int others = 0;
        int pos = 0;
        for (int i = 0; i < 5040; i++) {
            if (isValid[i]) {
                if (others > 0) {
                    others++;
                    break;
                } else {
                    others++;
                    pos = i;
                }
            }
        }

        if (others == 0) {
            return "你是个赖皮狗，前面你回答错了，查查吧" ;
        }

        if (others == 1) {
            int i = pos * 4;
            return "我猜这个数一定是" + nums[i++] + nums[i++] + nums[i++] + nums[i++];
        }


        for (int i = 0; i < 5040; i++) {
            if (isValid[i]) {
                i *= 4;
                a = nums[i];
                b = nums[i + 1];
                c = nums[i + 2];
                d = nums[i + 3];
                return new StringBuffer().append(nums[i++]).append(nums[i++]).append(nums[i++]).append(nums[i++]).toString();
            }
        }

//理论上不可能到这一步
        throw new java.lang.RuntimeException("你是个赖皮狗，前面你回答错了，查查吧");
    }

    //设置操作者的反馈(x 个 a, y 个 b)
    public void setGuessReuslt(int x, int y) {
        if (x == 4) {
            return;
        }
        for (int pos = 0; pos < 5040; pos++) {
            if (!isValid[pos])
                continue;
            int numspos = pos * 4;
            if (getMyX(pos) != x) {
                isValid[pos] = false;
                continue;
            }
            if (getMyY(pos) != y) {
                isValid[pos] = false;
                continue;
            }
        }
    }

    //测试，把每个可能值都与上次猜测值比较，就会得到这个可能值与猜测值是几个a的关系
    private int getMyX(int pos) {
        int myx = 0;
        pos *= 4;
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
    private int getMyY(int pos) {
        int myy = 0;
        pos *= 4;
        if (nums[pos] == b || nums[pos] == c || nums[pos] == d)
            myy++;
        if (nums[pos + 1] == a || nums[pos + 1] == c || nums[pos + 1] == d)
            myy++;
        if (nums[pos + 2] == a || nums[pos + 2] == b || nums[pos + 2] == d)
            myy++;
        if (nums[pos + 3] == a || nums[pos + 3] == b || nums[pos + 3] == c)
            myy++;
        return myy;
    }
}