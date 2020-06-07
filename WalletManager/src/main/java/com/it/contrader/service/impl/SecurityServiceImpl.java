/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it.contrader.service.impl;

import com.it.contrader.security.SecurityUtils;
import com.it.contrader.service.SecurityService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    
    public Optional<String> getCurrentUserLogin(){
        return SecurityUtils.getCurrentUserLogin();
    }
    
}
