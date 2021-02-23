package kmitl.esd.exercise2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for customer DTO
 */
class CustomerDTOTest {

	private CustomerDTO customerDTO;

	/**
	 * Prepare customer dto
	 */
	@BeforeEach
	void prepareCustomerDTO() {
		this.customerDTO = new CustomerDTO(1L, "key", 25);
	}

	/**
	 * check if getter and setter for id works
	 */
	@Test
	void checkId() {
		assertEquals(customerDTO.getId(), 1L);
		this.customerDTO.setId(2L);
		assertEquals(customerDTO.getId(), 2L);
	}

	/**
	 * check if getter and setter for name works
	 */
	@Test
	void checkName() {
		assertEquals(customerDTO.getName(), "key");
		this.customerDTO.setName("mel");
		assertEquals(customerDTO.getName(), "mel");
	}

	/**
	 * check if getter and setter for age works
	 */
	@Test
	void checkAge() {
		assertEquals(customerDTO.getAge(), 25);
		this.customerDTO.setAge(35);
		assertEquals(customerDTO.getAge(), 35);
	}
}