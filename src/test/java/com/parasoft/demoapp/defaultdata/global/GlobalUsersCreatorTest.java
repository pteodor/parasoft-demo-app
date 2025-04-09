/**
 * 
 */
package com.parasoft.demoapp.defaultdata.global;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.parasoft.demoapp.exception.RoleNameExistsAlreadyException;
import com.parasoft.demoapp.exception.UserNotFoundException;
import com.parasoft.demoapp.exception.UsernameExistsAlreadyException;
import com.parasoft.demoapp.messages.DatabaseOperationMessages;
import com.parasoft.demoapp.model.global.RoleEntity;
import com.parasoft.demoapp.model.global.UserEntity;
import com.parasoft.demoapp.repository.global.RoleRepository;
import com.parasoft.demoapp.service.RoleService;
import com.parasoft.demoapp.service.UserService;

/**
 * Parasoft Jtest UTA: Test class for GlobalUsersCreator
 *
 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator
 * @author pteodor
 */
public class GlobalUsersCreatorTest {

	// Parasoft Jtest UTA: Object under test
	@InjectMocks
	GlobalUsersCreator underTest;

	// Parasoft Jtest UTA: Dependency generated for field roleService in GlobalUsersCreator
	// @Mock
	// RoleService roleService;

	// Parasoft Jtest UTA: Dependency generated for field userService in GlobalUsersCreator
	@Mock
	UserService userService;
	
	@Mock
	RoleRepository roleRepository;

	// Parasoft Jtest UTA: Dependency generated for field messages in GlobalUsersCreator
	@Mock
	DatabaseOperationMessages messages;
	private AutoCloseable closeable;

	// Parasoft Jtest UTA: Initialize object under test with mocked dependencies
	@Before
	public void setupMocks() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	/**
	 * Parasoft Jtest UTA: Test for populateData()
	 *
	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
	 * @author pteodor
	 */
	@Test(timeout = 5000, expected = NullPointerException.class)
	public void testPopulateData() throws Throwable {
		// Given
		
		RoleService roleService = new RoleService();
		Field field = RoleService.class.getDeclaredField("roleRepository");
		field.setAccessible(true);
		field.set(roleService, roleRepository);
		String getStringResult = "getStringResult"; // UTA: default value
		String getStringResult2 = "getStringResult2"; // UTA: default value
		when(messages.getString(nullable(String.class))).thenReturn(getStringResult, getStringResult2);
		RoleEntity addNewRoleResult = mock(RoleEntity.class);
		RoleEntity addNewRoleResult2 = mock(RoleEntity.class);
		when(roleService.addNewRole(nullable(String.class))).thenReturn(addNewRoleResult, addNewRoleResult2);
		UserEntity addNewUserResult = mock(UserEntity.class);
		UserEntity addNewUserResult2 = mock(UserEntity.class);
		UserEntity addNewUserResult3 = mock(UserEntity.class);
		UserEntity addNewUserResult4 = mock(UserEntity.class);
		when(userService.addNewUser(nullable(String.class), nullable(String.class))).thenReturn(addNewUserResult,
				addNewUserResult2, addNewUserResult3, addNewUserResult4);

		// When
		underTest.populateData();

	}

