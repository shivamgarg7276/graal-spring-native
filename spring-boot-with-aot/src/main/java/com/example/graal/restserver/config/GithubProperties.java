package com.example.graal.restserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@ConfigurationProperties("github")
@Validated
public class GithubProperties {

  /**
   * Github API token ("user:token")
   */
  @Pattern(regexp = "\\w+:\\w+")
  private String token;

  public String getToken() {
    return token;
  }
}
