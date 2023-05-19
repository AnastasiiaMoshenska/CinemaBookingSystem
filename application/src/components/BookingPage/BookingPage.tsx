import styles from './BookingPage.module.scss';
import {useEffect, useState} from "react";
import Seat from "../../model/Seat";
import {RestClient} from "../../rest-client/RestClient";
import SeatItem from "../SeatItem/SeatItem";
import {Link, useLocation, useNavigate} from "react-router-dom";

export default function BookingPage() {
    const [seats, setSeats] = useState<Array<Seat>>([]);
    const [chosenSeats, setChosenSeats] = useState<Array<Seat>>([]);
    const [clicks, setClicks] = useState(0);

    const location = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        RestClient.getSeats(location.state.movie.hall).then(
            seats => setSeats(seats)
        )
    }, [location.state.movie.hall]);

    const receiveClicks=(seatState: string, id: number)=>{
        seatState ? setClicks(clicks + 1) : setClicks(clicks - 1);
        setChosenSeats(chosenSeats => [...chosenSeats, seats.find(s => s.id === id)]);
    }

    const toConfirmation=()=>{
        RestClient.changeSeats(chosenSeats).then(
            ()=>{
                navigate('/confirmation', {state: {
                    id: location.state.movie.id,
                        title: location.state.movie.title,
                        date: location.state.movie.date
                    }})
            }
        )
    }

    return (
        <div className={styles.BookingPage}>
            <div className={styles.info}>
                <h1>{location.state.movie.title}</h1>
                <p>Hall:<span>{location.state.movie.hall}</span></p>
                <p>Date:<span>{location.state.movie.date.slice(0, 10)}</span></p>
                <p>Time:<span>{location.state.movie.date.slice(11, 16)}</span></p>
            </div>
            <div className={styles.seats__wrapper}>
                <div className={styles.seats__content}>
                    {seats.map((seat: Seat) => (
                        <SeatItem
                            key={seat.id}
                            seat={seat}
                            sendClick={receiveClicks}
                        />
                    ))}
                </div>
                <div className={styles.seats__selected}>
                    <p>Quantity:<span>{clicks} x {location.state.movie.price}</span>CHF</p>
                    <p>Total sum:<span>{location.state.movie.price * clicks}</span>CHF</p>
                    <div className={styles.buttons}>
                        <Link className={styles.cancel} to="/">Cancel</Link>
                        <button disabled={!clicks} onClick={toConfirmation} className={styles.book}>Book</button>
                    </div>
                </div>
            </div>
        </div>
    )
}
