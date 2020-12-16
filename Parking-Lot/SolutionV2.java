import java.io.*;
import java.util.*;

enum VehicleType{
  MOPED, CAR, VAN;
  
  public String getName(){
    return this.toString().charAt(0) + this.toString().substring(1).toLowerCase() ;
  }
}

class Vehicle<T extends VehicleType, M, N>{
  T type; M model; N numberPlate;
  
  Vehicle(T t, M m, N n){
    setType(t); setModel(m); setNumberPlate(n);
    info();
  }
  
  public void setType(T t){ this.type = t; } 
  public T getType(){ return this.type; }
  
  public void setModel(M m){ this.model = m; }
  public M getModel() { return this.model; }
  
  public void setNumberPlate(N n){ this.numberPlate = n; }
  public N getNumberPlate(){ return this.numberPlate; }
  
  private void info(){
    String vt = getType().getName();
    System.out.println(
      "°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°" +
      "\n" + vt +" with following details wants to park:" +
      "\n"+ vt + "\'s " + "Model: " + getModel() +
      "\n"+ vt + "\'s " + "Number Plate: " + getNumberPlate() +
      "\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"
    );
  }
}

class Parking{
  
  HashMap<VehicleType, Integer> parkingSlots;
  HashMap<VehicleType, Integer> freeParkingSlots;
  
  Parking(HashMap<VehicleType, Integer> ps){
    setParkingSlots(ps);
    setFreeParkingSlots();
    System.out.println(
      "*****************************************************************" +
      "\nParking has following parking slots :" +
      "\n" + getParkingSlots() +
      "\n*****************************************************************"
    );
    info();
  }
  
  public void setParkingSlots(HashMap<VehicleType, Integer> ps){ this.parkingSlots = ps; }
  public HashMap<VehicleType, Integer> getParkingSlots(){ return this.parkingSlots; }
  
  public int calTotal(HashMap<VehicleType, Integer> ps){
    int total = 0;
    for ( Integer c : ps.values() ){
      total += c.intValue();
    }
    return total;
  }
  
  private void setFreeParkingSlots() { 
    this.freeParkingSlots = new HashMap<VehicleType, Integer>(); this.freeParkingSlots.putAll(getParkingSlots()); 
  }
  
  private HashMap<VehicleType, Integer> getFreeParkingSlots(){ return this.freeParkingSlots; }
  
  public void park(Vehicle<VehicleType, String, String> v){
    
    if( this.isFull() ){
      System.out.println("No Free Parking Slots left! \nParking NOT Possible :(");
      return;
    }
    
    int count = this.freeParkingSlots.get(v.type).intValue();
    if( count == 0 ){
      System.out.println("No Free Parking Slots for " + v.type.getName() + "!");
      return;
    }
    this.freeParkingSlots.put(v.type, count - 1);
    System.out.println(v.type.getName() + " is parked!");
    
  }
  
  private boolean isFull(){
    return calTotal(this.freeParkingSlots) == 0;
  }
  
  private boolean isFree(){
    return calTotal(getParkingSlots()) == calTotal(this.freeParkingSlots);
  }
  
  public void info(){
    int totalSlots = calTotal(getParkingSlots());
    int totalFreeSlots = calTotal(getFreeParkingSlots());
    System.out.println(
      "°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°" +
      "\nTotal Parking Slots: " + totalSlots
    );
    System.out.println("Parking Slots: " + getParkingSlots() );
    System.out.println("Total Free Parking Slots: " + totalFreeSlots );
    System.out.println("Free Parking Slots: " + getFreeParkingSlots() );
    if( isFree() ){
      System.out.println("All Parking Slots are Free :)");
    }
    System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
  }
}

class Solution {
  public static void main(String[] args) {
    
    HashMap<VehicleType, Integer> parkingSlots = new HashMap<VehicleType, Integer>();
    parkingSlots.put(VehicleType.MOPED, 1);
    parkingSlots.put(VehicleType.CAR, 2);
    parkingSlots.put(VehicleType.VAN, 3);
    Parking parking = new Parking(parkingSlots);
    
    ArrayList<Vehicle<VehicleType, String, String>> vehicles = new ArrayList<Vehicle<VehicleType, String, String>>();
    vehicles.add(new Vehicle<VehicleType, String, String>(VehicleType.CAR, "VW", "DE MA 424982"));
    vehicles.add(new Vehicle<VehicleType, String, String>(VehicleType.VAN, "Volvo", "FR NI 29812120"));
    vehicles.add(new Vehicle<VehicleType, String, String>(VehicleType.MOPED, "Ducati", "IT SI 3832919"));
    vehicles.add(new Vehicle<VehicleType, String, String>(VehicleType.MOPED, "Kawasaki", "DE NS 8787888"));
    
    for(Vehicle<VehicleType, String, String> v : vehicles ){
      parking.park(v);
    }
    parking.info();
    
    ArrayList<Vehicle<VehicleType, String, String>> vehicles2 = new ArrayList<Vehicle<VehicleType, String, String>>();
    vehicles2.add(new Vehicle<VehicleType, String, String>(VehicleType.CAR, "BMW", "DE BA 424982"));
    vehicles2.add(new Vehicle<VehicleType, String, String>(VehicleType.VAN, "Tesla", "DE BR 29812120"));
    vehicles2.add(new Vehicle<VehicleType, String, String>(VehicleType.VAN, "Opel", "DE KI 8786868"));
    vehicles2.add(new Vehicle<VehicleType, String, String>(VehicleType.VAN, "Ford", "DE BY 4777890"));
    for(Vehicle<VehicleType, String, String> v : vehicles2 ){
      parking.park(v);
    }
    parking.info();
  }
}
