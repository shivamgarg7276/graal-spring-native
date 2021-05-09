package com.example.graal.restserver.controllers;

import com.example.graal.restserver.clients.GithubClient;
import com.example.graal.restserver.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {

  private final GithubClient githubClient;

  @Autowired
  public GithubController(GithubClient githubClient) {
    this.githubClient = githubClient;
  }

  @GetMapping("/users/{userName}")
  public ResponseEntity<User> getUser(@PathVariable String userName) {
    ResponseEntity<User> user = this.githubClient.fetchUser(userName);
    return ResponseEntity.ok(user.getBody());
  }

  @GetMapping("/contributors/{orgName}/{projectName}")
  public ResponseEntity<User[]> getProjectContributors(@PathVariable String orgName,
                                                       @PathVariable String projectName) {
    ResponseEntity<User[]> contributors = this.githubClient.fetchContributors(orgName, projectName);
    return ResponseEntity.ok(contributors.getBody());
  }
}