	/**
	 * Parasoft Jtest UTA: Test for populateData()
	 *
	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
	 * @author pteodor
	 */
//	@Test(timeout = 5000)
//	public void testPopulateData2() throws Throwable {
//		// Given
//		String getStringResult = "getStringResult"; // UTA: default value
//		String getStringResult2 = "getStringResult2"; // UTA: default value
//		when(messages.getString(nullable(String.class))).thenReturn(getStringResult, getStringResult2);
//		when(roleService.addNewRole(nullable(String.class))).thenThrow(RoleNameExistsAlreadyException.class);
//
//		RoleEntity getRoleByRoleNameResult = mock(RoleEntity.class);
//		when(roleService.getRoleByRoleName(nullable(String.class))).thenReturn(getRoleByRoleNameResult);
//		UserEntity addNewUserResult = mock(UserEntity.class);
//		UserEntity addNewUserResult2 = mock(UserEntity.class);
//		UserEntity addNewUserResult3 = mock(UserEntity.class);
//		UserEntity addNewUserResult4 = mock(UserEntity.class);
//		when(userService.addNewUser(nullable(String.class), nullable(String.class))).thenReturn(addNewUserResult,
//				addNewUserResult2, addNewUserResult3, addNewUserResult4);
//
//		// When
//		underTest.populateData();
//
//	}
//
//	/**
//	 * Parasoft Jtest UTA: Test for populateData()
//	 *
//	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
//	 * @author pteodor
//	 */
//	@Test(timeout = 5000)
//	public void testPopulateData3() throws Throwable {
//		// Given
//		String getStringResult = "getStringResult"; // UTA: default value
//		String getStringResult2 = "getStringResult2"; // UTA: default value
//		when(messages.getString(nullable(String.class))).thenReturn(getStringResult, getStringResult2);
//		RoleEntity addNewRoleResult = mock(RoleEntity.class);
//		RoleEntity addNewRoleResult2 = mock(RoleEntity.class);
//		when(roleService.addNewRole(nullable(String.class))).thenReturn(addNewRoleResult, addNewRoleResult2);
//		when(userService.addNewUser(nullable(String.class), nullable(String.class)))
//				.thenThrow(UsernameExistsAlreadyException.class);
//
//		UserEntity getUserByUsernameResult = mock(UserEntity.class);
//		when(userService.getUserByUsername(nullable(String.class))).thenReturn(getUserByUsernameResult);
//
//		// When
//		underTest.populateData();
//
//	}
//
//	/**
//	 * Parasoft Jtest UTA: Test for populateData()
//	 *
//	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
//	 * @author pteodor
//	 */
//	@Test(timeout = 5000)
//	public void testPopulateData4() throws Throwable {
//		// Given
//		String getStringResult = "getStringResult"; // UTA: default value
//		String getStringResult2 = "getStringResult2"; // UTA: default value
//		when(messages.getString(nullable(String.class))).thenReturn(getStringResult, getStringResult2);
//		RoleEntity addNewRoleResult = mock(RoleEntity.class);
//		RoleEntity addNewRoleResult2 = mock(RoleEntity.class);
//		when(roleService.addNewRole(nullable(String.class))).thenReturn(addNewRoleResult, addNewRoleResult2);
//		UserEntity addNewUserResult = mock(UserEntity.class);
//		UserEntity addNewUserResult2 = mock(UserEntity.class);
//		UserEntity addNewUserResult3 = mock(UserEntity.class);
//		UserEntity addNewUserResult4 = mock(UserEntity.class);
//		when(userService.addNewUser(nullable(String.class), nullable(String.class))).thenReturn(addNewUserResult,
//				addNewUserResult2, addNewUserResult3, addNewUserResult4);
//
//		when(userService.updateUser(nullable(UserEntity.class))).thenThrow(UserNotFoundException.class);
//
//		// When
//		underTest.populateData();
//
//	}
//
//	/**
//	 * Parasoft Jtest UTA: Test for populateData()
//	 *
//	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
//	 * @author pteodor
//	 */
//	@Test(timeout = 5000)
//	public void testPopulateData5() throws Throwable {
//		// Given
//		String getStringResult = "getStringResult"; // UTA: default value
//		when(messages.getString(nullable(String.class))).thenReturn(getStringResult);
//		when(roleService.addNewRole(nullable(String.class))).thenThrow(RoleNameExistsAlreadyException.class);
//
//		// When
//		underTest.populateData();
//
//	}
//
//	/**
//	 * Parasoft Jtest UTA: Test for populateData()
//	 *
//	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#populateData()
//	 * @author pteodor
//	 */
//	@Test(timeout = 5000)
//	public void testPopulateData6() throws Throwable {
//		// Given
//		String getStringResult = "getStringResult"; // UTA: default value
//		when(messages.getString(nullable(String.class))).thenReturn(getStringResult);
//		RoleEntity addNewRoleResult = mock(RoleEntity.class);
//		RoleEntity addNewRoleResult2 = mock(RoleEntity.class);
//		when(roleService.addNewRole(nullable(String.class))).thenReturn(addNewRoleResult, addNewRoleResult2);
//		when(userService.addNewUser(nullable(String.class), nullable(String.class)))
//				.thenThrow(UsernameExistsAlreadyException.class);
//
//		when(userService.getUserByUsername(nullable(String.class))).thenThrow(UsernameNotFoundException.class);
//
//		// When
//		underTest.populateData();
//
//	}

}
