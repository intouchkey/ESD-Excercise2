package kmitl.esd.exercise2.service;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import kmitl.esd.exercise2.model.CustomerDTO;

/**
 * Test for customer service
 */
class CustomerServiceTest {
	private CustomerService service = CustomerService.INSTANCE;

	/**
	 * Test for getting all customers
	 */
	@Test
	void getAllCustomers() {
		List<CustomerDTO> customers = service.getAllCustomers();

		assertEquals(customers.size(), 2);
	}

	/**
	 * Test for creating customer
	 */
	@Test
	void createCustomer() {
		service.createCustomer(new CustomerDTO(4L, "Raz", 29));

		assertEquals(service.getAllCustomers().size(), 3);

		service.deleteCustomer(4L);
	}

	/**
	 * Test for updating customer
	 */
	@Test
	void updateCustomer() {
		CustomerDTO customer = service.createCustomer(new CustomerDTO(4L, "Raz", 29));
		customer.setAge(40);

		CustomerDTO updatedCustomer = service.updateCustomer(customer);
		assertEquals(updatedCustomer.getAge(), 40);

		service.deleteCustomer(4L);
	}

	/**
	 * Test for deleting customer
	 */
	@Test
	void deleteCustomer() {
		assertEquals(service.getAllCustomers().size(), 2);

		service.deleteCustomer(1L);

		assertEquals(service.getAllCustomers().size(), 1);

		service.createCustomer(new CustomerDTO(1L, "Tom", 35));
	}
}