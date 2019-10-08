package com.boc.webapp;

import java.util.*;

import javax.annotation.Nonnull;

import com.phloc.json.IJSONObject;
import com.phloc.json.impl.JSONObject;

/**
 * Factory that creates JSON response from users
 *
 * @author Krzysztof Zaremba
 *
 */
public class ResponseFactory
{

  @Nonnull
  public static IJSONObject createResponse(final List<User> aUsers)
  {
    final IJSONObject aResponse = new JSONObject();
    aResponse.setStringListProperty("roles", collectAllRoles(aUsers));
//    aResponse.

    return aResponse;
  }

  @Nonnull
  protected static Collection<String> collectAllRoles(final List<User> aUsers) {
    final Set<String> aRoles = new TreeSet<>();

    for (final User aUser : aUsers) {
      for (final String sNewRole : aUser.getRoles()) {
        if (!aRoles.contains(sNewRole)) {
          aRoles.add(sNewRole);
        }
      }
    }return aRoles;
  }


  @Nonnull
  protected  static int  usersCount(final List<User> aUsers){
    return aUsers.size();
  }
}
