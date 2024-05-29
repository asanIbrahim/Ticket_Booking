package busResv;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
   String passengerName;
   int busNo;
   Date date;
   
   Booking(){
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("Enter the Name of the PassengerName: ");
	   passengerName = scanner.next();
	   System.out.println("Enter bus no: ");
	   busNo= scanner.nextInt();
	   System.out.println("Enter the dd-mm-yyddyy");
	   String dateInput = scanner.next();
	   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyddyy");
	   try {
	   date =  dateFormat.parse(dateInput);
	   }catch (ParseException e){
		   e.printStackTrace();
	   }
   }

public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
	int capacity = 0;
	for(Bus bus:buses) {
		if(bus.getBusNo() == busNo) {
			capacity = bus.getCapacity();
			}
		}
	int booked = 0;
	for(Booking b:bookings) {
		if(b.busNo == busNo && b.date.equals(date)) {
			booked++;
		}
	}
	
	return booked < capacity ? true : false;  
}
   
   
   
}
