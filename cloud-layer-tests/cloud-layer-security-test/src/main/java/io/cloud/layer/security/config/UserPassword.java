package io.cloud.layer.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 可以自己实现，也可以直接使用默认实现直接@bean到IOC容器中
 * @author RippleChan
 * @date 2019-03-01 02:03
 */
public class UserPassword implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }

}
