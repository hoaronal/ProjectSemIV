package com.bkap.vn.converter;

import com.bkap.vn.common.entity.Role;
import com.bkap.vn.manager.role.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Object, Role> {

    static final Logger logger = LoggerFactory.getLogger(RoleConverter.class);

    @Autowired
    RoleService roleService;

    public Role convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Role profile= roleService.getById(id);
        logger.info("Profile : {}",profile);
        return profile;
    }

}