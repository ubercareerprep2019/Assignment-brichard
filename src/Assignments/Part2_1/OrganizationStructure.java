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

    Queue<Employee> queue = new LinkedList<>();

    public void printLevelByLevel(Employee employee) {
         // need to take out arguments
         printLevelByLevelHelper(employee);
    }

    public void printLevelByLevelHelper(Employee employee) {
         if (queue.isEmpty()) {
             queue.add(employee);
         }

         for (Employee person : queue) {
             System.out.println("Name: " + person.name + ", Title: " + person.title);
         }

         System.out.println();

         queue.addAll(queue.remove().directReports);
         printLevelByLevelHelper(queue.peek());
    }

    public static void main(String[] args) {
         OrganizationStructure org = new OrganizationStructure();

         OrganizationStructure.Employee cfo = new OrganizationStructure.Employee();
         cfo.name = "B";
         cfo.title = "CFO";

         OrganizationStructure.Employee cto = new OrganizationStructure.Employee();
         cto.name = "C";
         cto.title = "CTO";

         OrganizationStructure.Employee ceo = new OrganizationStructure.Employee();
         ceo.name = "A";
         ceo.title = "CEO";
         List<Employee> list = new ArrayList<>();
         list.add(cfo);
         list.add(cto);
         ceo.directReports = list;
         org.ceo = ceo;

         org.printLevelByLevel(ceo);

    }
}
