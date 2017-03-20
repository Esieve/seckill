package tech.acodesiger.service;

import tech.acodesiger.dto.Exposer;
import tech.acodesiger.dto.SeckillExecution;
import tech.acodesiger.entity.Seckill;
import tech.acodesiger.exception.RepeatKillException;
import tech.acodesiger.exception.SeckillCloseException;
import tech.acodesiger.exception.SeckillException;

import java.util.List;

/**
 * Created by zqy on 17-3-20.
 */
public interface SeckillService {

    List<Seckill> getSeckillList();

    Seckill getSeckillById(long seckillId);

    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException;
}
