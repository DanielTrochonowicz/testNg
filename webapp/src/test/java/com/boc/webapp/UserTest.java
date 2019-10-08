package com.boc.webapp;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class UserTest
{
  private User m_aUser;

  @BeforeTest
  void setUp() throws Exception
  {
    this.m_aUser = new User("Amy", Arrays.asList("guest", "user"));
  }

  @Test
  void testUser()
  {
    Assert.assertNotNull(this.m_aUser, "User must not be null");
  }

  @Test
  void testGetName()
  {
    Assert.assertEquals(this.m_aUser.getName(), "Amy", "wrong name");
  }

  @Test
  void testGetRoles()
  {
    Assert.assertNotNull(this.m_aUser.getRoles(), "roles must be not null");
    Assert.assertEquals(this.m_aUser.getRoles().size(), 2,
        "Wrong number of elements");
    Assert.assertTrue(this.m_aUser.getRoles().contains("guest"),
        "Expected 'guest' role missing");
    Assert.assertTrue(this.m_aUser.getRoles().contains("user"),
        "Expected 'user' role missing");

    // check if is immutable
    this.m_aUser.getRoles().add("new");
    Assert.assertEquals(this.m_aUser.getRoles().size(), 2,
        "Wrong number of elements");
    Assert.assertTrue(this.m_aUser.getRoles().contains("guest"),
        "Expected 'guest' role missing");
    Assert.assertTrue(this.m_aUser.getRoles().contains("user"),
        "Expected 'user' role missing");
    Assert.assertFalse(this.m_aUser.getRoles().contains("new"),
        "'new' role should be not present");
  }

  @Test
  void testGetID()
  {
    Assert.assertNotNull(this.m_aUser.getID(), "ID must be not null");
  }

  @Test
  void testUniqueID()
  {
    // create new user with same data
    final User aUser = new User("Amy", Arrays.asList("guest", "user"));
    Assert.assertNotEquals(this.m_aUser.getID(), aUser.getID(),
        "ID must be different");
  }

}
