import junit.framework.TestCase;
import org.junit.Test;
import java.util.Scanner;

public class SolverTest extends TestCase {
    @Test
    public void Solver() {
        // 使用 Scanner 创建输入流
        String input = "test input";
        Scanner scanner = new Scanner(input);

        // 创建 Solver 实例
        Solver solver = new Solver(scanner);

        // 检查 Solver 实例不为空
        assertNotNull(solver);
    }
}