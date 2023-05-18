import styles from './SeatItem.module.scss';

export default function SeatItem(props: any){
    return(
        <div className={styles.SeatItem}>
            {props.seat.id}
        </div>
    )
}
