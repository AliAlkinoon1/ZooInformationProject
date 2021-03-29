
import java.util.ArrayList;
import java.util.List;

public class ZooLogic {

    List<Customer> customer = new ArrayList<Customer>();
    List<Ticket> ticket = new ArrayList<Ticket>();
    List<Booking> bookingList = new ArrayList<Booking>();

    public ZooLogic() {

        //customers list
        customer.add(new Customer("11", "sanjy", "Wheeler State", "19142"));
        customer.add(new Customer("12", "Moussa", "Simson Street", "19002"));
        customer.add(new Customer("13", "Sarangbe", "Idlelea drive", "43608"));
        

        //tickets list
        ticket.add(new Ticket(1, 1, 100, false));
        ticket.add(new Ticket(2, 2, 200, false));
        ticket.add(new Ticket(3, 3, 300, false));
       

    }

    public Customer getCustomer(String ssn) {

        for (int i = 0; i < customer.size(); i++) {

            if (customer.get(i).getSsn().equals(ssn)) {
                return customer.get(i);
            }

        }
        return null;
    }

    public List<Customer> getCustomers() {

        return customer;
    }

    public Ticket getRoom(int id) {

        for (int i = 0; i < ticket.size(); i++) {

            if (ticket.get(i).getRoomNumber() == id) {

                ticket.get(i).setIsBooked(true);
                return ticket.get(i);
            }

        }
        return null;
    }

    public List<Ticket> getRooms() {

        return ticket;
    }

    public List<Ticket> getAvailableRooms() {

        List<Ticket> avail = new ArrayList<>();

        for (int i = 0; i < ticket.size(); i++) {
            if (!ticket.get(i).isIsBooked()) {

                avail.add(ticket.get(i));

            }
        }

        return avail;
    }

    public Boolean addCustomer(Customer addCustomer) {

        customer.add(addCustomer);

        return true;
    }

    public Boolean addRoom(Ticket addRoom) {

        for (int i = 0; i < ticket.size(); i++) {

            if (ticket.get(i).getRoomNumber() == addRoom.getRoomNumber()) {

                return false;
            }
        }
        ticket.add(addRoom);

        return true;
    }
    
    public Boolean checkInCustomer(String ssn, Booking booking) {

        this.bookingList.add(booking);

        return true;
    }

        public Boolean checkOutCustomer(String ssn, int bookingId) {

        List<Ticket> tempTicketList = new ArrayList<>();
        for (int i = 0; i < bookingList.size(); i++) {

            if(bookingList.get(i).getBookingId() == bookingId){

                tempTicketList = bookingList.get(i).getRoomList();

            }



        }
            
           for (Ticket ticket1 : tempTicketList) {

            int num = ticket1.getRoomNumber();
            for (int i = 0; i < ticket.size(); i++) {
                if (num == ticket.get(i).getRoomNumber()) {
                    ticket.get(i).setIsBooked(false);
                }
            }

        }
        return true;         


  }

}
