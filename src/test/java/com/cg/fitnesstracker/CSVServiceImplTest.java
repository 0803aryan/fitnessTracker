package com.cg.fitnesstracker;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.mock.web.MockMultipartFile;

import com.cg.fitnesstracker.app.model.FoodItem;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.repository.FoodItemRepository;
import com.cg.fitnesstracker.app.service.implementation.AppUserServiceImpl;
import com.cg.fitnesstracker.app.service.implementation.CSVServiceImpl;
import com.cg.fitnesstracker.app.utils.csv.CSVHelper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CSVServiceImplTest {
	@Mock
	private FoodItemRepository foodItemRepo;
	@InjectMocks
	private CSVServiceImpl csvServiceImpl;
	
	
	@BeforeEach
	final void setup()
	{
		
	}
	
	@Test
	final void saveTest()
	{
		
		MockMultipartFile file 
	      = new MockMultipartFile(
	        "file", 
	        "hello.txt", 
	        MediaType.TEXT_PLAIN_VALUE, 
	        "Hello, World!".getBytes()
	      );
		List<FoodItem> fooditems=new ArrayList();
		when(foodItemRepo.saveAll(any())).thenReturn(fooditems);
		csvServiceImpl.save(file);
		verify(foodItemRepo).saveAll(any());
	}
	@Test
	final void saveExceptionTest()
	{
		MockMultipartFile file 
	      = new MockMultipartFile(
	  	        "file", 
		        "hello.bat",
		        MediaType.TEXT_HTML_VALUE, 
		        "".getBytes()
		      );
		System.out.println(file.getContentType());
		List<FoodItem> fooditems=new ArrayList();
		when(foodItemRepo.saveAll(any())).thenReturn(fooditems);
		//when(CSVHelper.csvToFoodItem(any())).thenReturn(null);
		Exception exception = assertThrows(Exception.class, () -> {
			csvServiceImpl.save(file);
	    });

	    String expectedMessage = "fail to store csv data ";
	    String actualMessage = exception.getMessage();
	    System.out.println(actualMessage);
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	final void getAllFoodItemsTest()
	{
		List<FoodItem> fooditems=new ArrayList();
		Iterable items=fooditems;
		when(foodItemRepo.findAll()).thenReturn(items);
		assertEquals(fooditems, csvServiceImpl.getAllFoodItems());
	}
}
