import React from 'react';
import styles from './MovieItem.module.scss';

export default function MovieItem(props: any){
    console.log(props.movie.id)
    //TODO check how many times it renders
    return(
        <div className={styles.Movie}>
            <img alt="img"/>
            <div className={styles.description}>
                <div className={styles.description__item}>
                    <p className={styles.title}>Title:</p>
                    <p className={styles.data}>{props.movie.title}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Age:</p>
                    <p className={styles.data}>{props.movie.age}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Genre:</p>
                    <p className={styles.data}>{props.movie.genre}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Description:</p>
                    <p className={styles.data}>{props.movie.description}</p>
                </div>

                <div className={styles.description__item}>
                    <p className={styles.title}>Date & Time:</p>
                    <p className={styles.data}>{props.movie.date}</p>
                </div>
            </div>
            <button>Book</button>
        </div>
    )
}
