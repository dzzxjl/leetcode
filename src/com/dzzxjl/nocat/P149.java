package com.dzzxjl.nocat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/1.
 */
public class P149 {
//    class Line {
//        Double k;
//        Double t;
//        Line(double k, double t) {
//            this.k = k;
//            this.t = t;
//        }
//
//        @Override
//        public int hashCode() {
////            return super.hashCode();
//
//            return (k.toString() + t.toString()).hashCode();
//        }
//    }

    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1 ) {
            return 1;
        }

        Map<Double, Map<Double, Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int a = points[i].x;
            int b = points[i].y;

            int same = 0;

            for (int j = 0; j < i; j++) {
                double c = points[j].x;
                double d = points[j].y;

                if (c - a == 0) {
//                    Line line = new Line(c, 0);
                    if (c - d != 0) {
                        double[][] temp = new double[1][2];
                        temp[0][0] = c;
                        temp[0][1] = 0;
                        if(map.containsKey(c)) {
                            if (map.get(c).containsKey(0)) {
                                map.get(c).put(0.0, map.get(c).get(0) + 1);
                            } else {
                                map.get(c).put(0.0, 1);
                            }
                        } else {
                            Map<Double, Integer> temp1 = new HashMap<>();
                            temp1.put(0.0, 1);
                            map.put(c, temp1);
                        }
                    } else {
                        // 不知道这个地方该怎么办。。。。
                    }

                } else {
                    double k = (d - b) / (c - a);
                    double t = Math.abs((b * c - a * d) / (c - a));

                    if(map.containsKey(k)) {
                        if (map.get(k).containsKey(t)) {
                            map.get(k).put(t, map.get(k).get(t) + 1);
                        } else {
                            map.get(k).put(t, 1);
                        }
                    } else {
                        Map<Double, Integer> temp = new HashMap<>();
                        temp.put(t, 1);
                        map.put(k, temp);
                    }
                }

            }
        }

        int max = 2;
        for (Map.Entry<Double, Map<Double, Integer>> x : map.entrySet()) {
            for (Map.Entry<Double, Integer> y : x.getValue().entrySet()) {
                if (y.getValue() > max) {
                    max = y.getValue();
                }
            }

        }

        return max;
    }


    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
//        Point point
        Point point2 = new Point(0, 0);
        Point point3 = new Point(1, 1);

        Point[] points = new Point[3];
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;

        System.out.println(new P149().maxPoints(points));
    }
}
