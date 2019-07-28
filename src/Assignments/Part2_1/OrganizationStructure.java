package Assignments.Part2_1;

import java.util.*;

/**
 * Exercise 2
 *
 * [Trees - Ex2] Exercise: Printing a tree level by level
 * Implement a method called printLevelByLevel() for the class OrganizationStructure that prints it level by level. For example, running printLevelByLevel() on the OrganizationStructure above should produce the following output:
 *
 * Name: A, Title: CEO
 *
 * Name: B, Title: CFO
 * Name: C, Title: CTO
 *
 * Name: I, Title: Director
 * Name: D, Title: Manager
 * Name: E, Title: Manager
 *
 * Name: J, Title: Sales Representative
 * Name: F, Title: Engineer
 * Name: G, Title: Engineer
 * Name: H, Title: Engineer
 *
 * Name: K, Title: Sales Intern
 *
 * (Hint - a queue might help!)
 */

public class OrganizationStructure {
    public Employee ceo;

    public static class Employee {
        public String name;
        public String title;
        public List<Employee> directReports;
    }

    private Queue<Employee> queue = new LinkedList<>();

    public void printLevelByLevel() {
        queue.add(this.ceo);

        while (!queue.isEmpty()) {
            Queue<Employee> temp = new LinkedList<>();
            temp.addAll(queue);

            for (Employee person : queue) {
                System.out.println("Name: " + person.name + ", Title: " + person.title);
            }

            System.out.println();
            queue.clear();

            for (Employee emp : temp) {
                if (emp.directReports != null) {
                    queue.addAll(emp.directReports);
                }
            }
        }
    }

    public int printNumLevels() {
        int numLevels = 0;
        queue.add(this.ceo);


        while (!queue.isEmpty()) {
            Queue<Employee> temp = new LinkedList<>();
            temp.addAll(queue);
            queue.clear();
            numLevels++;

            for (Employee emp : temp) {
                if (emp.directReports != null) {
                    queue.addAll(emp.directReports);
                }
            }
        }

        return numLevels;
    }

    public static void main(String[] args) {
         OrganizationStructure org = new OrganizationStructure();

        OrganizationStructure.Employee k = new OrganizationStructure.Employee();
        k.name = "K";
        k.title = "Sales Intern";

        OrganizationStructure.Employee h = new OrganizationStructure.Employee();
        h.name = "H";
        h.title = "Engineer";

        OrganizationStructure.Employee g = new OrganizationStructure.Employee();
        g.name = "G";
        g.title = "Engineer";

        OrganizationStructure.Employee f = new OrganizationStructure.Employee();
        f.name = "F";
        f.title = "Engineer";

        OrganizationStructure.Employee sr = new OrganizationStructure.Employee();
        sr.name = "J";
        sr.title = "Sales Representative";
        List<Employee> list1 = new ArrayList<>();
        list1.add(k);
        sr.directReports = list1;

        OrganizationStructure.Employee Manager2 = new OrganizationStructure.Employee();
        Manager2.name = "E";
        Manager2.title = "Manager";

        OrganizationStructure.Employee d = new OrganizationStructure.Employee();
        d.name = "D";
        d.title = "Manager";
        List<Employee> lis5 = new ArrayList<>();
        lis5.add(f);
        lis5.add(g);
        lis5.add(h);
        d.directReports = lis5;


         OrganizationStructure.Employee Director = new OrganizationStructure.Employee();
         Director.name = "I";
         Director.title = "Director";
        List<Employee> lis4 = new ArrayList<>();
        lis4.add(sr);
        Director.directReports = lis4;

         OrganizationStructure.Employee cfo = new OrganizationStructure.Employee();
         cfo.name = "B";
         cfo.title = "CFO";
         List<Employee> lis2 = new ArrayList<>();
         lis2.add(Director);
         cfo.directReports = lis2;

         OrganizationStructure.Employee cto = new OrganizationStructure.Employee();
         cto.name = "C";
         cto.title = "CTO";
         List<Employee> lis3 = new ArrayList<>();
         lis3.add(d);
         lis3.add(Manager2);
         cto.directReports = lis3;

         OrganizationStructure.Employee ceo = new OrganizationStructure.Employee();
         ceo.name = "A";
         ceo.title = "CEO";
         List<Employee> list = new ArrayList<>();
         list.add(cfo);
         list.add(cto);
         ceo.directReports = list;
         org.ceo = ceo;

        org.printLevelByLevel();
        System.out.println(org.printNumLevels());

    }
}
