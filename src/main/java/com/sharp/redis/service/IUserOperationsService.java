package com.sharp.redis.service;

import com.sharp.redis.domain.User;

/**
 * Created by 584003 on 2017/5/2.
 */
public interface IUserOperationsService {

    void add(User user);

    User getUser(String key);

    void removeUser(String id);

    void updateUser(User user);

    User queryUser(String id);
}
