import dao.*;
import entity.*;

/**
 * Created by MYKOLA.GOROKHOV on 02.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        DevelopersDAO developersDAO = new DevelopersDAO();
        //developersDAO.create(new Developers(5, "developer5", 5000, 1));

        //developersDAO.delete(5);
//
        System.out.println(developersDAO.read(4).toString());
        developersDAO.update(new Developers(4, "dd", 30, 2));
//

//-----------------------------------------------------------------------------
        CompaniesDAO companyDAO = new CompaniesDAO();
        //companyDAO.create(new Companies(3, "company3"));
//
      //  companyDAO.delete(3);
        System.out.println(companyDAO.read(2).toString());
//
companyDAO.update(new Companies(2, "company222"));
//-----------------------------------------------------------------------------
        //   CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.create(new Customer("Customer3"));
//
//        customerDAO.delete(15);
//        customerDAO.create(new Customer(15, "Customer15"));
//        System.out.println(customerDAO.read(15).toString());
//
//        System.out.println(customerDAO.update(15, new Customer(15, "Customer22")).toString());
//-----------------------------------------------------------------------------
        //     ProjectDAO projectDAO = new ProjectDAO();
//        projectDAO.create(new Project("Project3",50000));
//
//        projectDAO.delete(15);
//        projectDAO.create(new Project(15, "Project15",60000));
//        System.out.println(projectDAO.read(15).toString());
//
//        System.out.println(projectDAO.update(15, new Project(15, "Project22",20000)).toString());
//-----------------------------------------------------------------------------
// Пример: Создать разработчика, добавить ему навыки. Создать проект, и добавить в данный проект разработчиков.
// Разрешается использовать все возможности JDBC


    }
}
