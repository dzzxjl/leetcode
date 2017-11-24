package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/23.
 */
public class P695 {
    int[][] isVisited;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        isVisited = new int[height][width];

        int max = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1 && isVisited[i][j] == 0) {
                    int temp = islandNum(i, j , grid, isVisited);
                    if (temp > max) {
                        max = temp;
                    }
                }

            }
        }
        return max;
    }

    public int islandNum(int i, int j, int[][] grid, int[][] isVisited) {

        int height = grid.length;
        int width = grid[0].length;
        if (i < 0 || j < 0 || i >height-1 || j > width-1 || grid[i][j] == 0 || isVisited[i][j] == 1) {
             return 0;
         }
        isVisited[i][j] = 1;
//        int num = 1;
//        if ((j -1 >= 0  && grid[i][j - 1] == 1 && isVisited[i][j-1] == 0) && (j + 1 < width && grid[i][j+1] == 1 && isVisited[i][j+1] == 0) && (i + 1 < height && grid[i+1][j] == 1 && isVisited[i+1][j] == 0)) {
        return 1 + islandNum(i-1, j, grid, isVisited)
                + islandNum(i, j-1, grid, isVisited)
                + islandNum(i, j+1, grid, isVisited)
                + islandNum(i+1, j , grid, isVisited);
//        } else if (j + 1 < width && grid[i][j+1] == 1 && isVisited[i][j+1] == 0) {
//            return 1 + islandNum(i, j+1, grid, isVisited);
//        } else if (i + 1 < height && grid[i+1][j] == 1 && isVisited[i+1][j] == 0) {
//            return 1 + islandNum(i+1, j , grid, isVisited);
//        } else if ((j -1 >= 0  && grid[i][j - 1] == 1 && isVisited[i][j-1] == 0)){
//            return 1 + islandNum(i, j-1 , grid, isVisited);
//        }
//        return 1;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
//        int[][] input = new int[][]{{0,1},{1,1}};
//        int[][] input = new int[][]{{1,1},{1,0}};
        System.out.println(new P695().maxAreaOfIsland(input));
    }
}
