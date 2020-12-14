/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

interface Vehicle{
  public void setModel(String model);
  public void setNumberPlate(String numberPlate);
  public String getModel();
  public String getNumberPlate();
  public void info();
}

class Moped implements Vehicle{
  
  String model, numberPlate;

  Moped(String model, String numPlate){
    this.model = model;
    this.numberPlate = numPlate;
  }
  
  public void setModel(String model){
    this.model = model;
  }
  
  public void setNumberPlate(String numPlate){
    this.numberPlate = numPlate;
  }
  
  public String getModel(){
    return this.model;
  }
  
  public String getNumberPlate(){
    return this.numberPlate;
  }
  
  public void info(){
    System.out.println("Model "+ this.model ); 
    System.out.println("Number Plate "+ this.numberPlate );
  }
  
}

class Car implements Vehicle{
  
  String model, numberPlate;

  Car(String model, String numPlate){
    this.model = model;
    this.numberPlate = numPlate;
  }
  
  public void setModel(String model){
    this.model = model;
  }
  
  public void setNumberPlate(String numPlate){
    this.numberPlate = numPlate;
  }
  
  public String getModel(){
    return this.model;
  }
  
  public String getNumberPlate(){
    return this.numberPlate;
  }
  
  public void info(){
    System.out.println("Model "+ this.model ); 
    System.out.println("Number Plate "+ this.numberPlate );
  }
  
}

class Van implements Vehicle{
  
  String model, numberPlate;

  Van(String model, String numPlate){
    this.model = model;
    this.numberPlate = numPlate;
  }
  
  public void setModel(String model){
    this.model = model;
  }
  
  public void setNumberPlate(String numPlate){
    this.numberPlate = numPlate;
  }
  
  public String getModel(){
    return this.model;
  }
  
  public String getNumberPlate(){
    return this.numberPlate;
  }
  
  public void info(){
    System.out.println("Model "+ this.model ); 
    System.out.println("Number Plate "+ this.numberPlate );
  }
  
}


class ParkingLot{

  private final int carSlots, mopedSlots, vanSlots;
  private final int totalSlots;
  private int freeMopedSlots, freeCarSlots, freeVanSlots, totalFreeSlots;
  
  ParkingLot(int m, int c, int v){
    this.mopedSlots = m; this.freeMopedSlots = this.mopedSlots;
    this.carSlots = c; this.freeCarSlots = this.carSlots;
    this.vanSlots = v; this.freeVanSlots = this.vanSlots;
    this.totalSlots = m + c+ v; 
    this.totalFreeSlots = this.freeSlots();
  }
  
  public int totalSlots(){  
     return this.totalSlots;
  }
  
  public void park(Vehicle v){
    System.out.println("#############################################");
    System.out.println(v.getClass().getName() + " wants to park");
    if(!CheckIfFull()){
      switch(v.getClass().getName()){
        case "Moped":
          this.freeMopedSlots = parkDecision(v, this.freeMopedSlots);
          break;
        case "Car":
          this.freeCarSlots = parkDecision(v, this.freeCarSlots);
          break;
        case "Van":
          this.freeVanSlots = parkDecision(v, this.freeVanSlots);
          break;
        default:
          System.out.println("Not a valid Vehicle to park.");
      }
      this.freeSlots();
    }
    System.out.println("#############################################");
  }
   
  public int parkDecision(Vehicle v, int freeSlots){
    if ( freeSlots == 0 ){
        freeSlots = 0;
        System.out.println("Sorry, Parking slots for " + v.getClass().getName() + " are FULL :(");
    } else {
      freeSlots -= 1;
      System.out.println( v.getClass().getName() + " is parked with following details: ");
      v.info();
    }
    return freeSlots;
  }
  
  public int freeSlots(){
    this.totalFreeSlots = this.freeMopedSlots + this.freeCarSlots + this.freeVanSlots;
    return this.totalFreeSlots;
  }
  
  public boolean CheckIfEmpty(){
    boolean check = (this.totalSlots == this.totalFreeSlots) ? true : false;
    if (check) System.out.println("All Parking slots are Empty :)");
    return check;
  }
  
  public boolean CheckIfFull(){
    boolean check = (this.totalFreeSlots == 0) ? true : false;
    if (check) {
      System.out.println("All Parking slots are FULL :(");
      System.out.println("PARKING NOT POSSIBLE!");
    }
    return check;
  }
  
  public void info(){
    System.out.println("----------------------------------------------");
    System.out.println("Parking Lot Info");
    System.out.println("Total Slots: " + this.totalSlots());
    if( (CheckIfEmpty()) || !(CheckIfFull())){
      System.out.println("Total Free Slots: " + this.totalFreeSlots);
      System.out.println("Free Slots for Moped: " +  this.freeMopedSlots);
      System.out.println("Free Slots for Car: " + this.freeCarSlots);
      System.out.println("Free Slots for Van: " + this.freeVanSlots);
    }
    System.out.println("----------------------------------------------");
  }
}

class Solution {
  
  public static void main(String[] args) {
    
    ParkingLot parkingLot = new ParkingLot(1, 2, 3);
    parkingLot.info();
    
    Vehicle c= new Car("VW Polo","DE MA 123456");
    parkingLot.park(c);
    parkingLot.info();
    
    Vehicle m = new Moped("Kawasaki","DE BY 103951");
    parkingLot.park(m);
    parkingLot.info();
    
    Vehicle m2 = new Moped("Ducati","IT SI 103951");
    parkingLot.park(m2);
    parkingLot.info();
    
    Vehicle[] vans = {
      new Van("Volvo","DE HS 933056"),
      new Van("VW","DE KI 637556"),
      new Van("BMW","DE LS 294250"),
      new Van("Jeep","DE NR 502381"),
      new Car("Tesla X","DE MA 123456"),
      new Moped("Vespa","FR NI 876521")
    };
    
    for (Vehicle v : vans){
      parkingLot.park(v);
    }
    
    parkingLot.info();
  }
}
