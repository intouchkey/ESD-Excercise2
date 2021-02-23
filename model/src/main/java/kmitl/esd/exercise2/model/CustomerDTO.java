package kmitl.esd.exercise2.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Customer model
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private int age;

    /**
     * Constructor to create model
     *
     * @param id of the customer
     * @param name of the customer
     * @param age of the customer
     * @return void
     */
    public CustomerDTO(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Function to print details of the customer
     *
     * @return string customer details
     */
    @Override
    public String toString() {
        return "Customer-> " + id + " " + name + " " + age;
    }
}
