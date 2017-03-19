package tech.acodesiger.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesiger.entity.Seckill;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/3/19/0019.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        /**
         * SQL: UPDATE
         * seckill
         * SET
         * number = number-1;
         * WHERE seckill_id = ?
         * AND start_time   <=   ?
         * AND end_time >= ?
         * AND number > 0;
         ### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException:
         You have an error in your SQL syntax;
         check the manual that corresponds to your MySQL server version for the right syntax to use near
         'WHERE seckill_id = 1000
         AND start_time   <=   '2017-03-19 11:55:00.483'
         ' at line 5
         ; bad SQL grammar [];
         nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException:
         You have an error in your SQL syntax;
         check the manual that corresponds to your MySQL server version for the right syntax to use near
         'WHERE seckill_id = 1000
         AND start_time   <=   '2017-03-19 11:55:00.483'
         ' at line 5
         */
        Date killTime = new Date();
        int result = seckillDao.reduceNumber(1000L, killTime);
        System.out.println(result);
    }

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

}