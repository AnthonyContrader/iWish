/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it.contrader.web.rest;


import com.it.contrader.service.WishListService;
import com.it.contrader.service.dto.WishListDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author franc
 */
public class WishListResourceTest {

    /**
     * Test of getAllByOwner method, of class WishListResource.
     */
    @Test
    public void testGetAllByOwner() {
        System.out.println("GetAllByOwner");
        WishListService service = Mockito.mock(WishListService.class);
        
        List<WishListDTO> wishlists = GetFakeData();
        
        when(service.findByProprietario(anyLong())).thenAnswer(invocation->{
            long proprietario = invocation.getArgument(0);
            
            return wishlists.stream().filter(e -> e.getProprietario_id() == proprietario).collect(Collectors.toList());
            
        
        });
        
        WishListResource controller = new WishListResource(service);
        List<WishListDTO> wishlistsByP = controller.getAllByOwner((long)12).getBody();
        
        assertEquals(2, wishlistsByP.size());
        
        
    }
    
     public List<WishListDTO> GetFakeData(){
    List<WishListDTO> wishlists = new ArrayList<>();
    
    wishlists.add(new WishListDTO((long)1, "AAAAA", (long)12));
    wishlists.add(new WishListDTO((long)2, "BBBBB", (long)12));
    wishlists.add(new WishListDTO((long)3, "CCCCC", (long)14));
    wishlists.add(new WishListDTO((long)4, "DDDDD", (long)11));
    return wishlists;
     }
    
}
