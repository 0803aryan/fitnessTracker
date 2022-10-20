package com.cg.fitnesstracker;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
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
 
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.Admin;
import com.cg.fitnesstracker.app.model.AppUser;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.repository.AdminRepository;
import com.cg.fitnesstracker.app.repository.AppUserRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.implementation.AdminServiceImpl;
 
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AdminServiceImplTest {
    @Mock
    private AdminRepository adminRepo;
    @Mock
    private AppUserRepository appUserRepo;

    @Mock
    private CustomerRepository customerRepo;
    @InjectMocks
    private AdminServiceImpl adminServiceImpl;

    @BeforeEach
    final void setup()
    {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    final void addAdminDetailServiceTest()
    {
        Admin ad=new Admin();
        ad.setAdminName("archit");
        ad.setUserEmail("arc@abc.com");
        AppUser appUser=new AppUser();
        appUser.setUsername("qwerty");
        appUser.setUserId(1);
        when(appUserRepo.findByUsername(any())).thenReturn(appUser);

        when(adminRepo.addAdminDetails(anyString(), anyString(), anyInt())).thenReturn(1);
        assertEquals(appUser,adminServiceImpl.addAdminDetailService("archit",ad));

    }
//    @Test
//    final void addAdminDetailServiceExceptionTest()
//    {
//        Admin ad=new Admin();
//        ad.setAdminName("archit");
//        ad.setUserEmail("arc@abc.com");
//        AppUser appUser=new AppUser();
//        appUser.setUsername("qwerty");
//        
//        when(appUserRepo.findByUsername(any())).thenReturn(appUser);
//        when(adminRepo.addAdminDetails(anyString(), anyString(), anyInt())).thenReturn(0);
//        Exception exception = assertThrows(Exception.class, () -> {
//            assertEquals(ad,adminServiceImpl.addAdminDetailService("archit",ad));
//        });
//        Exception e1=new ApplicationException("Can't update",400);
//
//        assertTrue(e1.getMessage().equals(exception.getMessage()));
//        
//    }

    @Test
    final void readAllCustomerDetailsServiceImplTest()
    {
        List<Customer> custList = new ArrayList<>();
        Customer c1=new Customer();
        Customer c2=new Customer();
        custList.add(c1);
        custList.add(c2);
        Iterable<Customer> I=custList;
        when(customerRepo.findAll()).thenReturn(I);
        assertEquals(custList, adminServiceImpl.readAllCustomerDetailService());
    }
    @Test
    final void readAllCustomerDetailByIdServiceImplTest()
    {
        Customer c1=new Customer();
        AppUser ap=new AppUser();
        ap.setUsername("arc");
        when(appUserRepo.findByUsername(any())).thenReturn(ap);
        when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c1));
        assertEquals(c1, adminServiceImpl.readCustomerDetailByIdService("arc"));
    }
//    @Test
//    final void readAllCustomerDetailByIdServiceImplExceptionTest()
//    {
//        Customer c1=new Customer();
//        AppUser ap=new AppUser();
//        ap.setUsername("arc");
//        when(appUserRepo.findByUsername(any())).thenReturn(ap);
//        when(customerRepo.findById(anyInt())).thenReturn(null);
//        Exception exception = assertThrows(Exception.class, () -> {
//            assertEquals(c1, adminServiceImpl.readCustomerDetailByIdService("arc"));
//        });
//        Exception e1=new ApplicationException("User Id is incorrect",400);
//
//        assertTrue(e1.getMessage().equals(exception.getMessage()));
//        
//    }
    @Test
    final void deleteCustomerByIdServiceImplTest()
    {
        Customer c=new Customer();
        c.setUsername("arc");
        c.setUserId(1);
        AppUser a=new AppUser();
        a.setUsername("arc");
        a.setUserId(1);
        when(customerRepo.findById(anyInt())).thenReturn(Optional.of(c));
        when(appUserRepo.findByUsername(anyString())).thenReturn(a);
        adminServiceImpl.deleteCustomerByIdService("arc");
        verify(customerRepo).deleteById(any());
    }
    @Test
    final void updateAdminEmailServiceTest()
    {
        AppUser a=new AppUser();
        Admin ad=new Admin();
        a.setUserId(1);
        when(appUserRepo.findByUsername(anyString())).thenReturn(a);
        when(adminRepo.updateAdminEmail(anyString(), anyInt())).thenReturn(1);
        when(adminRepo.findById(anyInt())).thenReturn(Optional.of(ad));
        assertEquals(ad, adminServiceImpl.updateAdminEmailService("archhh", "arc"));
    }
//    @Test
//    final void updateAdminEmailServiceExceptionTest()
//    {
//        AppUser a=new AppUser();
//        a.setUserId(1);
//        a.setUsername("arc");
//        Admin ad=new Admin();
//        ad.setAdminName("arc");
//        ad.setUserId(1);
//        a.setUserId(1);
//        when(appUserRepo.findByUsername(anyString())).thenReturn(a);
//        when(adminRepo.updateAdminEmail(anyString(), anyInt())).thenReturn(0);
//        Exception exception = assertThrows(Exception.class, () -> {
//            assertEquals(ad,adminServiceImpl.updateAdminEmailService("archit","arc"));
//        });
//
//        Exception e1=new ApplicationException("User not found. Can't update",404);
//
//        assertTrue(e1.getMessage().equals(exception.getMessage()));
//    }

}