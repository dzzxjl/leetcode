package com.dzzxjl.nocat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/24.
 */
public class P332 {

    public List<String> findItinerary(String[][] tickets) {

        List<String> result = new ArrayList<>();

        Map<String,String> ticketsMap = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            ticketsMap.put(tickets[i][0],tickets[i][1]);
        }
        result.add("JFK");
        int i = 0;

        while (true) {
            if (ticketsMap.get(result.get(i)) == null) {
                return result;
            } else {
                String next = ticketsMap.get(result.get(i));
                result.add(next);
                i++;
            }

        }

//        return result;

    }

    public static void main(String[] args) {


    }

}
