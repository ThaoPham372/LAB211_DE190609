package quizz_5.reservationManagement;

public class FlightInformation {
  private String flightNumber;
  private String seatNumber;
  private String timePickUp; // Use String for simplicity

  // Default constructor
  public FlightInformation() {
    this.flightNumber = "";
    this.seatNumber = "";
    this.timePickUp = "";
  }

  // Parameterized constructor
  public FlightInformation(String flightNumber, String seatNumber, String timePickUp) {
    this.flightNumber = flightNumber;
    this.seatNumber = seatNumber;
    this.timePickUp = timePickUp;
  }

  // Getters and Setters
  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public String getTimePickUp() {
    return timePickUp;
  }

  public void setTimePickUp(String timePickUp) {
    this.timePickUp = timePickUp;
  }

  // Table header
  public static String getHeader() {
    return String.format("%-8s | %-6s | %-16s", "Flight", "Seat", "TimePickUp");
  }

  // Table row
  @Override
  public String toString() {
    return String.format("%-8s | %-6s | %-16s", flightNumber, seatNumber, timePickUp);
  }
}
