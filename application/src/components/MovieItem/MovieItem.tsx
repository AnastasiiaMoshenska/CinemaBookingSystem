import React from 'react';
import styles from './MovieItem.module.scss';
import {useNavigate} from 'react-router-dom'

export default function MovieItem(props: any){
    const navigate = useNavigate();

    const toBooking=()=>{
        navigate('/booking', {state: props});
    }

    return(
        <div className={styles.Movie}>
            <img src={props.movie.imgPath} alt="img"/>
            <div className={styles.description}>
                <div className={styles.description__item}>
                    <p className={styles.title}>Title:</p>
                    <p className={styles.data}>{props.movie.title}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Age:</p>
                    <p className={styles.data}>{props.movie.age}+</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Genre:</p>
                    <p className={styles.data}>{props.movie.genre}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Description:</p>
                    <p className={styles.data + " " + styles.description}>{props.movie.description}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Date:</p>
                    <p className={styles.data}>{props.movie.date.slice(0, 10)}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Time:</p>
                    <p className={styles.data}>{props.movie.date.slice(11, 16)}</p>
                </div>
            </div>
            <button onClick={()=>{toBooking()}}>Book</button>
        </div>
    )
}
