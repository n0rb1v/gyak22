import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader bf) throws IOException {
        String line;
        String allomas = "";
        int level = 0;

        List<String> result = new ArrayList<>();
        while ((line = bf.readLine())!= null){
            if (line.contains("allomas")) {
                allomas = getLine(line);
            }
            if (line.contains("level")) {
                level = Integer.parseInt(getLine(line));
            }
            if (line.contains("},")) {
                if (level == 3) {
                    result.add(allomas);
                }
            }
        }
        Collections.sort(result, Collator.getInstance(new Locale("hu","HU")));
        return result;
    }

    private String getLine(String s) {
        s = s.split(":")[1].split(",")[0];
        s = s.replace("\"","").trim();
        return s;
    }
}
