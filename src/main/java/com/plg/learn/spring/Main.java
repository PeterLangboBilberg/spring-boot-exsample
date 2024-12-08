package com.plg.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args){
SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCostomers(){
    // return List.of();
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
Customer customer = new Customer();
customer.setName(request.name);
customer.setEmail(request.email);
customer.setAge(request.age);
customerRepository.save(customer);
    }
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest request){
        Customer  customer = new Customer();
        customer.setId(id);
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    record NewCustomerRequest(
      String name, String email, Integer age
    ){
    }
    @GetMapping("/greet")
    public Greetresponce greet(){
        return new Greetresponce("Hello", List.of("Java", "Golang"),new Person("Peter",52,3055.55));
    }

    record Person(String name, int age, double savings){};
    record Greetresponce(String greet, List<String> favProgrammingLanguage, Person person){};

//    class Greetresponce{
//        private final String greet;
//
//        Greetresponce(String greet){
//            this.greet = greet;
//        }
//
//        public String getGreet(){
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "Greetresponce{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (o == null || getClass() != o.getClass()) return false;
//            Greetresponce that = (Greetresponce) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(greet);
//        }
//    }
}
