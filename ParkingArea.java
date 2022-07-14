import java.util.*;
import java.util.UUID;
public class ParkingArea
{
  private List<Slot>slots=new ArrayList<>();
  private List<Ticket>tickets=new ArrayList<>();
  public List<Slot> getSlots()
  {
    return slots;
  }
  public void setSlots(List<Slot>slots)
  {
    this.slots=slots;
  }
  public List<Ticket> getTickets()
  {
    return tickets;
  }
  public void setTickets(List<Ticket>tickets)
  {
    this.tickets=tickets;
  }
  public List<Integer> findEmptySlots()
  {
    int l=slots.size();
    List<Integer>al=new ArrayList<>();
    for(int i=0;i<l;i++)
    {
      if(slots.get(i).getParkingStatus()==ParkingStatus.UNRESERVED)
        al.add(i+1);
    }
    return al;
  }
  public int addInSlot(Customer customer)
  {
    Ticket ticket=new Ticket();
    UUID uuid=UUID.randomUUID();
    ticket.setTicketNumber(uuid.toString());
    int l=slots.size();
    for(int i=0;i<l;i++)
    {
        if(slots.get(i).getParkingStatus()==ParkingStatus.UNRESERVED)
        {
          slots.get(i).setParkingStatus(ParkingStatus.RESERVED);
          List<Customer>customers=slots.get(i).getCustomers();
          if(customers!=null)
            customers.add(customer);
          else
          {
            customers=new ArrayList<>();
            customers.add(customer);
          }
          slots.get(i).setCustomers(customers);
          slots.get(i).setSlotNumber(i+1);
          ticket.setSlotNumber(i+1);
          ticket.setCustomer(customer);
          ticket.setTicketStatus(TicketStatus.NOT_RETURNED);
          List<Ticket>tickets=getTickets();
          if(tickets!=null)
          {
            tickets.add(ticket);
            setTickets(tickets);
          }
          else
          {
            tickets=new ArrayList<>();
            tickets.add(ticket);
            setTickets(tickets);
          }
          return i+1;
        }
    } 
    return -1;
  }
  public Customer removeFromSlot(int slotNumber)
  {
    slots.get(slotNumber-1).setParkingStatus(ParkingStatus.UNRESERVED);
    List<Ticket>tickets=getTickets();
    int j=-1;
    if(tickets!=null)
    {
      int l=tickets.size();
      for(int i=0;i<l;i++)
        {
          if(tickets.get(i).getSlotNumber()==slotNumber)
            j=i;
        }
    }
    tickets.get(j).setTicketStatus(TicketStatus.RETURNED);
    return tickets.get(j).getCustomer();
  }
  
}