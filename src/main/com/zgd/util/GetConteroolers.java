package main.com.zgd.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class GetConteroolers {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("of");
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static void Clear(){
        dataSource.close();
    }
}
