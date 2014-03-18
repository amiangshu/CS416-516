import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateParser {

	public static Date parse(String dateToParse){
		//System.out.println(dateToParse);
		
		java.util.Date submitTime=new Date();
		
		String dateParts[] =dateToParse.split(",");
		
		String year=dateParts[1];
		String month=dateParts[0].trim().substring(0,3).toUpperCase();
		
		String dayParts[]=dateParts[0].split(" ");
		String day=dayParts[1].replaceAll("th|st|rd|nd", "").trim();
		
		if(dateParts[2].trim().compareTo("noon")==0)
			dateParts[2]="12:00 p.m.";
		else if(dateParts[2].trim().compareTo("midnight")==0)
			dateParts[2]="12:00 a.m.";
		
				
		String time[]= dateParts[2].trim().split(" ");
		
		String amPm=time[1].replace(".", "").toUpperCase();
		
		String timePart=time[0];
		
		if(timePart.indexOf(':')==-1)
			timePart+=":00";
			
		
		DateFormat formatter = new SimpleDateFormat("MMM d, yyyy hh:mm a");
		try {
			 submitTime= formatter.parse(month+" "+day+", "+year+" "+timePart+" "+amPm);
			
			//System.out.println(submitTime.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//System.out.println(format.format(submitTime));
		return submitTime;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateParser.parse("March 31, 2012, 12:53 a.m.");
	}
}
