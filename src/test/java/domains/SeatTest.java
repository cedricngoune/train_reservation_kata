package domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeatTest {

    @Test
    void shoudlGetSeatInformation() {
        Seat seatLord = new Seat(42, "B");
        assertThat(seatLord.seatNumber()).isEqualTo(42);
        assertThat(seatLord.coach()).isEqualTo("B");
    }
}