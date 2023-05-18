import Movie from "../model/Movie";
import Seat from "../model/Seat";

export class RestClient{
    static baseUrl = "http://localhost:8080"

    static async getMovies(): Promise<Movie[]>{
        const url = `${RestClient.baseUrl}/movies`;
        const response = await fetch(url);
        return await response.json();
    }

    static async getSeats(hall: number): Promise<Seat[]>{
        const url = `${RestClient.baseUrl}/seats?hall=${hall}`;
        const response = await fetch(url);
        return await response.json();
    }
}