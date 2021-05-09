package com.example.graal.restserver.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RateLimitHeaderInterceptor implements ClientHttpRequestInterceptor {

  Logger log = LoggerFactory.getLogger(RateLimitHeaderInterceptor.class);

  @Override
  public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                      ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
    ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
    final String remainingRateLimit = response.getHeaders().getFirst("X-RateLimit-Remaining");
    assert remainingRateLimit != null;
    if (Integer.parseInt(remainingRateLimit) > 0) {
      log.info("Remaining Rate Limit: - {}", remainingRateLimit);
    }
    else {
      log.warn("API Rate limit has exceeded");
    }
    return response;
  }
}
