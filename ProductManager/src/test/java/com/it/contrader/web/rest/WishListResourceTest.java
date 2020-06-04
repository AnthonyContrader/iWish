/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it.contrader.web.rest;

import org.junit.Before;
import com.it.contrader.service.WishListService;
import com.it.contrader.service.dto.WishListDTO;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.mockito.MockitoAnnotations;

/**
 *
 * @author franc
 */
public class WishListResourceTest {

    private MockMvc mockMvc;
    private static final MediaType MEDIA_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Mock
    WishListService service;

    @InjectMocks
    private WishListResource wishListResource;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wishListResource).build();
    }

    /**
     * Test of getAllByOwner method, of class WishListResource.
     */
    @Test
    public void testGetAllByOwner() throws Exception {
        long OWNER_ID = 12;
        System.out.println("GetAllByOwner");
        List<WishListDTO> wishlists = GetFakeData();

        when(service.findByProprietario(anyLong())).thenAnswer(invocation -> {
            long proprietario = invocation.getArgument(0);

            return wishlists.stream().filter(e -> e.getProprietario_id() == proprietario).collect(Collectors.toList());

        });

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/wish-lists/byOwner/" + OWNER_ID);

        mockMvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MEDIA_TYPE));

    }

    public List<WishListDTO> GetFakeData() {
        List<WishListDTO> wishlists = new ArrayList<>();

        wishlists.add(new WishListDTO((long) 1, "AAAAA", (long) 12));
        wishlists.add(new WishListDTO((long) 2, "BBBBB", (long) 12));
        wishlists.add(new WishListDTO((long) 3, "CCCCC", (long) 14));
        wishlists.add(new WishListDTO((long) 4, "DDDDD", (long) 11));
        return wishlists;
    }

}
