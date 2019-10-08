package com.boc.webapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Repository
{
  private final List<User> m_aUsers;

  private Repository()
  {
    this.m_aUsers = new LinkedList<>();
    this.m_aUsers.add(new User("John", Collections.emptyList()));
    this.m_aUsers.add(new User("Harry", Arrays.asList("user", "admin")));
    this.m_aUsers.add(new User("Olivier", Arrays.asList("guest", "user")));
  }

  private static class Holder
  {
    private static final Repository INSTANCE = new Repository();
  }

  public static List<User> getUsers()
  {
    return Holder.INSTANCE.m_aUsers;
  }
}
