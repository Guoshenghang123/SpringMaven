package com.guosh.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by guosh on 2018/6/8.
 */
@Repository
public interface CommonDao {
    List<Map<String, Object>> T_SYS_STAFF(Map<String, Object> params);

    List<Map<String, Object>> T_SYS_STAFF_ROLE(Map<String, Object> params);

    List<Map<String, Object>> T_SYS_ROLE(Map<String, Object> params);

    List<Map<String, Object>> T_SYS_ROLE_RIGHT(Map<String, Object> params);

    List<Map<String, Object>> T_SYS_RIGHT(Map<String, Object> params);
}
