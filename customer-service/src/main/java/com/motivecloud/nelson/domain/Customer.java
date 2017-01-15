package com.motivecloud.nelson.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;


@Entity
public @Data class Customer {

   private @Id @NonNull String id;
   private @NonNull String firstName;
   private @NonNull String lastName;
   private @NonNull String street;
   private String street2;
   private @NonNull String city;
   private @NonNull String state;
   private @NonNull String zip;
   private @NonNull String country;
   private @NonNull String email;

   protected Customer() { }
}
