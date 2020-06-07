package ello.集合.collections_Arrays;

import java.util.*;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/14  15:13
 * @since 1.0.0
 */

public class Collections_Test {
    public static void collections_常用方法(){


       // 排序操作
//        void shuffle(List list)//随机排序
//        void sort(List list)//按自然排序的升序排序
//        void sort(List list, Comparator c)//定制排序，由Comparator控制排序逻辑
//        void swap(List list, int i , int j)//交换两个索引位置的元素
//        void rotate(List list, int distance)//旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。

//查找,替换操作
//        int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序的
//        int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
//        int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
//        void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素。
//        int frequency(Collection c, Object o)//统计元素出现次数
//        int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
//        boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        HashSet<Integer> integers1 = new HashSet<>();
        integers1.add(1);
        integers1.add(3);
        integers1.add(2);
        Map scores = new HashMap();
        scores.put("语文" , 80);
        scores.put("Java" , 82);
//--------------------------------设置不可变集合:------------下面三类方法的参数是原有的集合对象，返回值是该集合的”只读“版本。
        //Collections.emptyXXX();创建一个空的、不可改变的XXX对象.既可以是List，也可以是Set，还可以是Map
        List<Object> list = Collections.emptyList();
        System.out.println(list);//[]

        //Collections.singletonXXX(); 返回一个只包含指定对象（只有一个或一个元素）的不可变的集合对象，此处的集合可以是：List，Set，Map。
        List<ArrayList<Integer>> arrayLists = Collections.singletonList(arrayList);
        System.out.println(arrayLists);//[[-1, 3, 3, -5]]

        //unmodifiableXXX();创建普通XXX对象对应的不可变版本
        List<Integer> integers = Collections.unmodifiableList(arrayList);
        System.out.println(integers);//[-1, 3, 3, -5]
        //---------上面三类方法的参数是原有的集合对象，返回值是该集合的”只读“版本。----
    }

    public static void Arrays_Test(){
//        排序 : sort()
//        查找 : binarySearch()
//        比较: equals()
//        填充 : fill()
//        转列表: asList()
//        转字符串 : toString()
//        复制: copyOf()

        String[] strs = { "abcdehg", "abcdefg", "abcdeag" };
        Arrays.sort(strs);//对每个字符串的特定位置进行比较，然后按照升序排序。
        System.out.println(Arrays.toString(strs));//[abcdeag, abcdefg, abcdehg]

        // *************查找 binarySearch()****************
        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        // 排序后再进行二分查找，否则找不到
        Arrays.sort(e);
        System.out.println("Arrays.sort(e)" + Arrays.toString(e));
        int s = Arrays.binarySearch(e, 'c');
        System.out.println("字符c在数组的位置：" + s);

        // *************比较 equals****************
        char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        char[] g = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        /*
         * 元素数量相同，并且相同位置的元素相同。 另外，如果两个数组引用都是null，则它们被认为是相等的 。
         */
        // 输出true
        System.out.println("Arrays.equals(e, f):" + Arrays.equals(f, g));


        // *************填充fill(批量初始化)****************
        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        // 数组中指定范围元素重新分配值
        Arrays.fill(h, 0, 2, 9);
        for (int i : h) {
            System.out.print(i);
        }

        // *************复制 copy****************
        // copyOf 方法实现数组复制,h为数组，6为复制的长度
        int[] i = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        int j[] = Arrays.copyOf(i, 6);
    }

    public static void main(String[] args) {
      //  collections_常用方法();
        Arrays_Test();
    }
}
