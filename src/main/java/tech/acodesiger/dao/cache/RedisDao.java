package tech.acodesiger.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.ProtostuffException;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import tech.acodesiger.entity.Seckill;

/**
 * Created by zqy on 17-3-22.
 */
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JedisPool jedisPool;
    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Seckill getSeckill(long seckillId) {
        Jedis jedis = jedisPool.getResource();
        String key = "seckill:" + seckillId;
        byte[] bytes = jedis.get(key.getBytes());
        if (bytes != null) {
            Seckill seckill = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
            return seckill;
        }
        jedis.close();
        return null;
    }

    public String putSeckill(Seckill seckill) {
        Jedis jedis = jedisPool.getResource();
        String key = "seckill:" + seckill.getSeckillId();
        byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        String result = jedis.setex(key.getBytes(), 60 * 60, bytes);
        jedis.close();
        return result;
    }
}
