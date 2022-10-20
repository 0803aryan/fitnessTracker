package com.cg.fitnesstracker;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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

	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	final void addAppUserServiceTest()
	{
		AppUser a=new AppUser();
		when(appUserRepository.save(any())).thenReturn(a);
		assertEquals(a, appUserServiceImpl.addAppUserService(a));
		
	}
	@Test
	final void testCustomerUpdatePasswordServiceImpl()
	{
		
		AppUser appUser=new AppUser();
		
		appUser.setPassword("1234");
		
		when(appUserRepository.updatePassword(anyString(), anyInt())).thenReturn(1);
		when(appUserRepository.findById(anyInt())).thenReturn(Optional.of(appUser));
		when(appUserRepository.findByUsername(anyString())).thenReturn(appUser);
		assertEquals(appUser,appUserServiceImpl.updateCustomerPasswordService("1", "arc") );
		
	}
//	@Test
//	final void testCustomerUpdatePasswordServiceExceptionImpl()
//	{
//		AppUser appUser=new AppUser();
//		
//		appUser.setPassword("1234");
//		
//		when(appUserRepository.updatePassword(anyString(), anyInt())).thenReturn(0);
//		when(appUserRepository.findByUsername(anyString())).thenReturn(appUser);
//		Exception exception = assertThrows(Exception.class, () -> {
//			assertEquals(appUser,appUserServiceImpl.updateCustomerPasswordService("1", "arc") );
//			});
//
//	    String expectedMessage = "Can't update";
//	    String actualMessage = exception.getMessage();
//	    System.out.println(actualMessage);
//	    assertTrue(actualMessage.contains(expectedMessage));
//	}
}

