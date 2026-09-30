void main() {
    record Lecture(String day, int hour, int minute, int duration) {
        int startTime24() {
            return 60 * hour + minute;
        }
        int endTime24() {
            return startTime24() + duration;
        }
        
        boolean overlaps(Lecture other) {
            if (!day.toLowerCase().equals(other.day.toLowerCase())) {
                return false;
            }
            // I would not have come up with this simple method by myself,
            // it was all AI.
            return startTime24() < other.endTime24()
                && other.startTime24() < endTime24();
        }
    }

    Lecture lecture1 = new Lecture("Monday", 9, 0, 60);
    Lecture lecture2 = new Lecture("Monday", 9, 30, 60);
    System.out.println(lecture1.overlaps(lecture2)); // true
    Lecture lecture3 = new Lecture("Monday", 10, 0, 60);
    System.out.println(lecture1.overlaps(lecture3)); // false


    // The following comment is entirely AI-generated:
    /*
     * Interesting overlap comparisons:
     * 1. Monday 9:00-10:00 and Monday 9:30-10:30 overlap at the beginning.
     * 2. Monday 9:30-10:30 and Monday 9:00-10:00 overlap at the end.
     * 3. Monday 9:00-12:00 and Monday 10:00-11:00 overlap because one is inside the other.
     * 4. Monday 10:00-11:00 and Monday 9:00-12:00 overlap for the same containment reason.
     * 5. Monday 9:00-10:00 and Monday 9:00-10:00 overlap exactly.
     * 6. Monday 9:00-10:00 and Monday 10:00-11:00 do not overlap because they only touch.
     * 7. Monday 9:00-10:00 and Monday 8:00-9:00 do not overlap because they only touch.
     * 8. Monday 9:00-10:00 and Tuesday 9:30-10:30 do not overlap because their days differ.
     * 9. monday 9:00-10:00 and Monday 9:30-10:30 overlap because day names ignore case.
     * 10. Monday 9:00-9:00 and Monday 9:00-10:00 do not overlap because the first lecture is empty.
     * 11. Monday 9:00-10:00 and Monday 8:30-9:30 overlap even though their start times differ.
     * 12. Monday 9:00-10:00 and Monday 9:15-9:45 overlap even though the second is shorter.
     *
     * I assume hour and minute describe a valid same-day 24-hour starting time, duration is
     * measured in minutes and is nonnegative, and intervals are half-open, so a lecture ending
     * at 10:00 does not overlap one beginning at 10:00. I also assume day names are compared
     * without regard to capitalization. An alternative design would store start and end times
     * as LocalTime values, or use a DayOfWeek and LocalTime pair, which would validate time
     * values more directly but would require more conversion and validation code here.
     */
}