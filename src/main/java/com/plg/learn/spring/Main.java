package com.plg.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args){
SpringApplication.run(Main.class, args);
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
