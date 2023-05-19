import styles from './SeatItem.module.scss';
import {useState} from "react";

export default function SeatItem(props: any) {
    const [isActive, setIsActive] = useState(false);
    const handleClick = () => {
        setIsActive(current => !current);
    }

    return (
        <div
            className={isActive && props.seat.status == "free" ? styles.clicked + " " + styles.SeatItem : (props.seat.status == "free" ? styles.SeatItem : styles.booked + " " + styles.SeatItem)}
            onClick={() => props.sendClick(!isActive, props.seat.id)}>
            <div onClick={handleClick}>
                <img src="src/assets/seat.svg" alt="seat"/>
                <span className={styles.number}>{props.seat.id}</span>
            </div>
        </div>
    )
}
