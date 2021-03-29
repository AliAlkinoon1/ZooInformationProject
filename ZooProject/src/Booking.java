
import java.util.Date;
import java.util.List;

public class Booking {

    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private List<Ticket> roomList;

    public void Booking(int id, Date checkindate, Date checkoutdate, List<Ticket> rooms) {

        this.bookingId = id;
        this.checkInDate = checkindate;
        this.checkOutDate = checkoutdate;
        this.roomList = rooms;
        for (int i = 0; i < rooms.size(); i++) {
            this.totalPrice = this.totalPrice + rooms.get(i).getpricePerFlight();
        }

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Ticket> getRoomList() {
        return roomList;
    }

}



