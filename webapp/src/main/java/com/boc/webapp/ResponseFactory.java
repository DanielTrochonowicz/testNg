package com.boc.webapp;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    return aResponse;
  }

  @Nonnull
  protected static Collection<String> collectAllRoles(final List<User> aUsers)
  {
    final Set<String> aRoles = new TreeSet<>();
    // for every user...
    for (int i = 0; i < aUsers.size(); i++)
    {
      final User aUser = aUsers.get(i);
      for (int j = aUsers.size() - 1; j >= 0; j--)
      {
        final User aOtherUser = aUsers.get(j);
        // ... check if his roles are already present in collection
        for (final String sNewRole : aUser.getRoles())
        {
          boolean bPresent = false;
          for (final String sRole : aRoles)
          {
            if (sRole.equals(sNewRole))
            {
              bPresent = true;
            }
          }
          // add missing role once for a user
          if (aUser.getID().equals(aOtherUser.getID()) && !bPresent)
          {
            aRoles.add(sNewRole);
          }
        }
      }
    }
    return aRoles;
  }
}
