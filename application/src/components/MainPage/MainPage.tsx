import React from 'react';
import styles from './MainPage.module.scss';
import Movie from "../../model/Movie";
import {RestClient} from "../../rest-client/RestClient";
import MovieItem from "../MovieItem/MovieItem";
export default function MainPage() {
    const [movies, setMovies] = React.useState<Array<Movie>>([]);

    React.useEffect(
        () => {
            RestClient.getMovies().then(
                movies => setMovies(movies)
        )
        }, []
    );

    return (
        <div className={styles.MainPage}>
            <h1>Cinema</h1>
            <div className={styles.wrapper}>
            {movies.map((movie: Movie) => (
                <MovieItem
                    key = {movie.id}
                    movie={movie}
                ></MovieItem>
            ))}
        </div>
        </div>
    )
}

