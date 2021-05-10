package domains;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Train {

    private final Deque<Seat> availableSeats;

    public Train(List<Seat> availableSeats) {
        this.availableSeats = new ArrayDeque<>(availableSeats);
    }

    public Booking book(int seats) {
        if(availableSeats.size() < seats) {
            return Booking.refused();
        }
        Booking.BookingBuilder booking = Booking.accepted();
        IntStream.range(0, seats).forEach(number -> booking.seat(availableSeats.pop()));
        return booking .build();


    }

}
