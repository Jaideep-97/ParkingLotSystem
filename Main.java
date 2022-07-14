import java.util.*;
import java.io.*;
class Main {
  public static List<String> getVehicleNoFromAge(List<Slot>slots, int age)
  {
    int l=slots.size();
    List<String>al=new ArrayList<>();
    for(int i=0;i<l;i++)
    {
      if(slots.get(i).getCustomers()!=null)
      {
        List<Customer>customers=slots.get(i).getCustomers();
        for(int j=0;j<customers.size();j++)
        {
          if(customers.get(j).getAge()==age)
              al.add(customers.get(j).getVehicleNo());
        }
      }
        
    }
    return al;
  }
  public static int getSlotNumberFromVehicleNo(List<Ticket>tickets, String vehicleNo)
  {
      int l=tickets.size();
      for(int i=0;i<l;i++)
      {
          if(tickets.get(i).getCustomer().getVehicleNo().equals(vehicleNo))
            return tickets.get(i).getSlotNumber();
      }
    return -1;
  }
  public static List<Integer> getSlotNumbersFromAge(List<Ticket>tickets, int age)
  {
      int l=tickets.size();
      List<Integer>al=new ArrayList<>();
      for(int i=0;i<l;i++)
      {
          if(tickets.get(i).getCustomer().getAge()==age)
            al.add(tickets.get(i).getSlotNumber());
      }
    return al;
  }
  public static void main(String[] args) throws FileNotFoundException, IOException{
    ParkingArea parkingArea=new ParkingArea();
    List<Slot>slots=new ArrayList<>();
    int n;
    File Obj = new File("input.txt");
    FileWriter Writer= new FileWriter("output.txt", true);
    Scanner Reader = new Scanner(Obj);
    while (Reader.hasNextLine()) {
        String data = Reader.nextLine();
        int i=data.indexOf(' ');
        System.out.println(data.substring(0,i));
        String s=data.substring(0,i); 
        if(s.equals("Create_parking_lot"))
        {
          n=Integer.parseInt(data.substring(i+1));
          for(int j=0;j<n;j++)
          {
            Slot slot=new Slot();
            slots.add(slot); 
          }
    
          parkingArea.setSlots(slots);
          Writer.write("Created parking of "+n+ " slots\n");
        }
        else if(s.equals("Park"))
        {
            int index2ndspace=data.indexOf(' ',i+1);
            String vehicleNo=data.substring(i+1,index2ndspace);
            int index3rdspace=data.indexOf(' ',index2ndspace+1);
            int age=Integer.parseInt(data.substring(index3rdspace+1));
          Customer customer=new Customer(age,vehicleNo);
          int slotNumber=parkingArea.addInSlot(customer);
          Writer.write("Car with vehicle registration number "+vehicleNo+" has been parked at slot number "+slotNumber+"\n");
        }
      else if(s.equals("Slot_numbers_for_driver_of_age"))
      {
        int age=Integer.parseInt(data.substring(i+1));
        List<Ticket>tickets=parkingArea.getTickets();
List<Integer>res=getSlotNumbersFromAge(tickets,age);    
String s1="";
for(int j=0;j<res.size();j++)
  s1+=res.get(j)+" ";
Writer.write(s1+"\n");
      }
      else if(s.equals("Slot_number_for_car_with_number"))
      {
          String vehicleNo=data.substring(i+1);
        List<Ticket>tickets=parkingArea.getTickets();           Writer.write(getSlotNumberFromVehicleNo(tickets,vehicleNo)+"\n");
      }
    else if(s.equals("Leave"))
    {
        int slotNumber=Integer.parseInt(data.substring(i+1));
      Customer customer=parkingArea.removeFromSlot(slotNumber);
      Writer.write("Slot number "+ slotNumber+ " vacated, the car with vehicle registration number "+customer.getVehicleNo()+" left the space, the driver of the car was of age "+customer.getAge()+"\n");
    }
    else if(s.equals("Vehicle_registration_number_for_driver_of_age"))
    {
        int age=Integer.parseInt(data.substring(i+1));
      List<String>vehicleNo=getVehicleNoFromAge(slots,age);
      List<Ticket>tickets=parkingArea.getTickets();
      for(int j=0;j<vehicleNo.size();j++){
      int slotNumber=getSlotNumberFromVehicleNo(tickets,vehicleNo.get(j));
      Writer.write("Car with vehicle registration number "+vehicleNo.get(j)+" is parked at slot number "+slotNumber+" whose driver is of age "+age+"\n");
    }
    }
    }
   
    Reader.close();
    Writer.close();
    
    
  }
}