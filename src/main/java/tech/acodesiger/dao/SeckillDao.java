package tech.acodesiger.dao;

import org.apache.ibatis.annotations.Param;
import tech.acodesiger.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by 77239 on 2017/3/18/0018.
 */
public interface SeckillDao {
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    Seckill queryById(long seckillId);

    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
