
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ZooApp {

    ZooLogic hotelLogic = new ZooLogic();
    Customer c;
    Booking booking = new Booking();

    public void showMenu() {

        Scanner getInput = new Scanner(System.in);
        boolean yORn = true;
        int getIndex;
        String ssn, name, add, tel;
        int roomNum, numOfBeds;
        double price;
        String isBook;

        while (yORn) {

            System.out.println("1.  Customer Details");
            System.out.println("2.  Customer List");

            System.out.println("3.  Ticket List");
            System.out.println("4.  Check Available Rooms");
            System.out.println("5.  Add Customer");
            System.out.println("6.  Add Ticket");
            System.out.println("7.  Checkin Customer");
            System.out.println("8.  Checkout Customer");
            System.out.println("9.  Remove Customer");
            System.out.println("10. Exit\n");
            System.out.print("Press num: ");

            getIndex = getInput.nextInt();

            System.out.println();

            switch (getIndex) {

                case 1:
/*
 * added
 */
                    System.out.print("Enter ssn number:");
                    String ssnum=getInput.next();
                    c = hotelLogic.getCustomer(ssnum);
                    System.out.println("Customer Details");
                    System.out.println("SSN: " + c.getSsn() + "\nName: " + c.getName() + "\nAddress: " + c.getAddress() + "\nTelephone: " + c.getTelephoneNumber());
                    System.out.println();
                    break;

                case 2:
                    List<Customer> list = hotelLogic.getCustomers();

                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Customer id: " + (i + 1));
                        System.out.println("SSN: " + list.get(i).getSsn() + "\nName: " + list.get(i).getName() + "\nAddress: " + list.get(i).getAddress() + "\nTelephone: " + list.get(i).getTelephoneNumber());
                        System.out.println();
                    }

                 break;



                case 3:

                    List<Ticket> roomlist = hotelLogic.getRooms();

                    for (int i = 0; i < roomlist.size(); i++) {

                        if (roomlist.get(i).isIsBooked()) {

                            isBook = "Booked";
                        } else {
                            isBook = "Available";
                        }
                        System.out.println("Ticket num: " + roomlist.get(i).getRoomNumber() + "\nNo of passengers: " + roomlist.get(i).getNumberOfBeds() + "\nPrice: " + roomlist.get(i).getpricePerFlight() + "\nRoom is: " + isBook);
                        System.out.println();
                    }

                    break;

                case 4:

                    List<Ticket> availRooms = hotelLogic.getAvailableRooms();

                    for (int i = 0; i < availRooms.size(); i++) {

                        System.out.println("Ticket num: " + availRooms.get(i).getRoomNumber() + "\nNo of Passengers: " + availRooms.get(i).getNumberOfBeds() + "\nPrice: " + availRooms.get(i).getpricePerFlight());
                        System.out.println();
                    }

                    break;

                case 5:

                    System.out.print("Enter SSN: ");

                    ssn = getInput.next();
                    System.out.print("\nEnter Name: ");

                    name = getInput.next();
                    System.out.print("\nEnter Address: ");

                    add = getInput.next();
                    System.out.print("\nEnter Telephone: ");

                    tel = getInput.next();

                    if (hotelLogic.addCustomer(new Customer(ssn, name, add, tel))) {
                        System.out.println("\nCustomer Add successfully\n");
                    }

                    break;

                case 6:

                    System.out.print("Enter Ticket number: ");

                    roomNum = getInput.nextInt();
                    System.out.print("\nEnter no of Passengers: ");

                    numOfBeds = getInput.nextInt();
                    System.out.print("\nEnter price per Passengers: ");

                    price = getInput.nextDouble();

                    if (hotelLogic.addRoom(new Ticket(roomNum, numOfBeds, price, false))) {
                        System.out.println("\nTicket Add successfully\n");
                    } else {
                        System.out.println("\nTicket number already exists\n");
                    }

                    break;

                case 7:
                    
                    boolean a = true;
                    int counter = 0;

                    System.out.print("Enter customer SSN: ");

                    String s = getInput.next();
                    c = hotelLogic.getCustomer(s);

                    List<Ticket> roomList2 = new ArrayList<>(),
                            rooms = hotelLogic.getAvailableRooms();

                    while (a) {
                        if (rooms.size() > 0) {
                            for (int i = 0; i < rooms.size(); i++) {

                                System.out.println("Ticket num: " + rooms.get(i).getRoomNumber() + "\nNo of Passengers: " + rooms.get(i).getNumberOfBeds() + "\nPrice: " + rooms.get(i).getpricePerFlight());
                                System.out.println();

                            }

                            System.out.print("Enter Ticket number: ");

                            int num = getInput.nextInt();

                            for (int i = 0; i < rooms.size(); i++) {

                                if (num == rooms.get(i).getRoomNumber()) {
                                    roomList2.add(hotelLogic.getRoom(num));
                                    rooms.remove(i);
                                    System.out.println("\nTicket added successfully\n");
                                    counter++;
                                    break;
                                }
                            }

                            if (counter == 0) {
                                System.out.println("\nWrong ticket number added");
                            }
                            System.out.print("do you want to add more ticket? press y/n: ");

                            if (!getInput.next().equalsIgnoreCase("y")) {

                                a = false;
                            }
                            counter = 0;
                        } else {

                            a = false;
                            System.out.println("No ticket available");

                        }
                    }

                    System.out.println("Enter checkin date DD-MM-YYYY");
                    String[] checkindate = String.valueOf(getInput.next()).split("-");
                    System.out.println("Enter checkout date DD-MM-YYYY");
                    String[] checkoutdate = String.valueOf(getInput.next()).split("-");
                    booking.Booking(Integer.parseInt(c.getSsn()), new Date(Integer.parseInt(checkindate[2]), (Integer.parseInt(checkindate[1]) - 1), Integer.parseInt(checkindate[0])), new Date(Integer.parseInt(checkoutdate[2]), (Integer.parseInt(checkoutdate[1]) - 1), Integer.parseInt(checkoutdate[0])), roomList2);

                    if (hotelLogic.checkInCustomer(c.getSsn(), booking)) {
                        System.out.println("Booking success!\n");
                    }

                    break;

               case 8:

                    System.out.println("Enter SSN");
                    String ssnum1 = getInput.next();
                    System.out.println("Enter Booking (Note Booking id is same as SSN)");
                    int bookingId = getInput.nextInt();
                    c = hotelLogic.getCustomer(ssnum1);
                    hotelLogic.checkOutCustomer(c.getSsn(), bookingId);

                    break; 
                    
                case 9:
                	 /*System.out.print("Enter ssn number:");
                     String ssnum3=getInput.next();
                     c = hotelLogic.getCustomer(ssnum3);*/
                     System.out.println("do u want to remove the customer");
                     System.out.println("which customer r u want to remove enter the ssn number");
                     String ddlssn=getInput.next();
                     List<Customer> list1 = hotelLogic.getCustomers();
                     
                     for (int i = 0; i < list1.size(); i++)
                     {
                        System.out.println("Customer id: " + (i + 1));
                         if(list1.get(i).getSsn().equals(ddlssn) )
                		 {
                        	 list1.remove(ddlssn);
                         System.out.println("SSN: " + list1.get(i).getSsn() + "\nName: " + list1.get(i).getName() + "\nAddress: " + list1.get(i).getAddress() + "\nTelephone: " + list1.get(i).getTelephoneNumber());
                         System.out.println("customer is remove successfully");
                         System.out.println("=====================================================");
                     }
                         else
                         {
                        	  System.out.println("SSN1: " + list1.get(i).getSsn() + "\nName1: " + list1.get(i).getName() + "\nAddress1: " + list1.get(i).getAddress() + "\nTelephone1: " + list1.get(i).getTelephoneNumber());
                             // System.out.println("customer is remove successfully");
                         }
                       //  System.out.println("remaining customers============================");
                     }

                  /*   if(c.getSsn()==ddlssn ||c.getSsn().equals(ddlssn))
                    		 {
                    	  rooms.remove(ddlssn);*/
                   /*  System.out.println("Customer Details");
                     System.out.println("SSN: " + c.getSsn() + "\nName: " + c.getName() + "\nAddress: " + c.getAddress() + "\nTelephone: " + c.getTelephoneNumber());
                    		 }
                     System.out.println();*/
                     break;
                    
                case 10:

                    yORn = false;
                    break;

            }

        }

    }

    public static void main(String[] args) {
    	Scanner s=new Scanner(System.in);
        System.out.println("--------------------\n");
        System.out.println("Welcome to Zoo Information \n");
        System.out.println("--------------------\n");
        System.out.println("Enter the Username and password");
        String userName=s.next();
        String pwd=s.next();
        if(userName.equals(pwd))
        {
        	System.out.println("login successfully");
        	 System.out.println("Zoo Menu\n");
        	ZooApp app = new ZooApp();
            app.showMenu();
        }
        else
        {
        	System.out.println("\nWrong  credentials");
        }
       
   //     HotelApp app = new HotelApp();
    //    app.showMenu();

    }

}
