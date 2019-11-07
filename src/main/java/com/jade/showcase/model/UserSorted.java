package com.jade.showcase.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserSorted {


    public static void main(String[] args) {

        List list = new ArrayList();

        User user1 = new User();

        user1.setAge(35);
        user1.setName("hy");
        user1.setSalary(100);


        User user2 = new User();

        user2.setAge(34);
        user2.setName("fy");
        user2.setSalary(100);

        User user3 = new User();

        user3.setAge(38);
        user3.setName("www");
        user3.setSalary(99);

        list.add(user1);
        list.add(user2);
        list.add(user3);

        List sortList = (List) list.stream().sorted(Comparator.comparing(User::getAge).reversed()).sorted(Comparator.comparing(User::getSalary)).limit(3).collect(Collectors.toList());
       //  List sortList =  list.stream().sorted(Comparator.comparing(User::getAge()).collect(Collectors.toList());

        System.out.println(sortList);
    }

}
