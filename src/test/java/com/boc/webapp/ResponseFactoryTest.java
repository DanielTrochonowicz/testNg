package com.boc.webapp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

class ResponseFactoryTest
{

  @Test
  void testCollectAllRolesEmptyList()
  {
    final Collection<String> aAllRoles = ResponseFactory
        .collectAllRoles(Collections.emptyList());
    Assert.assertNotNull(aAllRoles, "Roles must be not null");
    Assert.assertTrue(aAllRoles.isEmpty(), "Roles must be an empty collection");
  }

  @Test
  void testCollectAllRolesSingleUserNoRoles()
  {
    final Collection<String> aAllRoles = ResponseFactory
        .collectAllRoles(Arrays.asList(new User("Amy", Collections.emptyList())));
    Assert.assertNotNull(aAllRoles, "Roles must be not null");
    Assert.assertTrue(aAllRoles.isEmpty(), "Roles must be an empty collection");
  }

  @Test
  void testCollectAllRolesSingleUserSingleRole()
  {
    final Collection<String> aAllRoles = ResponseFactory
        .collectAllRoles(Arrays.asList(new User("Amy", Arrays.asList("guest"))));
    Assert.assertNotNull(aAllRoles, "Roles must be not null");
    Assert.assertEquals(aAllRoles.size(), 1, "Roles must contain one element");
    Assert.assertTrue(aAllRoles.contains("guest"),"Roles must contain 'guest' role");
  }
}
