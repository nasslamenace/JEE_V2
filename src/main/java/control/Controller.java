package control;

import com.mycompany.pj.Company;
import com.mycompany.pj.CompanySb;
import com.mycompany.pj.InternshipSb;
import com.mycompany.pj.StudentSb;
import com.mycompany.pj.Supervisor;
import com.mycompany.pj.SupervisorSb;
import com.mycompany.pj.Internship;
import com.mycompany.pj.Student;
import com.mycompany.pj.TabEvaluation;
import com.mycompany.pj.Tab_EvaluationSb;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

import static utils.Constants.*;

public class Controller extends HttpServlet {

    @EJB
    private SupervisorSb supervisorSb;
    @EJB
    private StudentSb studentSb;
    @EJB
    private InternshipSb internshipSb;
    @EJB
    private Tab_EvaluationSb tabSb;
    @EJB
    private CompanySb companySb;

    private ArrayList<Student> listOfStudents; //list of student that will be ssend to the welcome page

    private ArrayList<Integer> listOfInternshipsID; //list of Internships ID. Usefull to have all Internships in one object to inspect them individualy if needed

    private ArrayList<Integer> listOfStudentsID; //list of Students ID. Usefull to have all Internships in one object to inspect them individualy if needed

    private ArrayList<Integer> listOfTabID; //list of Tabs ID. Usefull to have all Internships in one object to inspect them individualy if needed

    private User user; //The user connected to the session

    private int user_id; //The user connected to the session

    private Properties prop; //properties file

    private InputStream input; // To be able to read the information stored in the properties file we'll need this instance of InputStream

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public void init() { //function to initilaise the database connexion

    }

