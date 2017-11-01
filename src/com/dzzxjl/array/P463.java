package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/10/31.
 */
public class P463 {

    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;

        int height = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (grid[i][j + 1] == 1) {
                        neighbours++;
                    }
                    if (grid[i + 1][j] == 1) {
                        neighbours++;
                    }

                }

            }
        }



        return islands * 4 - 3 * neighbours;
    }


    public static void main(String[] args) {

    }



}
