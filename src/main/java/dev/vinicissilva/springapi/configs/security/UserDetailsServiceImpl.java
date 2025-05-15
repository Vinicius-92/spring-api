package dev.vinicissilva.springapi.configs.security;

import dev.vinicissilva.springapi.entities.User;
import dev.vinicissilva.springapi.exceptions.UserNotFoundException;
import dev.vinicissilva.springapi.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UsersRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);
    return new UserDetailsImpl(user);
  }
}
