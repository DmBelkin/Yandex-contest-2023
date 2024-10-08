import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AllPermutationsTest extends TestCase {

   private AllPermutations permutations = new AllPermutations();

    private File resultFile = new File("out/output40.txt");

    public void testPermutation() throws IOException {
        File file = new File("input/inp.txt");
        permutations.permutation(file);
        List<String> r = Files.readAllLines(Paths.get(resultFile.getPath()));
        String result = "";
        for (String str : r) {
            result += str + "\n";
        }
        assertEquals("12345\n" +
                "12354\n" +
                "12435\n" +
                "12453\n" +
                "12534\n" +
                "12543\n" +
                "13245\n" +
                "13254\n" +
                "13425\n" +
                "13452\n" +
                "13524\n" +
                "13542\n" +
                "14235\n" +
                "14253\n" +
                "14325\n" +
                "14352\n" +
                "14523\n" +
                "14532\n" +
                "15234\n" +
                "15243\n" +
                "15324\n" +
                "15342\n" +
                "15423\n" +
                "15432\n" +
                "21345\n" +
                "21354\n" +
                "21435\n" +
                "21453\n" +
                "21534\n" +
                "21543\n" +
                "23145\n" +
                "23154\n" +
                "23415\n" +
                "23451\n" +
                "23514\n" +
                "23541\n" +
                "24135\n" +
                "24153\n" +
                "24315\n" +
                "24351\n" +
                "24513\n" +
                "24531\n" +
                "25134\n" +
                "25143\n" +
                "25314\n" +
                "25341\n" +
                "25413\n" +
                "25431\n" +
                "31245\n" +
                "31254\n" +
                "31425\n" +
                "31452\n" +
                "31524\n" +
                "31542\n" +
                "32145\n" +
                "32154\n" +
                "32415\n" +
                "32451\n" +
                "32514\n" +
                "32541\n" +
                "34125\n" +
                "34152\n" +
                "34215\n" +
                "34251\n" +
                "34512\n" +
                "34521\n" +
                "35124\n" +
                "35142\n" +
                "35214\n" +
                "35241\n" +
                "35412\n" +
                "35421\n" +
                "41235\n" +
                "41253\n" +
                "41325\n" +
                "41352\n" +
                "41523\n" +
                "41532\n" +
                "42135\n" +
                "42153\n" +
                "42315\n" +
                "42351\n" +
                "42513\n" +
                "42531\n" +
                "43125\n" +
                "43152\n" +
                "43215\n" +
                "43251\n" +
                "43512\n" +
                "43521\n" +
                "45123\n" +
                "45132\n" +
                "45213\n" +
                "45231\n" +
                "45312\n" +
                "45321\n" +
                "51234\n" +
                "51243\n" +
                "51324\n" +
                "51342\n" +
                "51423\n" +
                "51432\n" +
                "52134\n" +
                "52143\n" +
                "52314\n" +
                "52341\n" +
                "52413\n" +
                "52431\n" +
                "53124\n" +
                "53142\n" +
                "53214\n" +
                "53241\n" +
                "53412\n" +
                "53421\n" +
                "54123\n" +
                "54132\n" +
                "54213\n" +
                "54231\n" +
                "54312\n" +
                "54321", result.trim());
    }
}
