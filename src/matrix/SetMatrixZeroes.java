package matrix;

import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowZeroes = new HashSet<>();
        HashSet<Integer> columnZeroes = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowZeroes.add(i);
                    columnZeroes.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (rowZeroes.contains(i)) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (columnZeroes.contains(j)) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
