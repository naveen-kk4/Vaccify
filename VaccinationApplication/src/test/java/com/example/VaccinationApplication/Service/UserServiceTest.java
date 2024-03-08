package com.example.VaccinationApplication.Service;

import com.example.VaccinationApplication.Enum.Gender;
import com.example.VaccinationApplication.Model.Users;
import com.example.VaccinationApplication.Repository.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class UserServiceTest {


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

        Users user = Users.builder()
                .emailId("naveen@gmail.com").
                gender(Gender.MALE)
                .id(2).age(12).build();
        Mockito.when(userRepository.
                getByEmailId("naveen@gmail.com")).thenReturn(user);
    }

    @Test
    void addUser() {
    }

    @Test
    void getVaccinationDate() {
    }

    @Test
    void updateEmail() {
    }

    @Test
    @DisplayName("get data based on valid emailId")
    void getUserByEmailWhenEmailIsValid() {

        String email = "naveen@gmail.com";
        Users user = userService.getUserByEmail(email);
        assertEquals(email,user.getEmailId());

    }
}