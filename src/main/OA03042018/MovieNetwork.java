package main.OA03042018;

import java.util.*;

public class MovieNetwork {
    public static void main(String[] args) {
        MovieNetwork mn = new MovieNetwork();
        Movie a = new Movie(1, 2.0f);
        Movie b = new Movie(2, 2.1f);
        Movie c = new Movie(3, 2.2f);
        Movie d = new Movie(4, 2.2f);
        Movie e = new Movie(5, 5f);
        Movie f = new Movie(6, 2.7f);
        Movie g = new Movie(7, 2.9f);
        Movie h = new Movie(8, 3.1f);
        Movie i = new Movie(9, 2.1f);
        Movie j = new Movie(10, 7.1f);

        a.similarMovies.add(c);
        a.similarMovies.add(b);
        a.similarMovies.add(g);
        a.similarMovies.add(h);
        a.similarMovies.add(e);

        b.similarMovies.add(a);
        b.similarMovies.add(j);
        b.similarMovies.add(f);

        e.similarMovies.add(b);
        e.similarMovies.add(d);
        e.similarMovies.add(e);
        e.similarMovies.add(f);

        g.similarMovies.add(h);
        g.similarMovies.add(i);
        g.similarMovies.add(j);

        f.similarMovies.add(c);
        f.similarMovies.add(e);
        f.similarMovies.add(g);
        f.similarMovies.add(h);
        f.similarMovies.add(j);

        d.similarMovies.add(e);
        c.similarMovies.add(a);
        h.similarMovies.add(f);
        h.similarMovies.add(a);
        for (Movie m : mn.findKMovies(a, 4)) {
            System.out.println(m);
        }
    }

    public List<Movie> findKMovies(Movie movie, int k) {
        List<Movie> list = new ArrayList<>();
        if (k == 0) {
            return list;
        }

        PriorityQueue<Movie> pq = new PriorityQueue<Movie>(k, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return (m1.rating - m2.rating) > 0 ? 1 : -1;
            }
        });

        Queue<Movie> queue = new LinkedList<>();
        Set<Movie> set = new HashSet<>();
        for (Movie similar : movie.similarMovies) {
            if (!set.contains(similar)) {
                queue.offer(similar);
                set.add(similar);
            }
        }

        while (!queue.isEmpty()) {
            Movie tmp = queue.poll();
            if (pq.size() < k) {
                pq.add(tmp);
            } else {
                if (tmp.rating > pq.peek().rating) {
                    pq.poll();
                    pq.add(tmp);
                }
            }
            for (Movie m : tmp.similarMovies) {
                if (!set.contains(m)) {
                    queue.offer(m);
                    set.add(m);
                }
            }
        }

        while (pq.isEmpty()) {
            list.add(pq.poll());
        }

        return list;
    }
}

class Movie {
    int movieId;
    float rating;
    List<Movie> similarMovies;
    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        this.similarMovies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.movieId + " " + this.rating;
    }
}
