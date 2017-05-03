package com.sharp.redis.service.impl;

import com.sharp.redis.domain.User;
import com.sharp.redis.service.IUserOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by 584003 on 2017/5/2.
 */
@Service
public class UserOperationsServiceImpl implements IUserOperationsService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void add(User user) {
        // TODO Auto-generated method stub
         /*
          * boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
          * public Boolean doInRedis(RedisConnection redisConnection) throws
          * DataAccessException { RedisSerializer<String> redisSerializer =
          * redisTemplate .getStringSerializer(); byte[] key =
          * redisSerializer.serialize(user.getId()); byte[] value =
          * redisSerializer.serialize(user.getName()); return
          * redisConnection.setNX(key, value); } }); return result;
          */
        ValueOperations<String, User> valueops = redisTemplate.opsForValue();
        valueops.set(user.getId(), user);
    }

    @Override
    public User getUser(String key) {
        ValueOperations<String, User> valueops = redisTemplate
                .opsForValue();
        User user = valueops.get(key);
        return user;
    }

    @Override
    public void removeUser(String id) {
        redisTemplate.delete(id);
    }

    @Override
    public void updateUser(User user) {
    }

    @Override
    public User queryUser(String id) {
        return (User)redisTemplate.opsForValue().get(id);
    }
}