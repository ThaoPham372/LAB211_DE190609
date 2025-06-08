package quizz_5.reservationManagement;

public class Reservation {
  private String bookingID;
  private String customerName;
  private String phoneNumber;
  private String roomNumber;
  private String bookingDate;
  private FlightInformation flightInfo;

  // Default constructor
  public Reservation() {
    this.bookingID = "";
    this.customerName = "";
    this.phoneNumber = "";
    this.roomNumber = "";
    this.bookingDate = "";
    this.flightInfo = new FlightInformation();
  }

  // Parameterized constructor
  public Reservation(String bookingID, String customerName, String phoneNumber, String roomNumber, String bookingDate,
      FlightInformation flightInfo) {
    this.bookingID = bookingID;
    this.customerName = customerName;
    this.phoneNumber = phoneNumber;
    this.roomNumber = roomNumber;
    this.bookingDate = bookingDate;
    this.flightInfo = flightInfo;
  }

  // Getters and Setters
  public String getBookingID() {
    return bookingID;
  }

  public void setBookingID(String bookingID) {
    this.bookingID = bookingID;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
  }

  public FlightInformation getFlightInfo() {
    return flightInfo;
  }

  public void setFlightInfo(FlightInformation flightInfo) {
    this.flightInfo = flightInfo;
  }

  // Table header
  public static String getHeader() {
    return String.format("%-6s | %-20s | %-12s | %-6s | %-16s | %s",
        "ID", "Name", "Phone", "Room", "BookingDate", FlightInformation.getHeader());
  }

  // Table row
  @Override
  public String toString() {
    return String.format("%-6s | %-20s | %-12s | %-6s | %-16s | %s",
        bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInfo.toString());
  }
}
