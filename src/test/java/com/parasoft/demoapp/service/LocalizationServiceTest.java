package com.parasoft.demoapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource;
import com.parasoft.demoapp.messages.GlobalPreferencesMessages;
import com.parasoft.demoapp.messages.LocalizationMessages;
import com.parasoft.demoapp.model.global.LocalizationLanguageType;
import com.parasoft.demoapp.model.global.preferences.IndustryType;
import com.parasoft.demoapp.model.industry.LabelEntity;

/**
 * Test class for LocalizationService
 *
 * @see com.parasoft.demoapp.service.LocalizationService
 */
@PrepareForTest({ LocalizationService.class, Properties.class })
@RunWith(PowerMockRunner.class)
public class LocalizationServiceTest {
	@InjectMocks
	LocalizationService underTest;

	@Mock
	LabelService labelService;

	@Mock
	GlobalPreferencesService globalPreferencesService;

	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test for getLocalization(LocalizationLanguageType) with normal 'defense'
	 *
	 * @see com.parasoft.demoapp.service.LocalizationService#getLocalization(LocalizationLanguageType)
	 */
	@Test
	public void testGetLocalization_normal_Defense() throws Throwable {
		// Given
		IndustryRoutingDataSource.currentIndustry = IndustryType.DEFENSE;
		LocalizationLanguageType language = LocalizationLanguageType.ZH;

		// When
		String result = underTest.getLocalization(language);

		// Then
		assertEquals(true, isContainChinese(result));
	}

	/**
	 * Test for getLocalization(LocalizationLanguageType) with normal 'aerospace'
	 *
	 * @see com.parasoft.demoapp.service.LocalizationService#getLocalization(LocalizationLanguageType)
	 */
	@Test
	public void testGetLocalization_normal_Aerospace() throws Throwable {
		// Given
		IndustryRoutingDataSource.currentIndustry = IndustryType.AEROSPACE;
		LocalizationLanguageType language = LocalizationLanguageType.ZH;

		// When
		String result = underTest.getLocalization(language);

		// Then
		assertEquals(true, isContainChinese(result));
	}

	private Object isContainChinese(String result) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(result);
		return m.find();
	}

	/**
	 * Test for getLocalization(LocalizationLanguageType) with normal
	 *
	 * @see com.parasoft.demoapp.service.LocalizationService#getLocalization(LocalizationLanguageType)
	 */
	@Test
	public void testGetLocalization_normal_overrideValue() throws Throwable {
		// Given
		IndustryRoutingDataSource.currentIndustry = IndustryType.AEROSPACE;
		List<LabelEntity> labelFromDB = new ArrayList<>();
		String propertyName = "PROJECT_NAME";
		String defaultPropertyValue = "PARA-VERS"; // value in properties file
		String propertyValue = "GENERIC PROJECT";
		LocalizationLanguageType language = LocalizationLanguageType.ZH;
		LabelEntity labelEntity = new LabelEntity(propertyName, propertyValue, language);
		labelFromDB.add(labelEntity);
		when(labelService.getAllLabelsFromDBByLanguageType(language)).thenReturn(labelFromDB);
		when(globalPreferencesService.getLabelOverridedStatus()).thenReturn(true);

		// When
		String result = underTest.getLocalization(language);

		// Then
		assertNotNull(result);
		assertTrue(result.contains(propertyName));
		assertTrue(result.contains(propertyValue));
		assertFalse(result.contains(defaultPropertyValue));


		// Given
		propertyValue = ""; // blank value, will not be override.
		labelEntity.setValue(propertyValue);

		// When
		result = underTest.getLocalization(language);

		// Then
		assertNotNull(result);
		assertTrue(result.contains(defaultPropertyValue));
	}

	/**
	 * Test for getLocalization(LocalizationLanguageType) with LocalizationException
	 *
	 * @see com.parasoft.demoapp.service.LocalizationService#getLocalization(LocalizationLanguageType)
	 */
	@Test
	public void testGetLocalization_localizationException() throws Throwable {
		// Given
		IndustryRoutingDataSource.currentIndustry = IndustryType.AEROSPACE;
		LocalizationLanguageType language = LocalizationLanguageType.ZH;
		Properties properties = PowerMockito.mock(Properties.class);
		PowerMockito.whenNew(Properties.class).withAnyArguments().thenReturn(properties);
		doThrow(IOException.class).when(properties).load(any(InputStream.class));

		// When
		String message = "";
		try{
			underTest.getLocalization(language);
		}catch (Exception e){
			e.printStackTrace();
			message = e.getMessage();
		}

		assertEquals(LocalizationMessages.FAILED_TO_LOAD_PROPERTIES_FILE, message);
	}

	/**
	 * Test for getLocalization(LocalizationLanguageType) with LocalizationException
	 *
	 * @see com.parasoft.demoapp.service.LocalizationService#getLocalization(LocalizationLanguageType)
	 */
	@Test
	public void testGetLocalization_parameterException() throws Throwable {
		// Given
		IndustryRoutingDataSource.currentIndustry = IndustryType.AEROSPACE;
		Properties properties = PowerMockito.mock(Properties.class);
		PowerMockito.whenNew(Properties.class).withAnyArguments().thenReturn(properties);
		doThrow(IOException.class).when(properties).load(any(InputStream.class));

		// When
		String message = "";
		LocalizationLanguageType language = null; // test point
		try{
			underTest.getLocalization(language);
		}catch (Exception e){
			e.printStackTrace();
			message = e.getMessage();
		}

		assertEquals(GlobalPreferencesMessages.LOCALIZATION_LANGUAGE_TYPE_CANNOT_BE_NULL, message);
	}
}