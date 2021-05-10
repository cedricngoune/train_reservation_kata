package domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookingTest  {

    @Test
    void shouldGetRefusedReservationInformation() {
        assertThat(Booking.refused().seats()).isEmpty();
    }

    @Test
    void shouldGetBookingWithOneSeat() {
        assertThat(Booking.accepted(seat())
                .seats())
                .containsExactly(seat());
    }

    private Seat seat() {
        return new Seat(1, "A");
    }
}