package com.boc.webapp;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

  @Test
  public void testUserCount() {
    Assert.assertEquals(Repository.usersCount(), 5);
    Assert.assertNotNull(Repository.usersCount(), "usersCount must be not null");
  }


  @Test
  public void testDate() {
    LocalTime timestamp = LocalTime.now();
    long time = timestamp.getNano();
    Assert.assertNotEquals(Repository.date(), time, "Date must be not Equals");
//    Assert.assertEquals(Repository.date(), time);
    Assert.assertNotNull(Repository.date(), "Date must be not null");
  }
}
