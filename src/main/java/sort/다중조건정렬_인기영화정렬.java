package sort;

import java.util.*;

public class 다중조건정렬_인기영화정렬 {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static String data = "spy,ray,spy,room,once,ray,spy,once";
    static String[] dataArray = data.split(",");

    static class Movie {
        String movie;
        Integer count;

        public Movie(String movie, Integer count) {
            this.movie = movie;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < dataArray.length; i++) {
            String key = dataArray[i];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key)+1);
            } else {
                hashMap.put(key, 1);
            }
        }

        hashMap.forEach((key, value)->{movieList.add(new Movie(key, value));});



        movieList.forEach(s->System.out.println(  s.movie +s.count));
        Collections.sort(movieList, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.count < o2.count) {
                    return -1;
                } else if (o1.count > o2.count) {
                    return 1;
                } else {
                    return o1.movie.compareTo(o2.movie);
                }
            }
        });
        for (Movie m : movieList) {
            System.out.println(m.movie + " : " +m.count);
        }
    }
}


