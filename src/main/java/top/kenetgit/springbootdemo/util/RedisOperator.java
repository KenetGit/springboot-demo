package top.kenetgit.springbootdemo.util;


import freemarker.cache.StringTemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisOperator {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*
    * 查询给定key的生存剩余时间
    * @param key
    * @return
    * */
    public long getTTL(String key) {
        return redisTemplate.getExpire(key);
    }

    /*
    * 设置所指定的key的生存剩余时间
    * @param key
    * @param timeout
    * @return
    * */
    public void setExpire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /*
    * 给定匹配模式，查询所有符合匹配的key
    * @param pattern
    * */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /*
    * 删除指定的key
    * */

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /*
    * ************字符串*******************
    * */


    /*
    * 设置一个key-value
    * @param key
    * @param value
    * */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /*
    * 设置一个key-value，同时指定超时时间（秒）
    * @param key
    * @param value
    * @param timeout
    * */
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key,value,timeout,TimeUnit.SECONDS);
    }

    /*
    * 指定key，返回关联的value字符串
    * @param key
    * @return
    * */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /*
    * ***************哈希表********************
    * */

    /*
    * 实现命令：HSET key field value，将哈希表中key中的field的值设置为value
    * @param key
    * @param field
    * @param value
    * */
    public void hashSet(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /*
    * 实现命令：HGET key field 返回哈希表key中给定的field的值
    * @param key
    * @param field
    * */

    public String hashGet(String key, String field) {
        return (String) redisTemplate.opsForHash().get(key,field);
    }


    /*
    * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略
    * @param key
    * @fields
    * */
    public void hashDelete(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key,fields);
    }

    /*
    * 实现命令：HGETALL key，返回哈希表中key中d所有域和值
    * @param key
    * @return
    * */
    public Map<Object, Object> hashGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /*
    * ********** List 列表 *****************8
    * */

    /*
    * 实现命令：LPUSH key value 将一个值value插入到列表key的表头
    * @param key
    * @pram value
    * @return 新的列表的长度
    * */
    public long listLeftPush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key,value);
    }

    /*
    * 实现命令：LPOP key，移除逼格返回列表的头元素
    * @param key
    * @return
    * */

    public String listLeftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /*
    * 实现命令：RPUSH key value,将一个值插入到列表Key的表尾（最右边）
    * @param key
    * @param value
    * @return 新的列表的长度
    * */

    public long listRightPush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key,value);
    }

}

