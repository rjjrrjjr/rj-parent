package com.rj.service.impl;

import com.rj.domain.Role;
import com.rj.mapper.RoleMapper;
import com.rj.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rj
 * @since 2018-01-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
