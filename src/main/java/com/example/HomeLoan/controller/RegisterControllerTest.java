//package com.example.HomeLoan.controller;
//
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.example.HomeLoan.model.Users;
//import com.example.HomeLoan.repo.UserRepository;
//
//import static org.hamcrest.Matchers.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@WebMvcTest(RegisterControllerTest.class)
//public class RegisterControllerTest {
//    
// @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper mapper;  
//
//    
//    @MockBean
//    UserRepository userRepo;
//    
//    Users RECORD_1 = new Users(1, "user1","" , "One","user1@123", "user1@gmail.com",Long.parseLong("1234567890"));
//    Users RECORD_2 = new Users(2, "user2","User" , "Two","user2@123", "user2@gmail.com",Long.parseLong("8796545433"));
//    Users RECORD_3 = new Users(3, "user3","User" , "Three","user3@123", "user3@gmail.com",Long.parseLong("8796545434"));
//    
//    @Test
// void contextLoads() {
// }
//    
//    List<Users> records = new ArrayList<>();
//    
//    @AfterEach
//    public void insertMock_Records() {
//     records.add(RECORD_1);
//     records.add(RECORD_2);
//     records.add(RECORD_3);
//    }
//	
//    
//    @Test
//    public void getAllRecords_success() throws Exception {
//        
//        Mockito.when(userRepo.findAll()).thenReturn(records);
//        //When findAll called then ready with records (No DB calls) 
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/getAllUsers")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()) //200
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[2].username", is("user3")));
//    }
//    
//
//}