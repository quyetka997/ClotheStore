package com.nnstore.untils;

import com.nnstore.security.MyUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public static MyUser getPrincipal() {
        MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication();
        return myUser;
    }

    public static void setPrincipal(MyUser myUser) {
        (SecurityContextHolder.getContext()).setAuthentication((Authentication) myUser);
    }

    public static List<String> getAuthorizations() {
        List<String> result = new ArrayList<>();
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()).getAuthentication().getAuthorities();
        for (GrantedAuthority authority: grantedAuthorities) {
            result.add(authority.getAuthority());
        }
        return result;
    }

}
