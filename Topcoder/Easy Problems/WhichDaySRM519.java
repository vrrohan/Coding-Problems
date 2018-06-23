/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=11553
Problem Statement
        This week there will be an important meeting of your entire department. You clearly remember your boss telling you about it. 
        The only thing you forgot is the day of the week when the meeting will take place.
You asked six of your colleagues about the meeting. None of them knew the day when it will take place, but each of them remembered one day when it will not take place. 
The days they remembered were distinct. For a clever programmer like you, this was enough to determine the day of the meeting.
You are given a String[] notOnThisDay containing six weekdays when the meeting will not take place. Return the weekday of the meeting.
 
Definition        
Class:  WhichDay
Method: getDay
Parameters: String[]
Returns:    String
Method signature:   String getDay(String[] notOnThisDay)
(be sure your method is public)
     
Notes
-   There are seven weekdays. Their names are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday".
 
Constraints
-   notOnThisDay will contain exactly 6 elements.
-   Each element of notOnThisDay will be a name of a weekday (in the exact form specified in the Note above).
-   No two elements of notOnThisDay will be equal.
 
Examples
0)  {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}
Returns: "Saturday"

1)  {"Sunday", "Monday", "Tuesday", "Wednesday", "Friday", "Thursday"}
Returns: "Saturday"

2)  {"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"}
Returns: "Wednesday"

3)  {"Sunday", "Friday", "Tuesday", "Wednesday", "Monday", "Saturday"}
Returns: "Thursday"
*/

import java.util.*;
public class WhichDay {
    static String getDay(String[] notOnThisDay) {
        ArrayList<String> weekDays = new ArrayList<String>() {
            {   add("Sunday"); add("Monday"); add("Tuesday"); add("Wednesday"); add("Thursday"); add("Friday"); add("Saturday"); }
        };

        List<String> notThisDayList = Arrays.asList(notOnThisDay);
        String missingDay="";

        for(int i=0; i<weekDays.size(); i++) {
            if(!notThisDayList.contains(weekDays.get(i))) {   missingDay=weekDays.get(i);   break;   }
        }
        return missingDay;
    }

    public static void main(String[] args) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"};
        System.out.println("weekday of meeting is : " + getDay(days));

        String[] days2 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println("weekday of meeting is : " + getDay(days2));

        String[] days3 = {"Sunday", "Friday", "Tuesday", "Wednesday", "Monday", "Saturday"};
        System.out.println("weekday of meeting is : " + getDay(days3));        
    }
}
