package com.serhatacar.restaurantservice.util;

/**
 * @author Serhat Acar
 */

public class RecommendationUtils {
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
    final int R = 6371; // Dünya'nın yarıçapı kilometre cinsinden

    // Enlem ve boylamların radyan cinsinden farkları
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);

    // Haversine formülü
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(dLon / 2) * Math.sin(dLon / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    // Mesafe
    double distance = R * c;

    return distance;
}
}
