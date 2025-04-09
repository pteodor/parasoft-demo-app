/**
 * 
 */
package com.parasoft.demoapp.defaultdata.global;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import com.parasoft.demoapp.exception.RoleNameExistsAlreadyException;
import com.parasoft.demoapp.exception.RoleNotFoundException;
import com.parasoft.demoapp.model.global.RoleEntity;
import com.parasoft.demoapp.service.RoleService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	@Mock
	RoleService roleService;
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
	 * Parasoft Jtest UTA: Test for createRoleIfNotExists(String)
	 *
	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#createRoleIfNotExists(String)
	 * @author pteodor
	 */
	@Test(timeout = 5000)
	public void testCreateRoleIfNotExists() throws Throwable {
		// When
		String roleName = "roleName"; // UTA: default value
		RoleEntity result = callPrivateMethod(underTest, GlobalUsersCreator.class, "createRoleIfNotExists",
				new Class<?>[] { String.class }, new Object[] { roleName });

		// Then - assertions for result of method createRoleIfNotExists(String)
		assertNull(result);

	}

	/**
	 * Parasoft Jtest UTA: Helper method to invoke private method createRoleIfNotExists
	 */
	@SuppressWarnings("unchecked")
	private static <T> T callPrivateMethod(Object underTest, Class<?> functionClass, String methodName,
			Class<?>[] argumentTypes, Object[] args) {
		try {
			Method method = functionClass.getDeclaredMethod(methodName, argumentTypes);
			method.setAccessible(true);
			return (T) method.invoke(underTest, args);
		} catch (NoSuchMethodException e) {
			throw (AssertionError) new AssertionError("No such method found").initCause(e);
		} catch (IllegalAccessException e) {
			throw (AssertionError) new AssertionError("Unable to access the specified private method").initCause(e);
		} catch (SecurityException e) {
			throw (AssertionError) new AssertionError(
					"There was a security exception when attempting to access a private method").initCause(e);
		} catch (InvocationTargetException e) {
			throw (AssertionError) new AssertionError("The private method threw an exception").initCause(e);
		}
	}

	/**
	 * Parasoft Jtest UTA: Test for createRoleIfNotExists(String)
	 *
	 * @see com.parasoft.demoapp.defaultdata.global.GlobalUsersCreator#createRoleIfNotExists(String)
	 * @author pteodor
	 */
	@Test(timeout = 5000)
	public void testCreateRoleIfNotExists2() throws Throwable {
		// Given
		when(roleService.addNewRole(nullable(String.class))).thenThrow(RoleNameExistsAlreadyException.class);

		// When
		String roleName = "roleName"; // UTA: default value
		RoleEntity result = callPrivateMethod(underTest, GlobalUsersCreator.class, "createRoleIfNotExists",
				new Class<?>[] { String.class }, new Object[] { roleName });

		// Then - assertions for result of method createRoleIfNotExists(String)
		assertNull(result);

	}

}
