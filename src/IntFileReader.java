package src;

import java.io.*;

public class IntFileReader {

    public static int[] readAllInts(String file) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));

        int count = 0;
        while (br.readLine() != null) {
            count++;
        }
        br.close();

        int[] arr = new int[count];

        br = new BufferedReader(new FileReader(file));

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        return arr;
    }
}
