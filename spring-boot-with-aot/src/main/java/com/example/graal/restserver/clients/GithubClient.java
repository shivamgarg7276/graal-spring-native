package com.example.graal.restserver.clients;

import com.example.graal.restserver.config.GithubProperties;
import com.example.graal.restserver.dto.User;
import com.example.graal.restserver.interceptors.GithubAppTokenInterceptor;
import com.example.graal.restserver.interceptors.RateLimitHeaderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class GithubClient {

  private final RestTemplate restTemplate;

  private static final String USERS_URL = "https://api.github.com/users/{userName}";
  private static final String CONTRIBUTORS_URL = "https://api.github.com/repos/{owner}/{repo}/contributors";

  @Autowired
  public GithubClient(RestTemplateBuilder restTemplateBuilder, GithubProperties githubProperties) {
    this.restTemplate =
        restTemplateBuilder.additionalInterceptors(new GithubAppTokenInterceptor(githubProperties.getToken()))
                           .additionalInterceptors(new RateLimitHeaderInterceptor())
                           .build();
    this.restTemplate.setErrorHandler(new NoOpResponseErrorHandler());
  }

  public ResponseEntity<User> fetchUser(String userName) {
    return this.restTemplate.getForEntity(USERS_URL, User.class, userName);
  }

  public ResponseEntity<User[]> fetchContributors(String orgName, String repoName) {
    return this.restTemplate.getForEntity(CONTRIBUTORS_URL, User[].class, orgName, repoName);
  }

  private static class NoOpResponseErrorHandler extends DefaultResponseErrorHandler {
    private NoOpResponseErrorHandler() {
      //Do nothing here yet
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
      //Do nothing here yet
    }
  }
}
