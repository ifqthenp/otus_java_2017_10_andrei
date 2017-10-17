package ru.otus.hw01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * {@code RandomizedMatrixDemo} class.
 */
public class RandomizedMatrixDemo
{
    public static void main(String[] args)
    {
        // build new randomized matrix
        int numRows = 3;
        int numCols = 4;
        long seed = 0L;
        RandomizedMatrix rndMatrix = new RandomizedMatrix(new NormalDistribution(0, 1), seed);
        RealMatrix matrix = rndMatrix.getMatrix(numRows, numCols);

        // get json representation of the matrix
        System.out.println("Json representation of matrix:");
        System.out.println(matrixToJsonConverter(matrix));
    }

    public static String matrixToJsonConverter(RealMatrix matrix)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(matrix);
        return result;
    }
}
