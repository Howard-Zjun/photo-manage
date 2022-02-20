package pers.howard.personalspace.service;

public interface RedisService {

    /**
     * 获取token
     * @param userId
     * @return
     */
    String getTokenItem(String userId);

    /**
     * 存放token
     * @param userId
     * @param token
     */
    void setTokenItem(String userId, String token);
}
