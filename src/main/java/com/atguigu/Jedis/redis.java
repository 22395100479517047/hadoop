package com.atguigu.Jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class redis {
    @Test
    public void test(){
        //指定redis服务器的IP地址和端口号
        Jedis jedis = new Jedis("192.168.1.102", 6379);
        //执行ping命令
        String ping = jedis.ping();
        System.out.println(ping);
        //关闭连接
        jedis.close();
    }
    @Test
    public void test2(){
        //声明Linux服务器IP地址
        String host = "192.168.1.102";

        //声明Redis端口号
        int port = Protocol.DEFAULT_PORT;

        //创建连接池对象
        JedisPool jedisPool = new JedisPool(host, port);

        //获取Jedis对象连接Redis
        Jedis jedis = jedisPool.getResource();

        //执行具体操作
        String ping = jedis.ping();
        System.out.println(ping);

        //关闭连接
        jedisPool.close();
    }
}
