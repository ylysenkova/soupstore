package com.lysenkova.soapstore.service;

import java.util.Map;
import java.util.UUID;

public interface SecurityService {
    UUID validateUser(Map<String, String> loginPasswordMap);
}
