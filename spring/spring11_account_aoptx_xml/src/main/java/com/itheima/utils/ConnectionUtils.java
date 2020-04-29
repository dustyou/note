package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/*
* 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
* */
public class ConnectionUtils {
    private DataSource dataSource;
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    /*
    * 获取当前线程上的连接
    * @return
    * */
    public Connection getThreadConnection() {
        try {
        //1. 先从TreadLocal上获取
        Connection conn = tl.get();
        //2. 判断当前线程上是否有连接
        if(conn==null) {
            //3. 从数据源中获取一个连接，并存入ThreadLocal中

                conn = dataSource.getConnection();
                tl.set(conn);
            }
            // 4. 返回当前线程上的连接
            return conn;//这一句应该放在哪，和视频里不一样，仔细核对
        } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        
        
    }
    
    /*
    * 把连接和线程解绑
    * */
    public void removeConnection() {
        tl.remove();
    }
}
