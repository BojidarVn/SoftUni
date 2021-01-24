import org.junit.runner.Computer;

public class Test {




    @Test
    public void testAdMethod(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Lenovo","2012",50);
        computerManager.addComputer(computer);
        assertEquals(1,computerManager.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAdMethodNull() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = null;
        computerManager.addComputer(computer);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAlreadyExisits(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Lenovo","2012",50);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }
    @Test   // tyka

    public void testRemoveComputer(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Lenovo","2012",50);
        computerManager.addComputer(computer);
        computerManager.removeComputer("Lenovo","2012");
        assertEquals(0,computerManager.getCount());
    }

    // tyka
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithNoExistComputer(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.removeComputer("asdas","2123");
    }

    Test
    public void testValidation(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Lenovo","2012",50);
        Computer computer2 = new Computer("HP","2020",100);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        computerManager.getComputersByManufacturer()
    }

}
}
