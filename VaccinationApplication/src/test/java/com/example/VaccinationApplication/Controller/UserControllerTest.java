package com.example.VaccinationApplication.Controller;

import com.example.VaccinationApplication.Enum.Gender;
import com.example.VaccinationApplication.Model.Users;
import com.example.VaccinationApplication.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private UserService userService;

    @Autowired
    Users user;

    @BeforeEach
    void setUp() {
         user = Users.builder()
                .emailId("naveen@gmail.com").
                gender(Gender.MALE)
                .id(2).age(12).build();

    }

    @Test
    void addUser() {
    Users inpUser = Users.builder()
            .emailId("naveen@gmail.com").
            gender(Gender.MALE)
            .age(12).id(2).build();

    Mockito.when(userService.addUser(inpUser)).thenReturn(user);
//    mockMvc.perform(post("/add-user")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(userInp)).
//            andExpect(status().isOk());


    }

    @Test
    void getVaccinationDate() {
    }
}