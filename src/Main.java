import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static double[][] c = new double[3][3];
    static double[] g = new double[3];

    public static void transform(double[][] mtx_, double[] ans_, int itCount) {
        int size = mtx_.length;
        double[][] mtx = new double[size][size];
        double[] ans = new double[size];
        for (int i = itCount; i < size; i++) {
            c[itCount][i] = mtx_[itCount][i] / mtx_[itCount][itCount];
            mtx[itCount][i] = mtx_[itCount][i] / mtx_[itCount][itCount];
        }
        g[itCount] = ans_[itCount] / mtx_[itCount][itCount];
        ans[itCount] = ans_[itCount] / mtx_[itCount][itCount];
        for (int i = itCount + 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mtx[i][j] = mtx_[i][j] - mtx_[i][itCount] * mtx_[itCount][j] / mtx_[itCount][itCount];
            }
            ans[i] = ans_[i] - mtx_[i][itCount] * ans_[itCount] / mtx_[itCount][itCount];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mtx_[i][j] = mtx[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            ans_[i] = ans[i];
        }

    }

    public static void print(double a[][], double b[]) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] x = new double[3];
        double[][] inp = new double[3][3];
        double[] ans = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inp[i][j] = sc.nextDouble();
            }
        }
        for (int i = 0; i < 3; i++) {
            ans[i] = sc.nextDouble();
        }
        for (int i = 0; i < 3; i++) {
            transform(inp, ans, i);
            System.out.println("Iteration " + i);
            print(inp, ans);
        }
        print(c, g);

        x[2] = g[2];
        x[1] = g[1] - c[1][2] * x[2];
        x[0] = g[0] - c[0][1] * x[1] - c[0][2] * x[2];
        for (int i = 0; i < 3; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
