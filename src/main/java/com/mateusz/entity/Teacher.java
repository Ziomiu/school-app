package com.mateusz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher
{
    
   
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer  id; 
        
        @Column(name = "name")
        private String name;
        @Column(name = "surname")
        private String surname;
        @Column(name = "password")
        private String password;
        @Column(name = "email")
        private String email;
        
        @Column(name= "phoneNumber")
        private String phoneNumber;
        
        public Teacher(Integer id, String name, String surname, String password, String email, String phoneNumber)
        {
            super();
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.password = password;
            this.email = email;
            
            this.phoneNumber = phoneNumber;
            
        }
        Teacher(){}
        public Integer getId()
        {
            return id;
        }
        public void setId(Integer id)
        {
            this.id = id;
        }
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public String getSurname()
        {
            return surname;
        }
        public void setSurname(String surname)
        {
            this.surname = surname;
        }
        public String getPassword()
        {
            return password;
        }
        public void setPassword(String password)
        {
            this.password = password;
        }
        public String getEmail()
        {
            return email;
        }
        public void setEmail(String email)
        {
            this.email = email;
        }
        public String getPhoneNumber()
        {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }
        
}
