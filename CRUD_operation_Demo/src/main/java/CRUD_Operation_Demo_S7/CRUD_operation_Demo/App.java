package CRUD_Operation_Demo_S7.CRUD_operation_Demo;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class App {
    public static void main(String[] args) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory sf = md.getSessionFactoryBuilder().build();
    	Session s = sf.openSession();
    	Transaction t; 
    	
    	Scanner sc = new Scanner(System.in);
    	int choice;
    	
    	do {
    		System.out.println("-----STUDENT MENUBAR-----");
    		System.out.println("1. INSERT");
    		System.out.println("2. UPDATE");
    		System.out.println("3. DELETE");
    		System.out.println("4. DISPLAY");
    		System.out.println("5. EXIT");
    		System.out.println("Enter choice: ");
    		choice = sc.nextInt();
    		sc.nextLine();
    		
    		switch(choice){
    			
    		case 1: //Insert
    			t = s.beginTransaction();
    			Student s1 = new Student();
    			System.out.print("Enter the name of the student: ");
    			s1.setName(sc.nextLine());
    			System.out.print("Enter ur branch: ");
    			s1.setBranch(sc.nextLine());
    			System.out.print("Enter ur cgpa: ");
    			s1.setCgpa(sc.nextDouble());
    			 sc.nextLine();
    	        System.out.println("Enter ur address: ");
    	        s1.setAddress(sc.nextLine());
    	      
    	        
    	        s.save(s1);
    	        t.commit();
    	        System.out.println("Data Inserted Successfully");
    	        break;
    	        
    		case 2://Update
    		    System.out.print("Enter Student ID to update: ");
    		    int id = sc.nextInt();
    		    sc.nextLine();

    		    Student st = s.find(Student.class, id);

    		    if (st != null) {

    		        System.out.println("What do you want to update?");
    		        System.out.println("1. Name");
    		        System.out.println("2. Branch");
    		        System.out.println("3. CGPA");
    		        System.out.println("4. Address");
    		        System.out.print("Enter choice: ");
    		        int opt = sc.nextInt();
    		        sc.nextLine();

    		        t = s.beginTransaction();

    		        switch (opt) {
    		            case 1:
    		                System.out.print("Enter new Name: ");
    		                st.setName(sc.nextLine());
    		                break;

    		            case 2:
    		                System.out.print("Enter new Branch: ");
    		                st.setBranch(sc.nextLine());
    		                break;

    		            case 3:
    		                System.out.print("Enter new CGPA: ");
    		                st.setCgpa(sc.nextDouble());
    		                break;

    		            case 4:
    		                System.out.print("Enter new Address: ");
    		                st.setAddress(sc.nextLine());
    		                break;

    		            default:
    		                System.out.println("Invalid option");
    		                t.rollback();
    		                break;
    		        }

    		        t.commit();
    		        System.out.println("Record updated successfully");

    		    } else {
    		        System.out.println("Student not found");
    		    }
    		    break;

    		case 3:
    			t = s.beginTransaction();
    			System.out.print("Enter the id to delete the record: ");
    			int id_delete = sc.nextInt();
    			Student s3 = s.find(Student.class, id_delete);
    			if(s3!= null) {    			
    			s.delete(s3);
    			t.commit();
    			System.out.println(id_delete+"th record deleted successfully");
    			}else {
    				System.out.println("Student Id is not found");
    			}
    			break;
    		case 4:
    			t = s.beginTransaction();
    			System.out.println("--Student records--");
    		    Query q = s.createQuery("FROM Student");
    		    List<Student> list = q.list();
    		    for(Student i:list)
    		    {    	
    		    	System.out.println(
    		    			"Id :" +i.getId() +" Name :"+ i.getName()+" Branch :" +i.getBranch() +" Cgpa :" +i.getCgpa()+ "Address :" +i.getAddress());
    		    	
    		    }
    		    break;
    		 case 5:
                 System.out.println("Exiting Program");
                 break;

             default:
                 System.out.println("Invalid Choice");         
    		}
    	}while(choice!=5);
    	
//    	// To insert the value
//    	System.out.println("Enter the no of students:");
//    	int n = sc.nextInt();
//    	sc.nextLine();
//    	
//    	for(int i = 0;i<n;i++) {
//    		Student s1 = new Student();
//    		System.out.print("Enter name: ");
//    		s1.setName(sc.nextLine());
//    		
//    		System.out.print("Enter the branch: ");
//    		s1.setBranch(sc.nextLine());
//    		
//    		System.out.println("Enter ur cgpa: ");
//    		s1.setCgpa(sc.nextDouble());
//    		sc.nextLine();
//    		
//    		System.out.print("Enter the address: ");
//    		s1.setAddress(sc.nextLine());
//    		 s.save(s1); 
//       	System.out.println(n+" record successfull inserted");
//    	}
    	
//    	To update the value
    	
//    	System.out.println("To update the value");
//    	
//    	Student s2 = s.find(Student.class, 5);
//    	System.out.println("Before update:"+s2.name);
//    	System.out.println("Before update:"+s2.branch);
//    	s2.setName("Ramrashiya");
//    	s2.setBranch("ece");
//    	 s.save(s2);
//    	 System.out.println("after update:"+s2.name);
//    	 System.out.println("after update:"+s2.branch);
//    	
//    	// TO delete the 7 th record from the database;
//        Student s3 = s.find(Student.class, 2);
//        s.delete(s3);
//        System.out.println("SUccessfully deleted");
//    	
//    	s1.setName("Kumar priyanshu");
//    	s1.setAddress("Bihar");
    	
//    	t = s.beginTransaction();
//    	s.save(s1);
//    	t.commit();


    	
    	
    }
}
