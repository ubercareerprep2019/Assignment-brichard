package AssignmentsTest;
import Assignments.Part5.Hanoi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Part5Tests {
    @Test
    public void tower3Test() {
        Hanoi test = new Hanoi(3);
        test.solve();

        for (int i = 0; i < test.getRodThree().size(); i++) {
            Hanoi.Disk disk = test.getRodThree().get(i);
            assertEquals(disk.getPosition(),i+1);
            System.out.println(disk.getPosition());
        }
    }

    @Test
    public void tower4Test() {
        Hanoi test = new Hanoi(4);
        test.solve();

        for (int i = 0; i < test.getRodThree().size(); i++) {
            Hanoi.Disk disk = test.getRodThree().get(i);
            assertEquals(disk.getPosition(),i+1);

        }
    }

    @Test
    public void tower5Test() {
        Hanoi test = new Hanoi(5);
        test.solve();

        for (int i = 0; i < test.getRodThree().size(); i++) {
            Hanoi.Disk disk = test.getRodThree().get(i);
            assertEquals(disk.getPosition(),i+1);

        }
    }
}