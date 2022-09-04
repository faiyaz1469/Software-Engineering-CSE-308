import java.io.BufferedReader;
import java.io.FileReader;

public class FileParserAdaptee {

    public int calculateSum(String FILE_NAME) {

        int num;
        int sum  = 0;

        try {

            String line;
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            while (true) {

                line = br.readLine();

                if (line == null)
                    break;

                String[] tokens = line.split("\\s");
                for(String word:tokens)
                {
                    num = Integer.parseInt(word);
                    sum +=  num;
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return sum;
    }
 }
