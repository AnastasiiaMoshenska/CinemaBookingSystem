import styles from './SeatItem.module.scss';

export default function SeatItem(props: any){
    return(
        <div className={styles.SeatItem}>
            <img src="src/assets/seat.svg" onLoad="SVGInject(this)" alt="seat"/>
            <span className={styles.number}>{props.seat.id}</span>
        </div>
    )
}
