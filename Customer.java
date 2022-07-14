public class Customer
{
  private int age;
  private String vehicleNo;

  Customer(int age, String vehicleNo)
  {
    this.age=age;
    this.vehicleNo=vehicleNo;
  }
  public int getAge()
  {
    return age;
  }
  public void setAge(int age)
  {
    this.age=age;
  }
  public String getVehicleNo()
  {
    return vehicleNo;
  }
  public void setVehicleNo(String vehicleNo)
  {
    this.vehicleNo=vehicleNo;
  }
}