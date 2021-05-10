package domains;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainTest {

    @Test
    void shouldNotBookOnFullTrain(){
        assertThat(new Train(List.of()).book(1))
                .usingRecursiveComparison()
                .isEqualTo(Booking.refused());
    }
    @Test
    void canBookOneSeatOnTrainWithMoreThanEnoughAvailableSeats() {
        assertThat(trainOfLife().book(1))
                .usingRecursiveComparison()
                .isEqualTo(Booking.accepted(
                new Seat(1, "A")
        ));
    }
    @Test
    void canBookTwoSeatOnTrainWithMoreThanEnoughAvailableSeats() {
        Train train = trainOfLife();
        assertThat(train.book(2))
                .usingRecursiveComparison()
                .isEqualTo(Booking.accepted().seat(new Seat(1, "A"))
                        .seat(new Seat(2,"A"))
                        .build());
    }

    @Test
    void canNotBookSameSiteTwice(){
        Train train = trainOfLife();
        train.book(1);
        assertThat(train.book(1))
                .usingRecursiveComparison()
                .isEqualTo(Booking.accepted(
                        new Seat(2, "A")
                ));
    }

    @Test
    void canNotBookOverSeventyPercentOfACoachWhenOnlyCoachIsAvailable() {
        Train train = new Train(seats(10));

        //TODO implements the 70% train rule

        // TODO add the SLot notion business
    }
    private Train trainOfLife() {
        return new Train(seats(42));
    }

    private static List<Seat> seats(int count) {
        return IntStream.range(1, 15).mapToObj(seatNumber ->
                new Seat(seatNumber, "A"))
                .collect(Collectors.toList());
    }
}
