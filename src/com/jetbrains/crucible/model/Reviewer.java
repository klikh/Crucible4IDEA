package com.jetbrains.crucible.model;

import org.jetbrains.annotations.NotNull;

public class Reviewer extends User {

  public Reviewer(@NotNull final String userName) {
    super(userName);
  }

  @Override
  public String toString() {
    return "Reviewer [[" + myUserName + "]]";
  }
}