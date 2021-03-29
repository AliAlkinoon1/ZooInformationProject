
public class Ticket {

    private int ticketNumber;
    private int numberOfBeds;
    private double pricePerFlight;
    private boolean isBooked;

    public Ticket(int ticketNumber, int numberOfBeds, double pricePerFlight, boolean isBooked) {
        this.ticketNumber = ticketNumber;
        this.numberOfBeds = numberOfBeds;
        this.pricePerFlight = pricePerFlight;
        this.isBooked = isBooked;
    }

    public int getRoomNumber() {
        return ticketNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.ticketNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getpricePerFlight() {
        return pricePerFlight;
    }

    public void setPricePerNight(double pricePerFlight) {
        this.pricePerFlight = pricePerFlight;
    }

    public boolean isIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

}


