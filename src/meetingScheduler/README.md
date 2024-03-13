**Requirement:**
- there are n given meeting rooms
- book a meeting in any given meeting room with some given capacity in (start time, end time)
  - meeting room should be available in that slot
  - no of people < capacity of meeting room
- send notification to all persons invited to the meeting
- use meeting room calendar to track the meetings date and time

**Go through the flow of setting up a meeting from start to end and identify models**:
- User wants to book a meeting with other users, meeting start time, meeting end time
  - Keeping time entity to today / unix time
- User will ask meeting scheduler to book a meeting amongst all available rooms
  - get all available meeting rooms for given start time, end time and asked capacity
  - select any room from the list and book the room
  - block the meeting room from start time to end time
- Send notification to all the invited people/other users


**Entities**:
1. User
2. MeetingRoom
3. Booking
4. MeetingRoomManager
5. MeetingScheduler
6. Notification
7. Calendar

User -> MeetingScheduler [cap, start time, end time] -> List<MeetingRoom> [select one] -> Booking -> Notification

**Model**:
1. MeetingInput
   - StartTime
   - EndTime
   - Capacity

```java
import java.util.Map;

class MeetingRoom {
    // is a dumb data class
    // assuming all meeting rooms are for your organisation
    int id;
    int capacity;
    Location location;
    boolean isFunctional;
}

class Location {
    int floorNo;
    int buildingNo;
}

class MeetingRoomManager { // manages all meeting rooms
    List<MeetingRoom> meetingRoomList;
    // CRUD for adding, removing, listing all MeetingRoom

    Map<MeetingRoom, Calendar> meetingRoomCalendar;
    // get all meeting rooms with given capacity and under given interval
    List<MeetingRoom> checkAvailability(TimeInterval queryInterval) {
        // loop meetingRoomList and find MeetingRoom with capacity
        // now with selected MeetingRoom, check in meetingRoomCalendar, if any booked time slot doesn't collide with asked time, then add this meetingRoom to answer
    }
}

class Calendar {
    List<TimeInterval> bookedIntervalList;
}

class TimeInterval {
    Day day;
    int startTime;
    int endTime; // unix
}

enum Day {
    SUNDAY,
    MONDAY, //... 
    SATURDAY
}

class MeetingScheduler {
    MeetingRoomManager meetingRoomManager;
    
}

```
https://leetcode.com/discuss/interview-question/490962/Design-Meeting-Scheduler
https://www.youtube.com/watch?v=oiPT284NzSs
