package com.boc.webapp;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Immutable class representing user
 *
 * @author Krzysztof Zaremba
 *
 */
public class User
{
  private final UUID m_aID;
  private final String m_sName;
  private final List<String> m_aRoles;

  public User(final String sName, final List<String> aRoles)
  {
    this.m_aID = UUID.randomUUID();
    this.m_sName = sName;
    this.m_aRoles = new LinkedList<>(aRoles);
  }

  /**
   * @return the name
   */
  public final String getName()
  {
    return this.m_sName;
  }

  /**
   * @return the roles
   */
  public final Collection<String> getRoles()
  {
    return new LinkedList<>(this.m_aRoles);
  }

  /**
   * @return the ID
   */
  public final UUID getID()
  {
    return this.m_aID;
  }

}
