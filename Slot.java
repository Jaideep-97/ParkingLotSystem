import java.util.*;
public class Slot
{
  private int slotNumber;
  private ParkingStatus ParkingStatus;
  private List<Customer> customers;
  Slot()
  {
    this.ParkingStatus=ParkingStatus.UNRESERVED;
  }
  public int getSlotNumber()
  {
    return slotNumber;
  }

  public void setSlotNumber(int slotNumber)
  {
    this.slotNumber=slotNumber;
  }
  public ParkingStatus getParkingStatus()
  {
    return ParkingStatus;
  }
  public void setParkingStatus(ParkingStatus parkingStatus)
  {
    this.ParkingStatus=parkingStatus;
  }
  public List<Customer> getCustomers()
  {
    return customers;
  }
  public void setCustomers(List<Customer> customers)
  {
    this.customers=customers;
  }
  
}