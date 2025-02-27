package com.devsuperior.bds03.config;

import com.devsuperior.bds03.entities.User;
import com.devsuperior.bds03.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {
  @Autowired
  private UserRepository userRepository;

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
    User user = userRepository.findByEmail(oAuth2Authentication.getName());
    Map<String, Object> map = new HashMap<>();
    DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) oAuth2AccessToken;
    token.setAdditionalInformation(map);
    return token;
  }
}
