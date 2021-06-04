package com.lab1;

public class Person {
    private String name;
        private Dog dog;


        public Person(String name, Dog dog) {
            this.name = name;
            this.dog = dog;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setDog(Dog dog) {
        this.dog = dog;
    }

        public Dog getDog() {
            return dog;
        }



}