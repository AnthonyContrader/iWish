/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it.contrader.service.impl;

import com.it.contrader.domain.Wallet;
import com.it.contrader.repository.WalletRepository;
import com.it.contrader.service.dto.WalletDTO;
import com.it.contrader.service.mapper.WalletMapperImpl;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;




/**
 *
 * @author franc
 */
public class WalletServiceImplTest {
    
    @Mock
    WalletRepository repository;
    
    @Before
    public void init(){
    MockitoAnnotations.initMocks(this);
    }
    
    /**
     * Test of findAllByOwner method, of class WalletServiceImpl.
     */
    @Test
    public void testFindAllByOwner() {
        System.out.println("findAllByOwner");
        
        List<Wallet> walletList = GetFakeData();
        
        when(repository.findAllByOwnerUsername(anyString())).thenAnswer(invocation->{
            String OWNER_ID = invocation.getArgument(0);
            return walletList.stream().filter(e -> e.getOwnerUsername().equals(OWNER_ID)).collect(Collectors.toList());
        });
        
        WalletServiceImpl service = new WalletServiceImpl(repository, new WalletMapperImpl());
        List<WalletDTO> results = service.findAllByOwner("admin");
        assertEquals(2, results.size());
    }
    
    
    public List<Wallet> GetFakeData(){
        List<Wallet> walletList = new ArrayList<>();
        
        walletList.add(new Wallet().ownerUsername("admin"));
        walletList.add(new Wallet().ownerUsername("admin"));
        walletList.add(new Wallet().ownerUsername("aaaa"));
        walletList.add(new Wallet().ownerUsername("bbbbb"));
        
        return walletList;
        
        
    }
    
}
