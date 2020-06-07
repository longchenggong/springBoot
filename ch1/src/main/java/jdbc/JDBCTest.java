package jdbc;

import java.io.IOException;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @create 2020/6/6  11:29 author：longchenggong
 */

public class JDBCTest {

    public static void main(String[] args) throws IOException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        Date date = new Date();




        System.out.println(resourceBundle.getString("aaa"));
    }
}
