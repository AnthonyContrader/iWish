/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it.contrader.web.rest;

import com.it.contrader.service.SecurityService;
import com.it.contrader.service.WalletService;
import com.it.contrader.service.dto.WalletDTO;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders; 

/**
 *
 * @author franc
 */
public class WalletResourceTest {
    
    
    private MockMvc mockMvc;
    private static final MediaType MEDIA_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    private final String LOGIN = "admin";
    @Mock
    WalletService service;
    @Mock
    SecurityService securityService;
    
    @InjectMocks
    WalletResource walletResource;
    
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(walletResource).build();
    }
    
    /**
     * Test of findByOwner method, of class WalletResource.
     */
    @Test
    public void testFindByOwner() throws Exception {
        System.out.println("findByOwner");
       
        List<WalletDTO> walletList = GetFakeData();
        
        
        when(service.findAllByOwner(anyString())).thenAnswer(invocation->{
            String OWNER = invocation.getArgument(0);
            
            return walletList.stream().filter(e -> e.getOwnerUsername()== OWNER).collect(Collectors.toList());
            
        });
        when(securityService.getCurrentUserLogin()).thenReturn(Optional.of("admin"));
        
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/wallets/byOwner/"+LOGIN);
        
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MEDIA_TYPE));
    }
    
    /**
     * Test of method in case of not authorized access 
     */
    @Test
    public void testFindByOwnerFail() throws Exception{
         System.out.println("findByOwnerFail");
        String login = "admin";
        List<WalletDTO> walletList = GetFakeData();
        Mockito.when(service.findAllByOwner(anyString())).thenReturn(walletList);
        Mockito.when(securityService.getCurrentUserLogin()).thenReturn(Optional.of("tizio"));
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/wallets/byOwner/"+LOGIN);
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    
  
    public List<WalletDTO> GetFakeData(){
        List<WalletDTO> walletList = new ArrayList<>();
        
        WalletDTO w1 = new WalletDTO();
        WalletDTO w2 = new WalletDTO();
        WalletDTO w3 = new WalletDTO();
        
        w1.setOwnerUsername("admin");
        w2.setOwnerUsername("admin");
        w3.setOwnerUsername("aaaa");
        
        walletList.add(w1);
        walletList.add(w2);
        walletList.add(w3);
        return walletList;
    }
    
  
    
}
