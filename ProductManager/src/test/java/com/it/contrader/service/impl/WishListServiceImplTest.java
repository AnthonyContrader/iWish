/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it.contrader.service.impl;

import com.it.contrader.domain.WishList;
import com.it.contrader.repository.WishListRepository;
import com.it.contrader.service.dto.WishListDTO;
import com.it.contrader.service.mapper.WishListMapper;
import com.it.contrader.service.mapper.WishListMapperImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author franc
 */
public class WishListServiceImplTest {
    
    public WishListServiceImplTest() {
    }

    

    /**
     * Test of findByProprietario method, of class WishListServiceImpl.
     */
    @Test
    public void testFindByProprietario() {
        System.out.println("findByProprietario");
        WishListRepository wlr = Mockito.mock(WishListRepository.class);
        
        List<WishList> wishlists = GetFakeData();
       
        when(wlr.findByProprietario_id(anyLong())).thenAnswer(invocation->{
           long proprietario = invocation.getArgument(0);
           
           return wishlists.stream().filter(e-> e.getProprietario_id() == proprietario).collect(Collectors.toList());
           
        
        });
        
        WishListServiceImpl service = new WishListServiceImpl(wlr, new WishListMapperImpl());
        
        List<WishListDTO> wishlistsByP = service.findByProprietario((long)22);
        assertEquals(2, wishlistsByP.size());
        
                
    }
    
    public List<WishList> GetFakeData(){
    List<WishList> wishlists = new ArrayList<>();
    
    wishlists.add(new WishList().name("AAAAA").description("descr").proprietario_id((long)22));
    wishlists.add(new WishList().name("roeibneobi").description("vreopok").proprietario_id((long)22));
    wishlists.add(new WishList().name("BBBBB").description("BBBBBB").proprietario_id((long)23));
    wishlists.add(new WishList().name("CCCCC").description("CCCCCC").proprietario_id((long)24));
    return wishlists;
     }
    
}
