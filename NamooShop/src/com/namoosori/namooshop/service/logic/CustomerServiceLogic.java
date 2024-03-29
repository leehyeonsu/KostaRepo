package com.namoosori.namooshop.service.logic;

import com.namoosori.namooshop.data.CustomerRepository;
import com.namoosori.namooshop.domain.Customer;
import com.namoosori.namooshop.service.facade.CustomerService;

public class CustomerServiceLogic implements CustomerService {
	//
	private CustomerRepository customerRepo;
	
	public CustomerServiceLogic() {
		//
		this.customerRepo = CustomerRepository.getInstance();
	}

	@Override
	public boolean login(String userId, String password) {
		// 
		Customer customer = customerRepo.findCustomerById(userId);
		if (customer != null && customer.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomer(String userId) {
		// 
		//if (userId == "booklove" ) {
		//	throw new RuntimeException("해당 상품의 재고가 없습니다.");
		//}
		
		return customerRepo.findCustomerById(userId);
	}

}
