package tech.acodesiger.dao;

import org.apache.ibatis.annotations.Param;
import tech.acodesiger.entity.SuccessKilled;

/**
 * Created by 77239 on 2017/3/18/0018.
 */
public interface SuccessKilledDao {
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
