package com.fashion.secutity;

import com.fashion.model.Admin;
import com.fashion.model.security.Authority;
import com.fashion.repository.AdminRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoht
 * @date 2016/9/10 14:16
 */
@Service
@Transactional
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    private final static ImmutableList<SimpleGrantedAuthority> authorities = ImmutableList
            .of(new SimpleGrantedAuthority("ROLE_ADMIN"));


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsernameAndEnabled(username,true);

        if(admin == null){
            throw new UsernameNotFoundException(String.format(
                    "Admin %s does not exist!",username
            ));
        }

        Set<GrantedAuthority> set = new HashSet<>();
        admin.getRoles().forEach(r -> {
            set.addAll(r.getAuthorities());
        });
        return new AdminDetails(admin,set);
    }

    public final static class AdminDetails implements UserDetails{

        private final Set<GrantedAuthority> authorities;

        private Admin admin;

        public AdminDetails(Admin admin,Set<GrantedAuthority> set) {
            this.admin = admin;
            authorities = Collections.unmodifiableSet(set);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return admin.getPassword();
        }

        @Override
        public String getUsername() {
            return admin.getUsername();
        }

        public Integer getId(){
            return admin.getId();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
