import Movie from "../model/Movie";

export class RestClient{
    static baseUrl = "http://localhost:8080"

    static async getMovies(): Promise<Movie[]>{
        const url = `${RestClient.baseUrl}/movies`;
        const response = await fetch(url);
        return await response.json();
    }
}