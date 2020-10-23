package com.hifix.securitydemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hifix.securitydemo1.entity.users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<users> {

}
