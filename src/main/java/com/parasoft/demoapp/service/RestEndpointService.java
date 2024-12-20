package com.parasoft.demoapp.service;

import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.exception.RestEndpointNotFoundException;
import com.parasoft.demoapp.messages.GlobalPreferencesMessages;
import com.parasoft.demoapp.model.global.preferences.RestEndpointEntity;
import com.parasoft.demoapp.repository.global.RestEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.parasoft.demoapp.service.GlobalPreferencesDefaultSettingsService.*;

@Service
public class RestEndpointService {
}
