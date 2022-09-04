import java.io.*;

public interface IFileParser {
    int calculateSumViaAdaptee(String fileName);
}


class FileParserAdapter implements IFileParser {

    private final FileParserAdaptee adaptee;

    public FileParserAdapter(FileParserAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int calculateSumViaAdaptee(String FILE_NAME) {

        String fileString = "";
        int sum;

        try {

            String line;
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            while (true) {

                line = br.readLine();

                if (line == null)
                    break;

                String[] tokens = line.split("~");
                for(String word:tokens)
                {
                    fileString = (fileString.concat(word)).concat(" ");
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
            bw.write(fileString);
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sum = this.adaptee.calculateSum("temp.txt");

        return sum;
    }

}