    //function to see if informations set during the connection are correct
    private boolean checkCredentials(User myUser) throws ServletException, IOException {
       
        ArrayList<Supervisor> users = new ArrayList<Supervisor>();

        users.addAll(supervisorSb.getUsers());

        for (Supervisor u : users) {
            if (u.getEmail().equals(myUser.getEmail()) && myUser.getPwd().equals(u.getPassword())) {
                myUser.setID(u.getId());
                myUser.setFirst_name(u.getEmail());
                myUser.setLast_name(u.getLastName());
                return true;
            }

        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //This function is the heart of our project.
            throws ServletException, IOException {
        if (request.getParameter("detail") != null) { //If someone select an intership and wants details about it
            if (request.getParameter("one_student") != null) //if one student is selected to have more details
            {
                request.setAttribute("User", this.user);
                
                ArrayList<Supervisor> users = new ArrayList<Supervisor>();

                users.addAll(supervisorSb.getUsers());


                Student OurStudent = studentSb.getStudent(Integer.parseInt(request.getParameter("one_student"))); //we create our object student to fill it with results
                //and we stored them in a object that we define as an attribute
                request.setAttribute("Student", OurStudent);
                
                
                
                    Internship aInternship = internshipSb.getInternshipByStudentId(OurStudent.getId()); //we create our object internship to fill it with results
                    //and we stored them in a object that we define as an attribute
                    request.setAttribute("Internship", aInternship);
                    
                                        /////////COMPANY/////////////

                    Company aCompany = companySb.getCompany(user_id);

                    //and we stored them in a object that we define as an attribute
                    request.setAttribute("Company", aCompany);

                    request.getRequestDispatcher(DETAILS_PAGE).forward(request, response); 
                    

                /*try {
                    // we need to get a lot of information to redirects them in the detail page
                    /////////SUPERVISOR/////////////
                    pstmt = conn.prepareStatement(QUERY_SELECT_SUPERVISOR_INFO); // we prepare a dynamic query
                    pstmt.setString(1, user.getEmail()); //with the User data
                    rs = pstmt.executeQuery(); //to get his informations
                    while (rs.next()) {
                        user.setFirst_name(rs.getString("FIRST_NAME"));
                        user.setLast_name(rs.getString("LAST_NAME"));
                    }
                    //and we stored them in a object that we define as an attribute
                    

                    //now it's time for the student informations
                    /////////STUDENT/////////////
                    pstmt = conn.prepareStatement(QUERY_SELECT_ONE_STUDENT); // we prepare a dynamic query
                    pstmt.setString(1, request.getParameter("one_student")); //with the data send by the checkbox in the selected student in the welcome page
                    rs = pstmt.executeQuery(); // and we can received our student informations
                    Student OurStudent = new Student(); //we create our object student to fill it with results
                    int ID_student = 0; //variable to store his ID
                    while (rs.next()) {
                        ID_student = rs.getInt("ID"); //here we need his ID to found after his internship
                        OurStudent.setID(rs.getInt("ID"));
                        OurStudent.setEmail(rs.getString("EMAIL"));
                        OurStudent.setFirstName(rs.getString("FIRST_NAME"));
                        OurStudent.setLastName(rs.getString("LAST_NAME"));
                        OurStudent.setLevel(rs.getString("LEVEL"));  
                    }
                    //and we stored them in a object that we define as an attribute
                    request.setAttribute("Student", OurStudent);

                    /////////internship/////////////
                    pstmt = conn.prepareStatement(QUERY_SELECT_ALL_DETAILS_FROM_AN_INTERNSHIP); // we prepare a dynamic query
                    pstmt.setString(1, Integer.toString(ID_student)); //with previous student ID that we just have set
                    rs = pstmt.executeQuery(); // and we can received our internship informations
                    int ID_company = 0; //variable to store the Id of the company for the next part.
                    Internship aInternship = new Internship(); //we create our object internship to fill it with results
                    while (rs.next()) {
                        ID_company = rs.getInt("ID_COMPANY"); //the id company that will be usefull after
                        aInternship.setDate_Begin(rs.getString("DATE_BEGIN"));
                        aInternship.setDate_End(rs.getString("DATE_END"));
                        aInternship.setMission_description(rs.getString("MISSION_DESCRIPTION"));
                        aInternship.setCommentary(rs.getString("COMMENTARY"));
                    }
                    //and we stored them in a object that we define as an attribute
                    request.setAttribute("Internship", aInternship);

                    /////////COMPANY/////////////
                    pstmt = conn.prepareStatement(QUERY_SELECT_ONE_COMPANY); // we prepare a dynamic query
                    pstmt.setString(1, Integer.toString(ID_company)); //with previous company ID 
                    rs = pstmt.executeQuery(); // and we can get all the information about the company
                    Company aCompany = new Company();
                    while (rs.next()) {
                        aCompany.setName(rs.getString("NAME"));
                        aCompany.setAdress(rs.getString("ADRESS"));
                    }
                    //and we stored them in a object that we define as an attribute
                    request.setAttribute("Company", aCompany);

                    request.getRequestDispatcher(DETAILS_PAGE).forward(request, response);   //we send all attributes and a redirection to the detail page
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }   */
            } else { //if not we reload the page
                request.setAttribute("keyListOfStudents", listOfStudents);

                request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
            }
        } else if (request.getParameter("add") != null) { //Redirection to the add button
            request.getRequestDispatcher(ADD_PAGE).forward(request, response);
        } else if (request.getParameter("validate") != null) { //validation in the welcome page to validate changes in the checkbox
            /*try{
          
                /*String[] students_number_tab = request.getParameterValues("Technical_grade");
                ArrayList<String> students = new ArrayList<String>();
                for(int i=0;i<students_number_tab.length;i++)
                {
                    students.add(students_number_tab[i]);
                }
                int nb_students=students.size();
                System.out.println("le nombre d'étudiants dans notre list " + nb_students); //nombre d'étudiants*/
            //the student and his tab
            /*pstmt = conn.prepareStatement(QUERY_SELECT_ONE_TAB_IN_INTERNSHIP_FROM_THE_STUDENT_ID);
                pstmt.setString(1, request.getParameter("one_student"));
                rs = pstmt.executeQuery();
                String student_id = request.getParameter("one_student");
                int tab_id = 0;
                while (rs.next()) {
                    tab_id = rs.getInt("ID_TAB_EVALUATION");
                } 
                System.out.println("l'étudiant en cours de validation " + request.getParameter("one_student") + " et son tab_id " + tab_id); //étudiant à valdier et son tableau
                
                pstmt = conn.prepareStatement(QUERY_UPDATE_TAB_EVALUATION_FROM_AN_ID);
                boolean have_to = false;
                //VISITE_SHIT
                ArrayList<String> visite_shit_up = new ArrayList<String>();
                String[] visite_shit = request.getParameterValues("VISITE_SHIT");             
                for(int i=0;i<visite_shit.length;i++)
                {
                    visite_shit_up.add(visite_shit[i]);
                }
                for(String s : visite_shit_up){
                    if(s.equals(student_id)){
                        have_to = true;
                    }
                }
                if(have_to){
                    pstmt.setString(1, "checked");
                }
                else{
                    pstmt.setString(1, "null");
                }
                have_to = false;
                //EVAL_SHIT_COMPANY
                ArrayList<String> eval_shit_up = new ArrayList<String>();
                String[] eval_shit = request.getParameterValues("EVAL_SHIT_COMPANY");             
                for(int i=0;i<eval_shit.length;i++)
                {
                    eval_shit_up.add(eval_shit[i]);
                }
                for(String s : eval_shit_up){
                    if(s.equals(student_id)){
                        have_to = true;
                    }
                }
                if(have_to){
                    pstmt.setString(2, "checked");
                }
                else{
                    pstmt.setString(2, "null");
                }
                have_to = false;
                //WEB_SONDAGE
                ArrayList<String> web_sondage_up = new ArrayList<String>();
                String[] web_sondage = request.getParameterValues("WEB_SONDAGE");             
                for(int i=0;i<web_sondage.length;i++)
                {
                    web_sondage_up.add(web_sondage[i]);
                }
                for(String s : web_sondage_up){
                    if(s.equals(student_id)){
                        have_to = true;
                    }
                }
                if(have_to){
                    pstmt.setString(3, "checked");
                }
                else{
                    pstmt.setString(3, "null");
                }
                have_to = false;
                //RAPPORT_SEND
                ArrayList<String> rapport_send_up = new ArrayList<String>();
                String[] rapport_send = request.getParameterValues("RAPPORT_SEND");             
                for(int i=0;i<rapport_send.length;i++)
                {
                    rapport_send_up.add(rapport_send[i]);
                }
                for(String s : rapport_send_up){
                    if(s.equals(student_id)){
                        have_to = true;
                    }
                }
                if(have_to){
                    pstmt.setString(4, "checked");
                }
                else{
                    pstmt.setString(4, "null");
                }
                have_to = false;
                //ORAL_DONE
                ArrayList<String> oral_done_up = new ArrayList<String>();
                String[] oral_done = request.getParameterValues("ORAL_DONE");             
                for(int i=0;i<oral_done.length;i++)
                {
                    oral_done_up.add(oral_done[i]);
                }
                for(String s : oral_done_up){
                    if(s.equals(student_id)){
                        have_to = true;
                    }
                }
                if(have_to){
                    pstmt.setString(5, "checked");
                }
                else{
                    pstmt.setString(5, "null");
                }
                have_to = false;
                //VISITE_CHECK
                ArrayList<String> visite_check_up = new ArrayList<String>();
                String[] visite_check = request.getParameterValues("VISIT_CHECK");             
                for(int i=0;i<visite_check.length;i++)
                {
                    visite_check_up.add(visite_check[i]);
                }
                for(String s : visite_check_up){
                    if(s.equals(student_id)){
                        have_to = true;
                    }
                }
                if(have_to){
                    pstmt.setString(6, "checked");
                }
                else{
                    pstmt.setString(6, "null");
                }
                have_to = false;
                //tab_id
                pstmt.setString(7, Integer.toString(tab_id)); 
                int eU = pstmt.executeUpdate();
                /*String[] eval = request.getParameterValues("EVAL_SHIT_COMPANY");
                System.out.println(eval.length);  
                for(int i=0;i<eval.length;i++)
                {
                    if(eval[i].equals("checked")){
                        System.out.println("good");
                    }
                    else{
                        System.out.println("not good");
                    }
                }*/
 /*pstmt = conn.prepareStatement(QUERY_ADD_NEW_TAB_EVALUATION);
                pstmt.setString(1, request.getParameter("student")); 
                pstmt.setString(2, request.getParameter("lastName"));
                pstmt.setString(3, request.getParameter("firstName"));
                pstmt.setString(4, request.getParameter("level"));
                pstmt.setString(4, request.getParameter("level"));
                pstmt.setString(4, request.getParameter("level"));
                pstmt.setString(4, request.getParameter("level"));
                pstmt.setString(4, request.getParameter("level"));
                int eU = pstmt.executeUpdate();*/

 /*setlistOfStudents();
                request.setAttribute("keyListOfStudents", listOfStudents);
                request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } else if (request.getParameter("validation") != null) { //to the validation button in the add page
            //each time we have to push our new informations and get the id of the creation to put it in the internship
            //for the student
            /*try {
                pstmt = conn.prepareStatement(QUERY_ADD_NEW_STUDENT);
                pstmt.setString(1, request.getParameter("student")); 
                pstmt.setString(2, request.getParameter("lastName"));
                pstmt.setString(3, request.getParameter("firstName"));
                pstmt.setString(4, request.getParameter("level"));
                int eU = pstmt.executeUpdate();
                pstmt = conn.prepareStatement(QUERY_SELECT_ONE_STUDENT);
                pstmt.setString(1, request.getParameter("student"));
                rs = pstmt.executeQuery();
                int student_id = 0;
                while (rs.next()) {
                    student_id = rs.getInt("ID");
                }

                //for the company
                pstmt = conn.prepareStatement(QUERY_ADD_NEW_COMPANY);
                pstmt.setString(1, request.getParameter("entName")); 
                pstmt.setString(2, request.getParameter("adress"));
                eU = pstmt.executeUpdate();
                pstmt = conn.prepareStatement(QUERY_SELECT_ONE_COMPANY_FROM_A_NAME);
                pstmt.setString(1, request.getParameter("entName"));
                rs = pstmt.executeQuery();
                int company_id = 0;
                while (rs.next()) {
                    company_id = rs.getInt("ID");
                }

                //for the tab
                stmt = conn.createStatement();
                eU = stmt.executeUpdate(QUERY_ADD_NEW_EMPTY_TAB_EVALUATION);
                rs = conn.createStatement().executeQuery("SELECT MAX(ID) id FROM TAB_EVALUATION"); //last id put in tab evaluation
                int tab_id = 0;
                while (rs.next()) {
                    tab_id = rs.getInt("id");
                }

                //for the internship
                pstmt = conn.prepareStatement(QUERY_ADD_NEW_INTERNSHIP);
                pstmt.setString(1, request.getParameter("begin")); 
                pstmt.setString(2, request.getParameter("end"));
                pstmt.setString(3, request.getParameter("description"));
                pstmt.setString(4, request.getParameter("commentary"));
                pstmt.setInt(5, user.getID()); 
                pstmt.setInt(6, student_id);
                pstmt.setInt(7, company_id);
                pstmt.setInt(8, tab_id);
                eU = pstmt.executeUpdate();

                //back to the welcome page
                setlistOfStudents();
                request.setAttribute("keyListOfStudents", listOfStudents);

                request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } */
        } else if (request.getParameter("loginForm") == null) { //if nothings in the login page
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response); //redirection to the login page if there is no connexion set
        } else if (request.getParameter("logout") != null) { //to logout
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response); //redirection to the login page if there is no connexion set
        } else if (request.getParameter("loginForm") != null) { //if entries in the login page
            //it's the welcome page where all the students of an user have to be display with the evaluation tab
            //first there is the connexion after doing the login page
            ///////////////////CHECK///////////////////////////
            User myUser = new User();
            myUser.setEmail(request.getParameter("loginForm"));
            myUser.setPwd(request.getParameter("passForm"));
            this.user = myUser; //we store in the controller the user session
            if (checkCredentials(myUser)) { //we verify the authenticity of the user

                setlistOfStudents();
                request.setAttribute("keyListOfStudents", listOfStudents);

                request.getRequestDispatcher(WELCOME_PAGE).forward(request, response); //we send all attributes and a redirection to the welcome page*/
            } else { //if errors during the connection we send the message to the login screen
                request.setAttribute("keyErrMess", ERR_INV_CRED_MESS);
                request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);

            }
        } else {
            System.out.print("..........................."); //error message in the console if there is a problem
        }
    }

    public void setlistOfStudents() throws ServletException, IOException {

        listOfInternshipsID = internshipSb.getIds(user_id);

        for (int id : listOfInternshipsID) {

            Internship myInternship = internshipSb.getInternship(id);

            listOfTabID.add(myInternship.getIDTabEvaluation());
            listOfStudentsID.add(myInternship.getIDStudent());

        }

        TabEvaluation[] tab_of_tab = new TabEvaluation[listOfTabID.size()];

        int i = 0;
        for (int id : listOfTabID) //for each internship
        {
            TabEvaluation aTab = tabSb.getTab(id);
            tab_of_tab[i] = aTab; //store it in the tab

            i++;
        }

        listOfStudents = new ArrayList<Student>(); //we create a list of students
        int j = 0; //this variable is to parcour our evaluation tab to associate the tab to our student
        for (int id : listOfStudentsID) //for each student id
        {

            Student aStudent = studentSb.getStudent(id); //we create an object to store our data
            listOfStudents.add(aStudent); //and we add our studet to the list

            j++;
        }

        /* try {

            ///////////////////STUDENTS///////////////////////////
            //now we can be focused on our student id list
            listOfStudents = new ArrayList<Student>(); //we create a list of students
            int j = 0; //this variable is to parcour our evaluation tab to associate the tab to our student
            for(int id : listOfStudentsID) //for each student id
            {   
                pstmt = conn.prepareStatement(QUERY_SELECT_ALL_FROM_A_STUDENT);
                pstmt.setString(1, Integer.toString(id)); //we define our query based on the id student
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Student aStudent = new Student(); //we create an object to store our data
                    aStudent.setID(rs.getInt("ID"));
                    aStudent.setEmail(rs.getString("EMAIL"));
                    aStudent.setFirstName(rs.getString("FIRST_NAME"));
                    aStudent.setLastName(rs.getString("LAST_NAME"));
                    aStudent.setLevel(rs.getString("LEVEL"));
                    aStudent.setTab(tab_of_tab[j]); //and we link a tab evaluation to our student
                    listOfStudents.add(aStudent); //and we add our studet to the list
                }
                j++;
            }
            //we are sure with this method to dont have errors because our evaluation tab and our student id list have been set in the same order (up to down)
            // that means no errors.
            //now we have a list of student from an user and each one has his own evaluation tab on it
            //and we stored them in a object that we define as an attribute. We have all our student ready to be display
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

}
