/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static stream.Gender.FEMALE;

/**
 *
 * @author user
 */

public class Stream {

    /**
     * @param args the command line arguments
     */
    static List<Person> peoples = getPeople(); 
    
    
    public static void main(String[] args) {
        // TODO code application logic here44
        
       boolean c = Boolean.TRUE;
                
        
       List<Person> females =  peoples.stream().filter(person->person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
   
       females.forEach(System.out::println);
       
       
      List<Person> sorted =  peoples.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed()).collect(Collectors.toList());
    
      sorted.forEach(System.out::println);
      
      
      //Get the list of persons age greater than 5
     boolean allmatch =  peoples.stream().allMatch(person->person.getAge() > 5);//.collect(Collectors.toList());
      
     System.out.println(allmatch);
   
     //Do a search for any
     boolean anymatch = peoples.stream().anyMatch(person->person.getAge() > 21);
     
     System.out.println(anymatch);
     
     //This is going to do a none match
     boolean nonematch = peoples.stream().noneMatch(person->person.getName().equals("jide"));
     
     System.out.println(nonematch);
     
     //Display the Max
     peoples.stream().max(Comparator.comparing(item->item.getAge())).ifPresent(System.out::println);
     
     //Display the Min
     peoples.stream().min(Comparator.comparing(item->item.getAge())).ifPresent(System.out::println);
     
     //This is the groupBy
    Map<Gender, List<Person>> groupByGender =  peoples.stream().collect(Collectors.groupingBy(item->item.getGender()));
   
    groupByGender.forEach((gender,people) -> {
    
        System.out.println(gender);
        
        people.forEach(System.out::println);
    });
    
    //We are going to print out the oldest female on the list
    
    Optional<Person> oldestFemale = peoples.stream().filter(item->item.getGender().equals(FEMALE)).max(Comparator.comparing(Person::getAge));
  
    
    System.out.println("Oldest female");
    oldestFemale.ifPresent(System.out::println);
    
    
    
    System.out.println();
    System.out.println(returnList1());
        
    }
    
    
    public static List<Dbobject> returnList(){
        
        //replace this with the database module to return from your database
        List<Dbobject> list = List.of( new Dbobject("FREE494","NIBBS"));
         
        List<Dbobject> newlist =  list.stream().filter(item->item.getWallet_number().equalsIgnoreCase("FREE494")  && item.getRemark().equalsIgnoreCase("NIBBS") ).collect(Collectors.toList());
        
        return newlist;
    }
    
     public static List<Dbobject> returnList1(){
        
        //replace this with the database module to return from your database
        List<Dbobject> list = List.of( new Dbobject("FREE494","NIBBS"), new Dbobject("FREE494","Remoney"), new Dbobject("FREE494","NIBBS"));
        
       // list.stream().anyMatch(item->item.getWallet_number());
         
        List<Dbobject> newlist =  list.stream().filter(item->item.getWallet_number().equalsIgnoreCase("FREE494")  && item.getRemark().equalsIgnoreCase("NIBBS")  == false).collect(Collectors.toList());
        
                
        return newlist;
    }
    
    
    private static List<Person> getPeople(){

	List<Person> persons =  new ArrayList<>();
        
        persons.add(new Person("Jide Akindejoye", 20, Gender.MALE));
        persons.add(new Person("Alina Smith", 33, Gender.FEMALE));
        persons.add(new Person("Helen White", 57, Gender.MALE));
        persons.add(new Person("Alex Box", 14, Gender.MALE));
        persons.add(new Person("James Bond", 21, Gender.MALE));
   
        return persons;
    }

}