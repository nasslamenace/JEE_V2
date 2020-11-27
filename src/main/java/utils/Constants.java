package utils;

public class Constants {
    public static String email;

   public static final String ERR_INV_CRED_MESS = "Invalid credentials!"; //if error during the connection
    public static final String LOGIN_PAGE = "/WEB-INF/hello.jsp"; //1st page
    public static final String WELCOME_PAGE = "/WEB-INF/welcome.jsp"; //2nd page 
    public static final String DETAILS_PAGE = "/WEB-INF/internship_details.jsp"; //3rd page
    public static final String ADD_PAGE = "/WEB-INF/add.jsp"; //4rd page

    public static final String QUERY_SELECT_ALL_FROM_A_STUDENT = "SELECT * from STUDENT WHERE ID = ?"; //all information of a student
    public static final String QUERY_SELECT_STUDENT_ID_AND_TAB_EVALUATION_ID_FROM_AN_INTERNSHIP = "SELECT ID_STUDENT, ID_TAB_EVALUATION from INTERNSHIP WHERE ID = ?"; //found the student and the tab of an intership
    public static final String QUERY_SELECT_ALL_INTERNSHIPS_FROM_A_SUPERVISOR = "SELECT * from INTERNSHIP WHERE ID_SUPERVISOR = ?"; //all information of an intership based on a supervisor entry
    public static final String QUERY_SELECT_ALL_FROM_A_TAB_EVALUATION = "SELECT * from TAB_EVALUATION WHERE ID = ?"; //all information of a tab 
    public static final String QUERY_SELECT_ONE_COMPANY = "SELECT * from COMPANY WHERE ID = ?"; //all information of a company
    public static final String QUERY_SELECT_ALL_DETAILS_FROM_AN_INTERNSHIP = "SELECT * from INTERNSHIP WHERE ID_STUDENT = ?"; //all information of an intership based on a student entry
    public static final String QUERY_SELECT_SUPERVISOR_INFO = "SELECT FIRST_NAME, LAST_NAME FROM SUPERVISOR WHERE EMAIL = ?";//some informations of a supervisor based on an email
    public static final String QUERY_SELECT_ONE_STUDENT = "SELECT * FROM STUDENT WHERE ID = ?"; //all information of a student based on a email
    public static final String QUERY_SELECT_ID_FROM_AN_USER = "SELECT ID FROM SUPERVISOR WHERE EMAIL = ?"; //ID of an supervisor based on an email
    public static final String QUERY_IDENTIFY = "SELECT * FROM SUPERVISOR"; //all supervisors
    public static final String QUERY_SELECT_ONE_COMPANY_FROM_A_NAME = "SELECT * from COMPANY WHERE NAME = ?";

    public static final String QUERY_SELECT_ONE_TAB_IN_INTERNSHIP_FROM_THE_STUDENT_ID = "SELECT ID_TAB_EVALUATION from INTERNSHIP WHERE ID_STUDENT = ?";
    
    public static final String QUERY_UPDATE_TAB_EVALUATION_FROM_AN_ID = "UPDATE TAB_EVALUATION set VISITE_SHIT = ?, EVAL_SHIT_COMPANY = ?, WEB_SONDAGE = ?, RAPPORT_SEND = ?, ORAL_DONE = ?, VISITE_CHECK = ? WHERE ID = ?";

    public static final String QUERY_ADD_NEW_STUDENT = "INSERT INTO Student (Email, First_Name, Last_Name, Level) VALUES (?, ?, ?, ?)"; //add student
    public static final String QUERY_ADD_NEW_COMPANY = "INSERT INTO Company (Name, Adress) VALUES (?, ?)"; //add company
    public static final String QUERY_ADD_NEW_EMPTY_TAB_EVALUATION = "INSERT INTO Tab_Evaluation (Visite_Shit, Eval_shit_Company, Web_Sondage, Rapport_Send, Oral_Done, Visite_check, Technical_Grade, Comm_Grade) VALUES ('null', 'null', 'null', 'null', 'null', 'null', 0, 0)"; //add empty tab
    public static final String QUERY_ADD_NEW_TAB_EVALUATION = "INSERT INTO Tab_Evaluation (Visite_Shit, Eval_shit_Company, Web_Sondage, Rapport_Send, Oral_Done, Visite_check, Technical_Grade, Comm_Grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; //add tab
    public static final String QUERY_ADD_NEW_INTERNSHIP = "INSERT INTO Internship (Date_Begin, Date_End, Mission_Description, Commentary, ID_Supervisor, ID_Company, ID_Student, ID_Tab_Evaluation) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; //add internship
}
