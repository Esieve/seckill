package tech.acodesiger.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesiger.dto.Exposer;
import tech.acodesiger.dto.SeckillExecution;
import tech.acodesiger.entity.Seckill;
import tech.acodesiger.exception.RepeatKillException;
import tech.acodesiger.exception.SeckillCloseException;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zqy on 17-3-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getSeckillById() throws Exception {
        Seckill seckill = seckillService.getSeckillById(1000L);
        logger.info("{}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000L);
        logger.info("{}", exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        try {
            SeckillExecution execution = seckillService.executeSeckill(1000L, 123L, null);
            logger.info("{}", execution);
        } catch (RepeatKillException e) {
            logger.error(e.getMessage());
        } catch (SeckillCloseException e) {
            logger.error(e.getMessage());
        }
    }

}