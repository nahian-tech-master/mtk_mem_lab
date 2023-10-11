import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSPNearestNeighbor {
    public static List<Integer> nearestNeighbor(int[][] distances) {
        int numCities = distances.length;
        boolean[] visited = new boolean[numCities];
        List<Integer> tour = new ArrayList<>();
        
        // Start from the first city (index 0)
        int currentCity = 0;
        visited[currentCity] = true;
        tour.add(currentCity);
        
        for (int i = 1; i < numCities; i++) {
            int nearestCity = findNearestCity(currentCity, visited, distances);
            visited[nearestCity] = true;
            tour.add(nearestCity);
            currentCity = nearestCity;
        }
        
        // Return to the starting city to complete the tour
        tour.add(tour.get(0));
        
        return tour;
    }

    public static int findNearestCity(int currentCity, boolean[] visited, int[][] distances) {
        int nearestCity = -1;
        int minDistance = Integer.MAX_VALUE;
        int numCities = distances.length;
        
        for (int city = 0; city < numCities; city++) {
            if (!visited[city] && distances[currentCity][city] < minDistance) {
                nearestCity = city;
                minDistance = distances[currentCity][city];
            }
        }
        
        return nearestCity;
    }

    public static void main(String[] args) {
        int[][] distances = {
            {0, 29, 20, 21},
            {29, 0, 15, 17},
            {20, 15, 0, 28},
            {21, 17, 28, 0}
        };

        List<Integer> tour = nearestNeighbor(distances);
        System.out.println("Shortest TSP Tour: " + tour);
    }
}
