package kmitl.esd.exercise2.service;

import java.util.ArrayList;
import java.util.List;

import kmitl.esd.exercise2.model.CustomerDTO;

/**
 * Web service
 */
public class CustomerService {

	/**
	 * Singleton service
	 */
	public static CustomerService INSTANCE = new CustomerService();

	/**
	 * Customer list to represent the database containing customers
	 */
	private static List<CustomerDTO> customers = new ArrayList<>();

	/**
	 * Since there is no database, this static section is used to create customers
	 * and add it into the customers list
	 */
	static {
		CustomerDTO customerTom = new CustomerDTO(1L, "Tom", 35);
		CustomerDTO customerSuzi = new CustomerDTO(2L, "Suzi", 35);

		customers.add(customerTom);
		customers.add(customerSuzi);
	}

	/**
	 * Private constructor - singleton pattern
	 */
	private CustomerService() {}

	/**
	 * Function to get all of the customers
	 *
	 * @return list of customers
	 */
	public List<CustomerDTO> getAllCustomers() {
		return customers;
	}

	/**
	 * Function to create customer
	 *
	 * @return customer
	 */
	public CustomerDTO createCustomer(CustomerDTO customer) {
		customers.add(customer);
		return customer;
	}

	/**
	 * Function to update customer
	 *
	 * @return customer
	 */
	public CustomerDTO updateCustomer(CustomerDTO customer) {
		try {
			CustomerDTO customerTobeUpdated = customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst().get();
			customers.remove(customerTobeUpdated);
			customers.add(customer);
		} catch (Exception e) {
			customers.add(customer);
		}

		return customer;
	}

	/**
	 * Function to delete customer
	 *
	 * @param customerId
	 * @return boolean - the result of deletion
	 */
	public boolean deleteCustomer(Long customerId) {
		try {
			CustomerDTO customerTobeDeleted = customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
			customers.remove(customerTobeDeleted);

			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
