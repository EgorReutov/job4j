package ru.job4j.condition;

public class CheckCrossing {
    public boolean Transection(double ax1, double ay1, double ax2, double ay2, double bx1, double by1, double bx2, double by2) {
        double v1 = (bx2 - bx1) * (ay1 - by1) - (by2 - by1) * (ax1 - bx1);
        double v2 = (bx2 - bx1) * (ay2 - by1) - (by2 - by1) * (ax2 - bx1);
        double v3 = (ax2 - ax1) * (by1 - ay1) - (ay2 - ay1) * (bx1 - ax1);
        double v4 = (ax2 - ax1) * (by2 - ay1) - (ay2 - ay1) * (bx2 - ax1);
        return ((v1 * v2 <= 0) && (v3 * v4 <= 0));
    }
}