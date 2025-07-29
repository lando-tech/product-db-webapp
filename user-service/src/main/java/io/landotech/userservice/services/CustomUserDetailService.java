package io.landotech.userservice.services;

import io.landotech.userservice.domains.UserPrincipalDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionalUser = userService.findByUserName(username);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            return new UserPrincipalDetails(user);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
