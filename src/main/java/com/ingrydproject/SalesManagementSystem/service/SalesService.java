//package com.ingrydproject.SalesManagementSystem.service;
//
//import com.ingrydproject.SalesManagementSystem.dto.SalesDto;
//import com.ingrydproject.SalesManagementSystem.model.Sales;
//import com.ingrydproject.SalesManagementSystem.model.User;
//import com.ingrydproject.SalesManagementSystem.repository.SalesRepository;
//import com.ingrydproject.SalesManagementSystem.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SalesService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private SalesRepository salesRepository;
//
//    @CacheEvict(value = "allSales", allEntries = true)
//    public String addSales(int id, SalesDto salesDto){
//        User user = userRepository.findById(id).orElseThrow(null);
//        Sales sales1 = new Sales(salesDto.getSaleDate(), salesDto.getQuantity(), salesDto.getTotalPrice(), salesDto.getUser(), salesDto.getProduct());
//        salesRepository.save(sales1);
//        return "Sales added Successfully";
//    }
//
//    @Cacheable("allSales")
//    public List<Sales> getAllSales(){
//        return salesRepository.findAll();
//    }
//
//    @Cacheable(value = "singleSale", key = "#id")
//    public Sales findSalesById(int id){
//        return salesRepository.findById(id).get();
//    }
//
//    @CacheEvict(value = {"singleSale", "allSales"}, allEntries = true)
//    public String deleteSales(int id){
//        Sales delete = salesRepository.findById(id).get();
//        userRepository.delete(delete.getUser());
//        return "User has been deleted";
//    }
//
//    @CacheEvict(value = {"singleSale", "allSales"}, allEntries = true)
//    public Sales updateUser (int id, SalesDto salesDto){
//        Sales sales = salesRepository.findById(id).get();
//
//        sales.setSaleDate(salesDto.getSaleDate());
//        sales.setProduct(salesDto.getProduct());
//        sales.setQuantity(salesDto.getQuantity());
//
//
//        return salesRepository.save(sales);
//    }
//
//
//}
