public class Ticket
{
  private String ticketNumber;
  private int slotNumber;
  private Customer customer;
  private TicketStatus ticketStatus;

  public String getTicketNumber()
  {
    return ticketNumber;
  }
  public void setTicketNumber(String ticketNumber)
  {
    this.ticketNumber=ticketNumber;
  }
  public int getSlotNumber()
  {
    return slotNumber;
  }
  public void setSlotNumber(int slotNumber)
  {
    this.slotNumber=slotNumber;
  }
  public Customer getCustomer()
  {
    return customer;
  }
  public void setCustomer(Customer customer)
  {
    this.customer=customer;
  }
  public TicketStatus getTicketStatus()
  {
    return ticketStatus;
  }
  public void setTicketStatus(TicketStatus ticketStatus)
  {
    this.ticketStatus=ticketStatus;
  }
}