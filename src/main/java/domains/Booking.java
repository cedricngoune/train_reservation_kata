package domains;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Booking {
    private final Collection<Seat> seats;

    private Booking(Collection<Seat> seats) {
        this.seats = Collections.unmodifiableCollection(seats);
    }

    public static Booking refused() {
        return new Booking(List.of());
    }

    public static Booking accepted(Seat seat) {
        return new Booking(List.of(seat));

    }

    public static BookingBuilder accepted() {
        return new BookingBuilder();
    }

    public static Booking accepted(List<Seat> seats) {
        return new Booking(seats);
    }

    public Collection<Seat> seats() {
        return seats;
    }


    public static class BookingBuilder {
        private final Collection<Seat> seats = new HashSet<>();
        public BookingBuilder seat(Seat seat) {
            seats.add(seat);
            return this;
        }

        public Booking build() {
            return new Booking(seats);
        }
    }
}
