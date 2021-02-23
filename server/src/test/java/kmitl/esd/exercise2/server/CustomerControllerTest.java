package kmitl.esd.exercise2.server;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import kmitl.esd.exercise2.model.CustomerDTO;

/**
 * Test for customer controller
 */
class CustomerControllerTest {

	private CustomerController controller = new CustomerController();

	/**
	 * Test for getting all customers
	 */
	@Test
	void getAllCustomers() {
		List<CustomerDTO> customers = controller.getAllCustomers();

		assertEquals(customers.size(), 2);
	}

	/**
	 * Test for creating customer
	 */
	@Test
	void createCustomer() {
		controller.createCustomer(new CustomerDTO(4L, "Raz", 29));

		assertEquals(controller.getAllCustomers().size(), 3);

		controller.deleteCustomer(4L);
	}

	/**
	 * Test for updating customer
	 */
	@Test
	void updateCustomer() {
		CustomerDTO customer = controller.createCustomer(new CustomerDTO(4L, "Raz", 29));
		customer.setAge(40);

		CustomerDTO updatedCustomer = controller.updateCustomer(customer);
		assertEquals(updatedCustomer.getAge(), 40);

		controller.deleteCustomer(4L);
	}

	/**
	 * Test for deleting customer
	 */
	@Test
	void deleteCustomer() {
		assertEquals(controller.getAllCustomers().size(), 2);

		controller.deleteCustomer(1L);

		assertEquals(controller.getAllCustomers().size(), 1);

		controller.createCustomer(new CustomerDTO(1L, "Tom", 35));
	}
}