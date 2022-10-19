package com.cg.fitnesstracker;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.dto.UpdateEmailDto;
import com.cg.fitnesstracker.app.dto.UpdatePasswordDto;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.enums.UserType;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.service.implementation.AppUserServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AppUserServiceImplTest {
	@Mock
	private AppUserRepository appUserRepository;
	@InjectMocks
	private AppUserServiceImpl appUserServiceImpl;
	
	//private UpdateEmailDto e;
	private UpdatePasswordDto p;
	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	final void testUpdateEmailServiceImpl()
	{
		
		AppUser appUser=new AppUser();
		appUser.setUserEmail("archit@abc.com");
		appUser.setPassword("1234");
		appUser.setUserType(UserType.CUSTOMER);
		when(appUserRepository.updateEmail(anyString(), anyInt())).thenReturn(1);
		when(appUserRepository.findById(anyInt())).thenReturn(Optional.of(appUser));
		
		assertEquals(1, appUserRepository.updateEmail("archit@abc.com", 1));
		AppUser a=appUserServiceImpl.updateCustomerEmailService("archit@abc.com", 1);
		assertEquals(appUser,a );
	}
	@Test
	final void testUpdatePasswordServiceImpl()
	{
		
		AppUser appUser=new AppUser();
		appUser.setUserEmail("archit@abc.com");
		appUser.setPassword("1234");
		appUser.setUserType(UserType.CUSTOMER);
		when(appUserRepository.updatePassword(anyString(), anyInt())).thenReturn(1);
		when(appUserRepository.findById(anyInt())).thenReturn(Optional.of(appUser));
		
		assertEquals(1, appUserRepository.updatePassword("1234", 1));
		AppUser a=appUserServiceImpl.updateCustomerPasswordService("1234", 1);
		assertEquals(appUser,a );
	}
}

