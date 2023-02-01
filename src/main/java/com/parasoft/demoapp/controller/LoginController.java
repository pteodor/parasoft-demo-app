package com.parasoft.demoapp.controller;

import com.parasoft.demoapp.service.GlobalPreferencesService;
import com.parasoft.demoapp.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private GlobalPreferencesService globalPreferencesService;

    @Value("${spring.security.oauth2.client.provider.keycloak.realm-uri}")
    private String keycloakRealmUri;

    @GetMapping("/loginPage")
    public String showLoginPage(Authentication authentication, ModelMap modelMap) {

        try {
            modelMap.addAttribute("industry", globalPreferencesService.getCurrentIndustry().getValue());
            modelMap.addAttribute("currentWebServiceMode", globalPreferencesService.getCurrentGlobalPreferences().getWebServiceMode().getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "error/500";
        }

        if (authentication != null) {
            return "redirect:/";
        }

        return "login";
    }

    @GetMapping("/oauth2/login/keycloak")
    public String validateKeycloakServerUrl(ModelMap modelMap) {
        try {
            modelMap.addAttribute("industry", globalPreferencesService.getCurrentIndustry().getValue());
            modelMap.addAttribute("currentWebServiceMode", globalPreferencesService.getCurrentGlobalPreferences().getWebServiceMode().getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "error/500";
        }

        try {
            int code = UrlUtil.validateUrl(keycloakRealmUri);
            if (code != 200) {
                modelMap.addAttribute("keycloakStatusCode", code);
                modelMap.addAttribute("keycloakRealmUri", keycloakRealmUri);
                return "error/keycloakError";
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("keycloakStatusCode", -1);
            return "error/keycloakError";
        }
        return "redirect:/oauth2/authorization/keycloak";
    }
}
