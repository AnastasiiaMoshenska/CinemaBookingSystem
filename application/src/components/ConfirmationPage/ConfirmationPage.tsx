import styles from './ConfirmationPage.module.scss';
import {Link, useLocation} from "react-router-dom";
import {useState} from "react";

export default function ConfirmationPage(){
    const location = useLocation();
    const [bookingNumber] = useState(Math.floor(100000000 + Math.random() * 900000000));

    return(
        <div className={styles.ConfirmationPage}>
            <p>Thank you for your booking for <span>{location.state.title}</span></p>
            <p>You booking number is <span>{bookingNumber}</span></p>
            <p className={styles.load}>...</p>
            <a className={styles.qr} href={`https://www.qr-code-generator.com/${bookingNumber}`}>
                <img src={`https://chart.googleapis.com/chart?cht=qr&chl=${bookingNumber}&chs=180x180&choe=UTF-8&chld=L|2`} alt="QR Code" />
            </a>
            <Link className={styles.book} to="/">Book more!</Link>
        </div>
    )
}