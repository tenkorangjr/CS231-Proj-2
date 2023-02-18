public class LandscapeTests {

    public static void landscapeTests() {
        // Case 1
        {
            Landscape l1 = new Landscape(5, 3);
            Landscape l2 = new Landscape(5, 3, 0.5);

            assert l1 != null : "Error in Landscape::Landscape(5,3)";
            assert l2 != null : "Error in Landscape::Landscape(5,3,0.5)";
        }

        // Case 2
        {
            Landscape l1 = new Landscape(20, 40);
            Landscape l2 = new Landscape(5, 8);
            Landscape l3 = new Landscape(2, 22);

            System.out.println(l1.getCols() + " == 40");
            System.out.println(l1.getRows() + " == 20");
            System.out.println(l2.getCols() + " == 8");
            System.out.println(l2.getRows() + " == 5");
            System.out.println(l3.getCols() + " == 22");
            System.out.println(l3.getRows() + " == 2");
        }
    }

    public static void main(String[] args) {
        landscapeTests();
    }
}
