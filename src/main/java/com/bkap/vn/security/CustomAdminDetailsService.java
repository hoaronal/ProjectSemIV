package com.bkap.vn.security;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.AdminRole;
import com.bkap.vn.common.entity.HistoryAction;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.admin.service.AdminService;
import com.bkap.vn.manager.adminRole.service.AdminRoleService;
import com.bkap.vn.manager.history_action.service.HistoryActionService;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service("customAdminDetailsService")
public class CustomAdminDetailsService implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(CustomAdminDetailsService.class);

    @Autowired
    HistoryActionService historyActionService;
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String account)
            throws UsernameNotFoundException {
        Admin admin = adminService.getByAcount(account);
        logger.info("admin : {}", admin);
        if (admin == null) {
            HistoryAction historyAction = new HistoryAction();
            historyAction.setClientInfo(BaseController.getClientIp(null));
            historyAction.setAccessType("LOGIN");
            historyAction.setExecuteDate(new Date());
            historyAction.setAdmin(admin);
            historyAction.setDescription("Đăng nhập thất bại");
            historyActionService.add(historyAction);
            logger.info("admin not found");
            throw new UsernameNotFoundException("Account not found");
        }
        return new org.springframework.security.core.userdetails.User(admin.getAccount(), admin.getPassword(),
                true, true, true, true, getGrantedAuthorities(admin));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Admin admin) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<AdminRole> adminRoles = adminRoleService.getByAdminId(admin);
        List<Role> listRole = new ArrayList<>();
        for (int i = 0; i < adminRoles.size(); i++) {
            listRole.add(adminRoles.get(i).getRole());
        }
        Set<Role> roles = new HashSet<Role>(listRole);
        //Set<Role> role1 = ImmutableSet.copyOf(adminRoleService.getByAdminId(admin));
        for (Role role : roles) {
            logger.info("Role : {}", role);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
        }

        HistoryAction historyAction = new HistoryAction();
        historyAction.setClientInfo(BaseController.getClientIp(null));
        historyAction.setAccessType("LOGIN");
        historyAction.setExecuteDate(new Date());
        historyAction.setDescription("Đăng nhập thành công");
        historyAction.setAdmin(admin);
        historyActionService.add(historyAction);
        logger.info("authorities : {}", authorities);
        return authorities;
    }

}
