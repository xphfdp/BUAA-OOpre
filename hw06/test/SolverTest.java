
import org.junit.Test;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void solve() {
        Scanner scanner = new Scanner("11\n1 1 a\n2 1 101 hpBol 100 HpBottle 0\n6 1 101\n" +
                "7 1 101\n3 1 202 equ 30 Axe 10\n4 1 202\n6 1 202\n" +
                "5 1 202\n8 1 303 fragment\n9 1 fragment 111\n12 1\n");
        Solver solver = new Solver(scanner);
        solver.solve();
        Adventurer adventurer = Solver.adventurers.get(1);
        assertNotNull(adventurer);
        assertEquals("a",adventurer.getName());
        assertNotNull(adventurer.getItems().get(101));
        assertEquals(600,adventurer.getHitPoint());
        assertNull(adventurer.getItems().get(202));
    }

    @Test
    public void addAdventurer() {
        Scanner scanner = new Scanner("1 a\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        assertEquals(2, Solver.adventurers.size());  // 检查是否只有一个冒险者被添加
        Adventurer adventurer = Solver.adventurers.get(1);
        assertEquals("a", adventurer.getName());  // 验证名字是否正确
        assertEquals(1, adventurer.getID());  // 验证ID是否正确
    }

    @Test
    public void takeItem() {
        Scanner scanner = new Scanner("1 a\n1 2 equ 100 Axe 10\n1 2");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        Adventurer adventurer = Solver.adventurers.get(1);
        solver.giveEquipment();
        solver.takeItem();
        assertTrue(adventurer.getItemPackage().containsKey(2));
    }

    @Test
    public void giveBottle() {
        Scanner scanner = new Scanner("1 a\n1 2 hpBol 100 HpBottle 0\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveBottle();
        Adventurer adventurer = Solver.adventurers.get(1);
        assertTrue(adventurer.getItems().containsKey(2));
        assertEquals("hpBol", adventurer.getItems().get(2).getItemName());
        assertEquals("HpBottle", adventurer.getItems().get(2).getType());
        assertEquals(0, adventurer.getItems().get(2).getCe());
    }

    @Test
    public void giveEquipment() {
        Scanner scanner = new Scanner("1 a\n1 2 equ 10 Blade 30\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveEquipment();
        Adventurer adventurer = Solver.adventurers.get(1);
        assertTrue(adventurer.getItems().containsKey(2));
        assertEquals("equ", adventurer.getItems().get(2).getItemName());
        assertEquals("Blade", adventurer.getItems().get(2).getType());
        assertEquals(30, adventurer.getItems().get(2).getCe());
    }

    @Test
    public void increaseDurability() {
        Scanner scanner = new Scanner("1 a\n1 2 equ 10 Blade 30\n1 2\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveEquipment();
        solver.increaseDurability();
        Adventurer adventurer = Solver.adventurers.get(1);
        Equipment equipment = adventurer.getItems().get(2).getEquipmentHashMap().get(2);
        assertEquals(11,equipment.getDurability());
    }

    @Test
    public void deleteItem() {
        Scanner scanner = new Scanner("1 a\n1 2 equ 10 Blade 30\n1 2\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveEquipment();
        solver.deleteItem();
        Adventurer adventurer = Solver.adventurers.get(1);
        Item item = adventurer.getItems().get(2);
        assertNull(item);
    }

    @Test
    public void useBottle() {
        Scanner scanner = new Scanner("1 a\n1 2 hpBol 100 HpBottle 0\n1 2\n1 2\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveBottle();
        solver.takeItem();
        Adventurer adventurer = Solver.adventurers.get(1);
        solver.useBottle();
        assertEquals(600,adventurer.getHitPoint());
    }

    @Test
    public void giveFragment() {
        Scanner scanner = new Scanner("1 a\n1 2 fragment\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveFragment();
        Adventurer adventurer = Solver.adventurers.get(1);
        Fragment fragment = adventurer.getFragments().get(0);
        assertNotNull(fragment);
        assertEquals(2,fragment.getIdFrag());
        assertEquals("fragment",fragment.getNameFrag());
    }

    @Test
    public void exchangeWelfare() {
        Scanner scanner = new Scanner("1 a\n1 2 fragment\n1 fragment 100\n" +
                "1 3 fragment\n1 4 fragment\n1 5 fragment\n1 6 fragment\n1 fragment 100\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.giveFragment();
        Adventurer adventurer = Solver.adventurers.get(1);
        solver.exchangeWelfare();
        assertFalse(adventurer.getItems().containsKey(100));
        solver.giveFragment();
        solver.giveFragment();
        solver.giveFragment();
        solver.giveFragment();
        solver.exchangeWelfare();
        assertTrue(adventurer.getItems().containsKey(100));
    }

    @Test
    public void battle() {
        Scanner scanner = new Scanner("1 a\n2 b\n1 111 equ 30 Axe 40\n1 111\n1 equ normal 1 2\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.addAdventurer();
        solver.giveEquipment();
        solver.takeItem();
        solver.battle();
        Adventurer adventurer2 = Solver.adventurers.get(2);
        assertEquals(50,adventurer2.getHitPoint());
    }

    @Test
    public void hire() {
        Scanner scanner  = new Scanner("1 a\n2 b\n1 2\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        solver.addAdventurer();
        solver.hire();
        Adventurer adventurer1 = Solver.adventurers.get(1);
        Adventurer adventurer2 = Solver.adventurers.get(2);
        assertTrue(adventurer1.getEmployees().contains(adventurer2));
    }

    @Test
    public void challenge() {
        Scanner scanner = new Scanner("1 a\n1\n");
        Solver solver = new Solver(scanner);
        solver.addAdventurer();
        Adventurer adventurer = Solver.adventurers.get(1);
        adventurer.setAtk(1001);
        solver.challenge();
        assertEquals(40,adventurer.getDef());
    }
}