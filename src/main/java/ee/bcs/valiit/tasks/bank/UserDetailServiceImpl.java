package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private Bank3Repository bank3Repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = bank3Repository.findPassWordByUserName(username);
        return User.withUsername(username)
                .password(password)
                .roles("USER").build();
    }


}
