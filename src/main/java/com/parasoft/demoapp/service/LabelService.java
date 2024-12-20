package com.parasoft.demoapp.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.parasoft.demoapp.exception.LocalizationException;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.messages.GlobalPreferencesMessages;
import com.parasoft.demoapp.model.global.LocalizationLanguageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parasoft.demoapp.model.industry.LabelEntity;
import com.parasoft.demoapp.repository.industry.LabelRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LabelService {
}
