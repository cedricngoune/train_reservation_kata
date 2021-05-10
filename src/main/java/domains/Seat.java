package domains;

import java.util.Objects;

public class Seat {

    private final int seatNumber;
    private final String coach;

    public Seat(int seatNumber, String coach) {

        this.seatNumber = seatNumber;
        this.coach = coach;
    }

    public int seatNumber() {
        return seatNumber;
    }
    public String coach() {
        return coach;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatNumber == seat.seatNumber && coach.equals(seat.coach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, coach);
    }
}
