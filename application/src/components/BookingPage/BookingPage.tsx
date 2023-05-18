import styles from './BookingPage.module.scss';
import {useEffect, useState} from "react";
import Seat from "../../model/Seat";
import {RestClient} from "../../rest-client/RestClient";
import SeatItem from "../SeatItem/SeatItem";
import {useLocation} from "react-router-dom";

export default function BookingPage() {
    const [seats, setSeats] = useState<Array<Seat>>([])

    const location = useLocation();

    useEffect(() => {
        RestClient.getSeats(location.state.movie.hall).then(
            seats => setSeats(seats)
        )
    }, [location.state.movie.hall]);

    return (
        <div className={styles.BookingPage}>
            <div className={styles.seats__content}>
                {seats.map((seat: Seat) => (
                    <SeatItem
                        key = {seat.id}
                        seat = {seat}
                    />
                ))}
            </div>
        </div>
    )
}
