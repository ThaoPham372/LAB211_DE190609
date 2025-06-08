package quizz_5.reservationManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationManager {
  private ArrayList<Reservation> reservations = new ArrayList<>();
  private Scanner sc = new Scanner(System.in);

  public void run() {
    while (true) {
      System.out.println("*** Reservation Management ***");
      System.out.println("1. Create new reservation");
      System.out.println("2. Update reservation");
      System.out.println("3. Delete reservation");
      System.out.println("4. Print Flight Information");
      System.out.println("5. Print all");
      System.out.println("6. Exit");
      System.out.print("You choose: ");
      String choice = sc.nextLine();
      switch (choice) {
        case "1":
          createReservation();
          break;
        case "2":
          updateReservation();
          break;
        case "3":
          deleteReservation();
          break;
        case "4":
          printFlightInfo();
          break;
        case "5":
          printAll();
          break;
        case "6":
          System.out.println("BYE AND SEE YOU NEXT TIME");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  // Helper to find reservation by ID
  private Reservation findReservationByID(String id) {
    for (Reservation r : reservations) {
      if (r.getBookingID().equals(id))
        return r;
    }
    return null;
  }

  // 1. Create new reservation
  private void createReservation() {
    System.out.println("*** Create new reservation ***");
    String id;
    while (true) {
      System.out.print("ID (6 digits): ");
      id = sc.nextLine();
      if (!Validation.isValidID(id) || findReservationByID(id) != null) {
        System.out.println("Data input is invalid");
      } else {
        break;
      }
    }

    String name;
    while (true) {
      System.out.print("Name (alphabet and blanks): ");
      name = sc.nextLine();
      if (!Validation.isValidName(name)) {
        System.out.println("Data input is invalid");
      } else {
        break;
      }
    }

    String phone;
    while (true) {
      System.out.print("Phone (12 digits): ");
      phone = sc.nextLine();
      if (!Validation.isValidPhone(phone)) {
        System.out.println("Data input is invalid");
      } else {
        break;
      }
    }

    String room;
    while (true) {
      System.out.print("RoomNumbers(4 digits): ");
      room = sc.nextLine();
      if (!Validation.isValidRoom(room)) {
        System.out.println("Data input is invalid");
      } else {
        break;
      }
    }

    String bookingDate = "";
    boolean validTime = false;

    while (!validTime) {
      // Ask user to enter booking date
      System.out.print("Enter booking date (dd/MM/yyyy): ");
      bookingDate = sc.nextLine();

      // Check if input is empty
      if (bookingDate.isEmpty()) {
        System.out.println("Please enter a date!");
        continue;
      }

      try {
        // Create a date formatter
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Convert input string to date
        Date inputDate = dateFormat.parse(bookingDate);

        // Get current date
        Date currentDate = new Date();

        // Check if date is in the future
        if (inputDate.after(currentDate)) {
          validTime = true;
          System.out.println("Date accepted!");
        } else {
          System.out.println("Please enter a future date!");
        }

      } catch (ParseException e) {
        System.out.println("Wrong format! Use dd/MM/yyyy (example: 22/12/2024)");
      }
    }

    // Flight info
    FlightInformation flightInfo = new FlightInformation();
    String needPickUp;
    while (true) {
      System.out.print("Need airport pick up? (Y/N): ");
      needPickUp = sc.nextLine();
      if (needPickUp.equalsIgnoreCase("Y") || needPickUp.equalsIgnoreCase("N")) {
        break;
      } else {
        System.out.println("Data input is invalid");
      }
    }
    if (needPickUp.equalsIgnoreCase("Y")) {
      String flight, seat, timePickUp;
      while (true) {
        System.out.print("Flight: ");
        flight = sc.nextLine();
        if (flight.isEmpty()) {
          System.out.println("Data input is invalid");
        } else {
          break;
        }
      }
      while (true) {
        System.out.print("Seat: ");
        seat = sc.nextLine();
        if (seat.isEmpty()) {
          System.out.println("Data input is invalid");
        } else {
          break;
        }
      }
      while (true) {
        System.out.print("TimePickUp (dd/MM/yyyy): ");
        timePickUp = sc.nextLine();
        if (timePickUp.isEmpty()) {
          System.out.println("Data input is invalid");
          continue;
        }

        try {
          // Create a date formatter
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

          // Convert input string to date
          Date pickupDate = dateFormat.parse(timePickUp);

          // Get current date
          Date currentDate = new Date();

          // Get booking date
          Date bookingDateObj = dateFormat.parse(bookingDate);

          // Check if pickup date is between current date and booking date
          if (pickupDate.after(currentDate) && pickupDate.before(bookingDateObj)) {
            flightInfo = new FlightInformation(flight, seat, timePickUp);
            break;
          } else if (!pickupDate.after(currentDate)) {
            System.out.println("Pickup date must be after current date!");
          } else {
            System.out.println("Pickup date must be before booking date!");
          }
        } catch (ParseException e) {
          System.out.println("Wrong format! Use dd/MM/yyyy (example: 22/12/2024)");
        }
      }
    }

    Reservation r = new Reservation(id, name, phone, room, bookingDate, flightInfo);
    reservations.add(r);
    System.out.println("Information saved successfully.");
  }

  // 2. Update reservation
  private void updateReservation() {
    System.out.println("*** Update reservation ***");
    System.out.print("bookingID: ");
    String id = sc.nextLine();
    Reservation r = findReservationByID(id);
    if (r == null) {
      System.out.println("No information found");
      return;
    }
    System.out.println(Reservation.getHeader());
    System.out.println(r);

    System.out.print("Name (" + r.getCustomerName() + "): ");
    String name = sc.nextLine();
    if (!name.isEmpty() && Validation.isValidName(name))
      r.setCustomerName(name);

    System.out.print("Phone (" + r.getPhoneNumber() + "): ");
    String phone = sc.nextLine();
    if (!phone.isEmpty() && Validation.isValidPhone(phone))
      r.setPhoneNumber(phone);

    System.out.print("RoomNumbers (" + r.getRoomNumber() + "): ");
    String room = sc.nextLine();
    if (!room.isEmpty() && Validation.isValidRoom(room))
      r.setRoomNumber(room);

    System.out.print("BookingDate (" + r.getBookingDate() + "): ");
    String bookingDate = sc.nextLine();
    if (!bookingDate.isEmpty())
      r.setBookingDate(bookingDate);

    // Update flight info
    System.out.print("Need airport pick up? (Y/N): ");
    String needPickUp;
    while (true) {
      needPickUp = sc.nextLine().trim();
      if (needPickUp.equalsIgnoreCase("Y") || needPickUp.equalsIgnoreCase("N")) {
        break;
      } else {
        System.out.println("Data input is invalid");
      }
    }
    if (needPickUp.equalsIgnoreCase("Y")) {
      System.out.print("Flight (" + r.getFlightInfo().getFlightNumber() + "): ");
      String flight = sc.nextLine();
      if (!flight.isEmpty())
        r.getFlightInfo().setFlightNumber(flight);

      System.out.print("Seat (" + r.getFlightInfo().getSeatNumber() + "): ");
      String seat = sc.nextLine();
      if (!seat.isEmpty())
        r.getFlightInfo().setSeatNumber(seat);

      System.out.print("TimePickUp (" + r.getFlightInfo().getTimePickUp() + "): ");
      String timePickUp = sc.nextLine();
      if (!timePickUp.isEmpty())
        r.getFlightInfo().setTimePickUp(timePickUp);
    }
    System.out.println("Information updated successfully.");
  }

  // 3. Delete reservation
  private void deleteReservation() {
    System.out.println("*** Delete reservation ***");
    System.out.print("bookingID: ");
    String id = sc.nextLine();
    Reservation r = findReservationByID(id);
    if (r == null) {
      System.out.println("No information found");
      return;
    }
    System.out.println(Reservation.getHeader());
    System.out.println(r);
    System.out.print("Are you sure you want to delete this information? (Y/N): ");
    String confirm = sc.nextLine();
    if (confirm.equalsIgnoreCase("Y")) {
      reservations.remove(r);
      System.out.println("Information deleted successfully.");
    } else {
      System.out.println("Delete cancelled.");
    }
  }

  // 4. Print Flight Information
  private void printFlightInfo() {
    System.out.println("** Flight Information ***");
    System.out
        .println(String.format("%-6s | %-20s | %-12s | %s", "ID", "Name", "Phone", FlightInformation.getHeader()));
    for (Reservation r : reservations) {
      System.out.println(String.format("%-6s | %-20s | %-12s | %s",
          r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(), r.getFlightInfo().toString()));
    }
  }

  // 5. Print all reservations
  private void printAll() {
    if (reservations.isEmpty()) {
      System.out.println("No information to view");
      return;
    }
    System.out.println("*** Reservation Information ***");
    System.out.println(Reservation.getHeader());
    for (Reservation r : reservations) {
      System.out.println(r);
    }
  }
}
