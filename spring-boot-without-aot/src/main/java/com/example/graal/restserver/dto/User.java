package com.example.graal.restserver.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

  private final String login;
  private final String avatarUrl;
  private final String name;
  private final String company;
  private final String blogUrl;
  private final Integer numPublicRepos;
  private final Integer numContributions;
  private final String htmlUrl;

  @JsonCreator
  public User(@JsonProperty("login") String login,
              @JsonProperty("avatar_url") String avatarUrl,
              @JsonProperty("name") String name,
              @JsonProperty("company") String company,
              @JsonProperty("blog") String blogUrl,
              @JsonProperty("public_repos") Integer numPublicRepos,
              @JsonProperty("contributions") Integer numContributions,
              @JsonProperty("html_url") String htmlUrl) {
    this.login = login;
    this.avatarUrl = avatarUrl;
    this.name = name;
    this.company = company;
    this.blogUrl = blogUrl;
    this.numPublicRepos = numPublicRepos;
    this.numContributions = numContributions;
    this.htmlUrl = htmlUrl;
  }

  public String getLogin() {
    return login;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public String getName() {
    return name;
  }

  public String getCompany() {
    return company;
  }

  public String getBlogUrl() {
    return blogUrl;
  }

  public Integer getNumPublicRepos() {
    return numPublicRepos;
  }

  public Integer getNumContributions() {
    return numContributions;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }
}
