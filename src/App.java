import java.util.*;
import java.sql.*;


class SmartCity {
    public static void main(String[] args) throws Exception {
        String dburl = "jdbc:mysql://localhost:3307/smart_city";
        String dbuser = "root";
        String dbpass = "";
        // String drivername = "com.mysql.jdbc.Driver";
        // Class.forName(drivername);
        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);


        if (con != null) {
            System.out.println("Connection Sucessful");
        } else {
            System.out.println("Connection Failed");
        }


        System.out.println("********************");
        System.out.println("WELCOME TO SMART CITY");
        System.out.println("********************");


        Scanner input = new Scanner(System.in);


        int flag = 0;
        while (flag != 1) {
            System.out.println("");
            System.out.println("if you are,admin : press 1");
            System.out.println("if you are,user : press 2");
            System.out.println("if you want to exit : press 3");
            System.out.println();
            System.out.print("enter your choice : ");
            int choice1 = input.nextInt();
            input.nextLine();


            switch (choice1) {
                case 1:
                    // admin
                    Admin admin = new Admin(con);
                    admin.login();
                    break;
                case 2:
                    // user
                    User u = new User(con);
                    u.loginn();
                    break;
                case 3:
                    // exit
                    flag = 1;
                    System.out.println("**********************");
                    System.out.println("THANKYOU FOR VISITING");
                    System.out.println("---------EXIT--------");
                    System.out.println("**********************");
                    break;


                default:
                    System.out.println("----------------------------------");
                    System.out.println("invalid choice");
                    System.out.println("please re-enter your choice!");
                    System.out.println("----------------------------------");


            }
        }
    }
}


class Admin {
    // for admin
    Connection con;


    Admin(Connection con) {
        this.con = con;
    }


    void login() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Password - ");
        String password = input.nextLine();
        boolean h = true;
        while (h) {
            if (password.equals("1234")) {
                System.out.println("");
                System.out.println("-----------------");
                System.out.println("Sucessfully Login");
                System.out.println("-----------------");
                System.out.println("");


                System.out.println("---------------------------");
                System.out.println("to insert : press 1");
                System.out.println("to update : press 2");
                System.out.println("to delete : press 3");
                System.out.println("to select/fetch : press 4");
                System.out.println("to exit : press 5");
                System.out.println("---------------------------");
                System.out.print("select function :");
                int function = input.nextInt();
                System.out.println("---------------------------");


                Database db = new Database(con);
                switch (function) {
                    case 1:
                        // to insert
                        db.insert();
                        break;


                    case 2:
                        // to update
                        db.update();
                        break;


                    case 3:
                        // to delete
                        db.delete();
                        break;


                    case 4:
                        // to select/fetch
                        db.fetch();
                        break;


                    case 5:
                        // exit
                        h = false;
                        break;
                }


            } else {
                System.out.println("Incorrect Password");
                h = false;
            }
        }
    }


}


class User {
    // for user


    Connection con;


    User(Connection con) {
        this.con = con;
    }


    void loginn() throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean l = true;
        while (l) {


            System.out.println("please enter your name : ");
            String user_name = sc.nextLine();


            System.out.println("enter you user-id :");
            String user_id = sc.nextLine();


            if (user_name == null || user_id == null) {
                System.out.println("please enter your user name and user id!!");
            } else {
                System.out.println("******************");
                System.out.println("login successful!!");
                System.out.println("******************");
                Database d = new Database(con);
                d.fetch();
            }
        }


    }
}


class Database {
    Connection con;


    Database(Connection con) {
        this.con = con;
    }


    // for database
    Scanner sc = new Scanner(System.in);


    void insert() throws SQLException {
        int flag = 0;
        while (flag != 1) {
            System.out.println("************************************");
            System.out.println("insert into : ");
            System.out.println("************************************");
            System.out.println("-------------------------------------");
            System.out.println("|  1: city                          |");
            System.out.println("|  2: restaurants                   |");
            System.out.println("|  3: hotels                        |");
            System.out.println("|  4: atm                           |");
            System.out.println("|  5: fuel pumps                    |");
            System.out.println("|  6: public transportation         |");
            System.out.println("|  7: smart buildings               |");
            System.out.println("|  8: hospital                      |");
            System.out.println("|  9: schools                       |");
            System.out.println("|  10: colleges                     |");
            System.out.println("|  11: emergency services           |");
            System.out.println("|  12: police station               |");
            System.out.println("|  13: government offices           |");
            System.out.println("|  14: parks                        |");
            System.out.println("|  15: exit                         |");
            System.out.println("-------------------------------------");
            System.out.print("enter your choice : ");
            int choice2 = sc.nextInt();
            sc.nextLine();
            System.out.println("************************************");
            System.out.println();


            switch (choice2) {
                case 1:
                    // city


                    System.out.println("insert into city:");
                    System.out.println("enter city name : ");
                    String cityName = sc.nextLine();
                    System.out.println("enter state : ");
                    String state = sc.nextLine();
                    System.out.println("enter country name : ");
                    String country = sc.nextLine();


                    String sql = "insert into city (city_name,state,country) values (?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, cityName);
                    pst.setString(2, state);
                    pst.setString(3, country);


                    System.out.println("Record Inserted: " + pst.executeUpdate());
                    break;
                case 2:
                    // restaurant
                    System.out.println("insert into restaurant:");
                    System.out.println("enter restaurant name : ");
                    String restroName = sc.nextLine();
                    System.out.println("enter restaurant type(veg/non-veg) : ");
                    String restroType = sc.nextLine();
                    System.out.println("enter restaurant location : ");
                    String restroLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String restroCity = sc.nextLine();


                    String sql1 = "insert into restaurants (restaurant_name , restaurant_type , restaurant_location , restaurant_city) values (?,?,?,?)";
                    PreparedStatement pst1 = con.prepareStatement(sql1);
                    pst1.setString(1, restroName);
                    pst1.setString(2, restroType);
                    pst1.setString(3, restroLocation);
                    pst1.setString(4, restroCity);


                    System.out.println("Record Inserted: " + pst1.executeUpdate());
                    break;
                case 3:
                    // hotels
                    System.out.println("insert into hotel:");
                    System.out.println("enter hotel name : ");
                    String hotelName = sc.nextLine();
                    System.out.println("enter hotel type(in stars) : ");
                    String hotelType = sc.nextLine();
                    System.out.println("enter hotel location : ");
                    String hotelLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String hotelCity = sc.nextLine();


                    String sql2 = "insert into hotels (hotel_name , hotel_type , hotel_location , hotel_city) values (?,?,?,?)";
                    PreparedStatement pst2 = con.prepareStatement(sql2);
                    pst2.setString(1, hotelName);
                    pst2.setString(2, hotelType);
                    pst2.setString(3, hotelLocation);
                    pst2.setString(4, hotelCity);


                    System.out.println("Record Inserted: " + pst2.executeUpdate());
                    break;
                case 4:
                    // atm
                    System.out.println("insert into ATM:");
                    System.out.println("enter ATM name : ");
                    String atmName = sc.nextLine();
                    System.out.println("enter ATM location : ");
                    String atmLocation = sc.nextLine();
                    System.out.println("enter ATM name : ");
                    String atmCity = sc.nextLine();


                    String sql3 = "insert into hotels (atm_name , atm_location , atm_city) values (?,?,?)";
                    PreparedStatement pst3 = con.prepareStatement(sql3);
                    pst3.setString(1, atmName);
                    pst3.setString(2, atmLocation);
                    pst3.setString(3, atmCity);


                    System.out.println("Record Inserted: " + pst3.executeUpdate());
                    break;
                case 5:
                    // fuel pumps
                    System.out.println("insert into fuel pumps:");
                    System.out.println("enter pump name : ");
                    String pumpName = sc.nextLine();
                    System.out.println("enter fuel type(petrol/diesel/cng/electric) : ");
                    String fuelType = sc.nextLine();
                    System.out.println("enter pump location : ");
                    String pumpLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String pumpCity = sc.nextLine();


                    String sql4 = "insert into fuel_pumps(p__name , f_type , p_location , p_city) values(?,?,?,?)";
                    PreparedStatement pst4 = con.prepareStatement(sql4);
                    pst4.setString(1, pumpName);
                    pst4.setString(2, fuelType);
                    pst4.setString(3, pumpLocation);
                    pst4.setString(4, pumpCity);


                    System.out.println("Record Inserted: " + pst4.executeUpdate());
                    break;
                case 6:
                    // public transportations
                    System.out.println("insert into public transportations:");
                    System.out.println("enter transport name : ");
                    String transportName = sc.nextLine();
                    System.out.println("enter transport route : ");
                    String transportRoute = sc.nextLine();
                    System.out.println("enter transport schedule : ");
                    String transportSchedule = sc.nextLine();
                    System.out.println("enter city name : ");
                    String transportCity = sc.nextLine();


                    String sql5 = "insert into public_transportation(t_name , t_route , t_schedule , t_city) values(?,?,?,?)";
                    PreparedStatement pst5 = con.prepareStatement(sql5);
                    pst5.setString(1, transportName);
                    pst5.setString(2, transportRoute);
                    pst5.setString(3, transportSchedule);
                    pst5.setString(4, transportCity);


                    System.out.println("Record Inserted: " + pst5.executeUpdate());
                    break;
                case 7:
                    // smart buildings
                    System.out.println("insert into smart buildings:");
                    System.out.println("enter smart building name : ");
                    String buildingName = sc.nextLine();
                    System.out.println("enter smart building location : ");
                    String buildingLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String buildingCity = sc.nextLine();


                    String sql6 = "insert into smart_buildings(b_name , b_location , b_city) values(?,?,?)";
                    PreparedStatement pst6 = con.prepareStatement(sql6);
                    pst6.setString(1, buildingName);
                    pst6.setString(2, buildingLocation);
                    pst6.setString(3, buildingCity);


                    System.out.println("Record Inserted: " + pst6.executeUpdate());
                    break;
                case 8:
                    // hospitals
                    System.out.println("insert into hospitals:");
                    System.out.println("enter hospital name : ");
                    String hospitalName = sc.nextLine();
                    System.out.println("enter hospital location : ");
                    String hospitalLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String hospitalCity = sc.nextLine();


                    String sql7 = "insert into fuel_pumps(h_name , h_location , h_city) values(?,?,?)";
                    PreparedStatement pst7 = con.prepareStatement(sql7);
                    pst7.setString(1, hospitalName);
                    pst7.setString(2, hospitalLocation);
                    pst7.setString(3, hospitalCity);


                    System.out.println("Record Inserted: " + pst7.executeUpdate());
                    break;
                case 9:
                    // school
                    System.out.println("insert into school pumps:");
                    System.out.println("enter school name : ");
                    String schoolName = sc.nextLine();
                    System.out.println("enter school standards(like 1 to 10 std) : ");
                    String schoolEdu = sc.nextLine();
                    System.out.println("enter school schedule : ");
                    String schoolLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String schoolCity = sc.nextLine();


                    String sql8 = "insert into school(s_name , s_edu , s_location , s_city) values(?,?,?,?)";
                    PreparedStatement pst8 = con.prepareStatement(sql8);
                    pst8.setString(1, schoolName);
                    pst8.setString(2, schoolEdu);
                    pst8.setString(3, schoolLocation);
                    pst8.setString(4, schoolCity);


                    System.out.println("Record Inserted: " + pst8.executeUpdate());
                    break;
                case 10:
                    // colleges
                    System.out.println("insert into colleges:");
                    System.out.println("enter college name : ");
                    String collegeName = sc.nextLine();
                    System.out.println("enter  college feculties(B.tech,Bsc,BBA,etc) : ");
                    String collegeEdu = sc.nextLine();
                    System.out.println("enter college location : ");
                    String collegeLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String collegeCity = sc.nextLine();


                    String sql9 = "insert into college(c_name , c_edu , c_location , c_city) values(?,?,?,?)";
                    PreparedStatement pst9 = con.prepareStatement(sql9);
                    pst9.setString(1, collegeName);
                    pst9.setString(2, collegeEdu);
                    pst9.setString(3, collegeLocation);
                    pst9.setString(4, collegeCity);


                    System.out.println("Record Inserted: " + pst9.executeUpdate());
                    break;
                case 11:
                    // emergency services
                    System.out.println("insert into emergency service:");
                    System.out.println("enter emergency service name : ");
                    String eName = sc.nextLine();
                    System.out.println("enter emergency service number : ");
                    String eNumber = sc.nextLine();
                    System.out.println("enter city name : ");
                    String eCity = sc.nextLine();


                    String sql10 = "insert into emergency_services(e_name , e_contact_number , e_city) values(?,?,?)";
                    PreparedStatement pst10 = con.prepareStatement(sql10);
                    pst10.setString(1, eName);
                    pst10.setString(2, eNumber);
                    pst10.setString(3, eCity);


                    System.out.println("Record Inserted: " + pst10.executeUpdate());
                    break;
                case 12:
                    // police stations
                    System.out.println("insert into police stations:");
                    System.out.println("enter police stations name : ");
                    String pName = sc.nextLine();
                    System.out.println("enter police stations incharge name : ");
                    String pIncharge = sc.nextLine();
                    System.out.println("enter police stations location : ");
                    String pLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String pCity = sc.nextLine();


                    String sql11 = "insert into police_station(p_name , p_incharge_name , p_location , p_city) values(?,?,?,?)";
                    PreparedStatement pst11 = con.prepareStatement(sql11);
                    pst11.setString(1, pName);
                    pst11.setString(2, pIncharge);
                    pst11.setString(3, pLocation);
                    pst11.setString(4, pCity);


                    System.out.println("Record Inserted: " + pst11.executeUpdate());
                    break;
                case 13:
                    // goverment offices
                    System.out.println("insert into goverment offices:");
                    System.out.println("enter goverment offices name : ");
                    String gName = sc.nextLine();
                    System.out.println("enter goverment offices incharge name : ");
                    String gIncharge = sc.nextLine();
                    System.out.println("enter goverment offices location : ");
                    String gLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String gCity = sc.nextLine();


                    String sql12 = "insert into police_station(g_name , g_officer_name , g_location , g_city) values(?,?,?,?)";
                    PreparedStatement pst12 = con.prepareStatement(sql12);
                    pst12.setString(1, gName);
                    pst12.setString(2, gIncharge);
                    pst12.setString(3, gLocation);
                    pst12.setString(4, gCity);


                    System.out.println("Record Inserted: " + pst12.executeUpdate());
                    break;
                case 14:
                    // parks
                    System.out.println("insert into parks:");
                    System.out.println("enter park name : ");
                    String parkName = sc.nextLine();
                    System.out.println("enter parks location : ");
                    String parkLocation = sc.nextLine();
                    System.out.println("enter city name : ");
                    String parkCity = sc.nextLine();


                    String sql13 = "insert into police_station(p_name , p_location , p_city) values(?,?,?)";
                    PreparedStatement pst13 = con.prepareStatement(sql13);
                    pst13.setString(1, parkName);
                    pst13.setString(2, parkLocation);
                    pst13.setString(3, parkCity);


                    System.out.println("Record Inserted: " + pst13.executeUpdate());
                    break;
                case 15:
                    // exit
                    System.out.println("*****");
                    System.out.println("exit");
                    System.out.println("*****");
                    flag = 1;
                    break;
                default:
                    System.out.println("invalid choice");
                    System.out.println("try again");


            }
        }


    }


    void update() throws SQLException {


        int flag = 0;
        while (flag != 1) {
            System.out.println("update data ");
            System.out.println("1: restaurants");
            System.out.println("2: hotels");
            System.out.println("3: fuel pumps");
            System.out.println("4: smart buildings");
            System.out.println("5: hospital");
            System.out.println("6: schools");
            System.out.println("7: colleges");
            System.out.println("8: emergency services");
            System.out.println("9: police station");
            System.out.println("10: government offices");
            System.out.println("11: parks");
            System.out.println("12: exit");
            System.out.println("enter your choice : ");
            int choice3 = sc.nextInt();
            sc.nextLine();


            switch (choice3) {
                case 1:
                    // restaurant
                    System.out.println("update restaurant data:");
                    System.out.println("Restaurant id :");
                    int restroId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update restaurant name : ");
                    String update_restroName = sc.nextLine();
                    System.out.println("update restaurant type(veg/non-veg) : ");
                    String update_restroType = sc.nextLine();


                    String sql_1 = "update restaurants set restaurant_name=? , restaurant_type=? where restaurant_id=?";
                    PreparedStatement pst_1 = con.prepareStatement(sql_1);
                    pst_1.setString(1, update_restroName);
                    pst_1.setString(2, update_restroType);
                    pst_1.setInt(3, restroId);
                    System.out.println("Record Updated: " + pst_1.executeUpdate());
                    break;


                case 2:
                    // hotels
                    System.out.println("update hotel data :");
                    System.out.println("Hotel id : ");
                    int hotelId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update hotel name : ");
                    String update_hotelName = sc.nextLine();
                    System.out.println("update hotel type(in stars) : ");
                    String update_hotelType = sc.nextLine();


                    String sql_2 = "update hotels set hotel_name=? , hotel_type=? where hotel_id=?";
                    PreparedStatement pst_2 = con.prepareStatement(sql_2);
                    pst_2.setString(1, update_hotelName);
                    pst_2.setString(2, update_hotelType);
                    pst_2.setInt(3, hotelId);
                    System.out.println("Record Updated: " + pst_2.executeUpdate());
                    break;
                case 3:
                    // fuel pumps
                    System.out.println("update fuel pump data:");
                    System.out.println("Pump id : ");
                    int pumpId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update fuel type(petrol/diesel/cng/electric) : ");
                    String update_fuelType = sc.nextLine();


                    String sql_3 = "update fuel_pumps set f_type=? where p_id=?";
                    PreparedStatement pst_3 = con.prepareStatement(sql_3);
                    pst_3.setString(1, update_fuelType);
                    pst_3.setInt(2, pumpId);
                    System.out.println("Record Updated: " + pst_3.executeUpdate());
                    break;


                case 4:
                    // smart buildings
                    System.out.println("update smart building data:");
                    System.out.println("Smart building id : ");
                    int buildingId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update smart building name : ");
                    String update_buildingName = sc.nextLine();


                    String sql_4 = "update smart_buildings set b_name=? where b_id=?";
                    PreparedStatement pst_4 = con.prepareStatement(sql_4);
                    pst_4.setString(1, update_buildingName);
                    pst_4.setInt(2, buildingId);
                    System.out.println("Record Updated: " + pst_4.executeUpdate());
                    break;


                case 5:
                    // hospitals
                    System.out.println("update hospital data :");
                    System.out.println("Hospital id : ");
                    int hospitalId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update hospital name : ");
                    String update_hospitalName = sc.nextLine();


                    String sql_5 = "update hospital set h_name=? where h_id=?";
                    PreparedStatement pst_5 = con.prepareStatement(sql_5);
                    pst_5.setString(1, update_hospitalName);
                    pst_5.setInt(2, hospitalId);
                    System.out.println("Record Updated: " + pst_5.executeUpdate());
                    break;


                case 6:
                    // school
                    System.out.println("update school data:");
                    System.out.println("School id : ");
                    int schoolId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update school name : ");
                    String update_schoolName = sc.nextLine();
                    System.out.println("update school standards(like 1 to 10 std) : ");
                    String update_schoolEdu = sc.nextLine();


                    String sql_6 = "update school set s_name=? , s_edu=?  where s_id=?";
                    PreparedStatement pst_6 = con.prepareStatement(sql_6);
                    pst_6.setString(1, update_schoolName);
                    pst_6.setString(2, update_schoolEdu);
                    pst_6.setInt(3, schoolId);
                    System.out.println("Record Updated: " + pst_6.executeUpdate());
                    break;


                case 7:
                    // colleges
                    System.out.println("update college data:");
                    System.out.println("College id = ");
                    int collegeId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update college name : ");
                    String update_collegeName = sc.nextLine();
                    System.out.println("update  college faculties(B.tech,Bsc,BBA,etc) : ");
                    String update_collegeEdu = sc.nextLine();


                    String sql_7 = "update college set c_name=? , c_edu=? where s_id=?";
                    PreparedStatement pst_7 = con.prepareStatement(sql_7);
                    pst_7.setString(1, update_collegeName);
                    pst_7.setString(2, update_collegeEdu);
                    pst_7.setInt(3, collegeId);
                    System.out.println("Record Updated: " + pst_7.executeUpdate());
                    break;


                case 8:
                    // emergency services
                    System.out.println("update emergency service data :");
                    System.out.println("Emergency service id :");
                    int eId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update emergency service number : ");
                    String update_eNumber = sc.nextLine();


                    String sql_8 = "update emergency_services set e_contact_number=? where e_id=?";
                    PreparedStatement pst_8 = con.prepareStatement(sql_8);
                    pst_8.setString(1, update_eNumber);
                    pst_8.setInt(2, eId);
                    System.out.println("Record Updated: " + pst_8.executeUpdate());
                    break;


                case 9:
                    // police stations
                    System.out.println("update police stations data:");
                    System.out.println("Police station id : ");
                    int pId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update police stations incharge name : ");
                    String update_pIncharge = sc.nextLine();


                    String sql_9 = "update police_station set p_incharge=? where p_id=?";
                    PreparedStatement pst_9 = con.prepareStatement(sql_9);
                    pst_9.setString(1, update_pIncharge);
                    pst_9.setInt(2, pId);
                    System.out.println("Record Updated: " + pst_9.executeUpdate());
                    break;


                case 10:
                    // goverment offices
                    System.out.println("update goverment offices data:");
                    System.out.println("Government office id : ");
                    int gId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update goverment offices incharge name : ");
                    String update_gIncharge = sc.nextLine();


                    String sql_10 = "update government_office set g_officer_name=? where g_id=?";
                    PreparedStatement pst_10 = con.prepareStatement(sql_10);
                    pst_10.setString(1, update_gIncharge);
                    pst_10.setInt(2, gId);
                    System.out.println("Record Updated: " + pst_10.executeUpdate());
                    break;


                case 11:
                    // parks
                    System.out.println("update parks data:");
                    System.out.println("Park id : ");
                    int parkId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("update park name : ");
                    String update_parkName = sc.nextLine();


                    String sql_11 = "update parks set p_name=? where p_id=?";
                    PreparedStatement pst_11 = con.prepareStatement(sql_11);
                    pst_11.setString(1, update_parkName);
                    pst_11.setInt(2, parkId);
                    System.out.println("Record Updated: " + pst_11.executeUpdate());
                    break;


                case 12:
                    // exit
                    System.out.println("*****");
                    System.out.println("exit");
                    System.out.println("*****");
                    flag = 1;
                    break;


                default:
                    System.out.println("invalid choice");
                    System.out.println("try again");


            }
        }
    }


    void fetch() throws Exception {


        Statement st = con.createStatement();


        int flag = 0;
        while (flag != 1) {
            System.out.println("************************************");
            System.out.println("Fetch details of : ");
            System.out.println("************************************");
            System.out.println("-------------------------------------");
            System.out.println("|  1: city                          |");
            System.out.println("|  2: restaurants                   |");
            System.out.println("|  3: hotels                        |");
            System.out.println("|  4: atm                           |");
            System.out.println("|  5: fuel pumps                    |");
            System.out.println("|  6: public transportation         |");
            System.out.println("|  7: smart buildings               |");
            System.out.println("|  8: hospital                      |");
            System.out.println("|  9: schools                       |");
            System.out.println("|  10: colleges                     |");
            System.out.println("|  11: emergency services           |");
            System.out.println("|  12: police station               |");
            System.out.println("|  13: government offices           |");
            System.out.println("|  14: parks                        |");
            System.out.println("|  15: exit                         |");
            System.out.println("-------------------------------------");
            System.out.print("enter your choice : ");
            int choice2 = sc.nextInt();
            sc.nextLine();
            System.out.println("************************************");
            System.out.println();


            switch (choice2) {
                case 1:
                    // city


                    System.out.println("Details of city:");


                    System.out.println("-------------------------------------------------------------");


                    String sql = "select*from city";
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4));


                    }
                    break;


                case 2:
                    // restaurant
                    System.out.println("Details of Restaurant :");


                    System.out.println(
                            "-------------------------------------------------------------");
                    System.out.printf("%-6s %-15s %-10s %-15s %-15s\n", "R_ID", "R_NAME", "R_TYPE", "R_LOCATION",
                            "R_CITY");
                    System.out.println(
                            "-------------------------------------------------------------");
                    sql = "select*from restaurants";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.printf("%-6d %-15s %-10s %-15s %-15s\n", rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4), rs.getString(5));


                    }
                    break;


                case 3:
                    // hotels
                    System.out.println("Details of hotel : ");
                    sql = "select *from hotels where";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;
                case 4:
                    // atm
                    System.out.println("Details of ATMs : ");
                    sql = "select *from atms";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4));
                    }
                    break;
                case 5:
                    // fuel pumps
                    System.out.println("Details of Fuel Pumps : ");
                    sql = "select *from fuel_pumps";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;
                case 6:
                    // public transportations
                    System.out.println("Details of Public Transportation : ");
                    sql = "select *from public_transportation";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;


                case 7:
                    // smart buildings
                    System.out.println("Details of Smart Building : ");
                    sql = "select *from smart_buildings";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4));
                    }
                    break;
                case 8:
                    // hospitals
                    System.out.println("Details of Hospitals : ");
                    sql = "select *from hospital";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4));
                    }
                    break;
                case 9:
                    // school
                    System.out.println("Details of School : ");
                    sql = "select *from school";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;
                case 10:
                    // colleges
                    System.out.println("Details of College : ");
                    sql = "select *from college";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;
                case 11:
                    // emergency services


                    System.out.println("Details of Emergency Service : ");
                    sql = "select *from emergency_services";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getInt(3) +
                                rs.getString(4));
                    }
                    break;
                case 12:
                    // police stations
                    System.out.println("Details of Police Station : ");
                    sql = "select *from police_station";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;
                case 13:
                    // goverment offices
                    System.out.println("Details of Government Offices : ");
                    sql = "select *from   government_office";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4) + rs.getString(5));
                    }
                    break;
                case 14:
                    // parks
                    System.out.println("Details of Parks: ");
                    sql = "select *from parks";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) +
                                rs.getString(4));
                    }
                    break;
                case 15:
                    // exit
                    System.out.println("*****");
                    System.out.println("exit");
                    System.out.println("*****");
                    flag = 1;
                    break;
                default:
                    System.out.println("invalid choice");
                    System.out.println("try again");


            }
        }
    }


    void delete() throws Exception {


        int flag = 0;
        while (flag != 1) {
            System.out.println("delete data :");
            System.out.println("1: restaurants");
            System.out.println("2: hotels");
            System.out.println("3: fuel pumps");
            System.out.println("4: smart buildings");
            System.out.println("5: hospital");
            System.out.println("6: schools");
            System.out.println("7: colleges");
            System.out.println("8: emergency services");
            System.out.println("9: police station");
            System.out.println("10: government offices");
            System.out.println("11: parks");
            System.out.println("12: exit");
            System.out.println("enter your choice : ");
            int choice3 = sc.nextInt();
            sc.nextLine();


            switch (choice3) {
                case 1:
                    // restaurant
                    System.out.println("delete restaurant data:");
                    System.out.println("Restaurant id :");
                    int restroId = sc.nextInt();


                    String sql_1 = "delete from restaurants where restaurant_id=?";
                    PreparedStatement pst_1 = con.prepareStatement(sql_1);
                    pst_1.setInt(1, restroId);
                    System.out.println("Record Updated: " + pst_1.executeUpdate());
                    break;


                case 2:
                    // hotels
                    System.out.println("delete hotel data :");
                    System.out.println("Hotel id : ");
                    int hotelId = sc.nextInt();


                    String sql_2 = "delete from hotels  where hotel_id=?";
                    PreparedStatement pst_2 = con.prepareStatement(sql_2);
                    pst_2.setInt(1, hotelId);
                    System.out.println("Record Updated: " + pst_2.executeUpdate());
                    break;


                case 3:
                    // fuel pumps
                    System.out.println("delete fuel pump data:");
                    System.out.println("Pump id : ");
                    int pumpId = sc.nextInt();


                    String sql_3 = "delete from fuel_pumps where p_id=?";
                    PreparedStatement pst_3 = con.prepareStatement(sql_3);
                    pst_3.setInt(1, pumpId);
                    System.out.println("Record Updated: " + pst_3.executeUpdate());
                    break;


                case 4:
                    // smart buildings
                    System.out.println("delete smart building data:");
                    System.out.println("Smart building id : ");
                    int buildingId = sc.nextInt();


                    String sql_4 = "delete from smart_buildings where b_id=?";
                    PreparedStatement pst_4 = con.prepareStatement(sql_4);
                    pst_4.setInt(1, buildingId);
                    System.out.println("Record Updated: " + pst_4.executeUpdate());
                    break;


                case 5:
                    // hospitals
                    System.out.println("delete hospital data :");
                    System.out.println("Hospital id : ");
                    int hospitalId = sc.nextInt();


                    String sql_5 = "delete from hospital where h_id=?";
                    PreparedStatement pst_5 = con.prepareStatement(sql_5);
                    pst_5.setInt(1, hospitalId);
                    System.out.println("Record Updated: " + pst_5.executeUpdate());
                    break;


                case 6:
                    // school
                    System.out.println("delete school data:");
                    System.out.println("School id : ");
                    int schoolId = sc.nextInt();


                    String sql_6 = "delete from school  where h_id=?";
                    PreparedStatement pst_6 = con.prepareStatement(sql_6);
                    pst_6.setInt(1, schoolId);
                    System.out.println("Record Updated: " + pst_6.executeUpdate());
                    break;


                case 7:
                    // colleges
                    System.out.println("delete college data:");
                    System.out.println("College id = ");
                    int collegeId = sc.nextInt();


                    String sql_7 = "delete from college where s_id=?";
                    PreparedStatement pst_7 = con.prepareStatement(sql_7);
                    pst_7.setInt(1, collegeId);
                    System.out.println("Record Updated: " + pst_7.executeUpdate());
                    break;


                case 8:
                    // emergency services
                    System.out.println("delete emergency service data :");
                    System.out.println("Emergency service id :");
                    int eId = sc.nextInt();


                    String sql_8 = "delete from emergency_services  where e_id=?";
                    PreparedStatement pst_8 = con.prepareStatement(sql_8);
                    pst_8.setInt(1, eId);
                    System.out.println("Record Updated: " + pst_8.executeUpdate());
                    break;


                case 9:
                    // police stations
                    System.out.println("delete police stations data:");
                    System.out.println("Police station id : ");
                    int pId = sc.nextInt();


                    String sql_9 = "delete from police_station where p_id=?";
                    PreparedStatement pst_9 = con.prepareStatement(sql_9);
                    pst_9.setInt(1, pId);
                    System.out.println("Record Updated: " + pst_9.executeUpdate());
                    break;


                case 10:
                    // goverment offices
                    System.out.println("delete goverment offices data:");
                    System.out.println("Government office id : ");
                    int gId = sc.nextInt();


                    String sql_10 = "delete from government_office where g_id=?";
                    PreparedStatement pst_10 = con.prepareStatement(sql_10);
                    pst_10.setInt(1, gId);
                    System.out.println("Record Updated: " + pst_10.executeUpdate());
                    break;


                case 11:
                    // parks
                    System.out.println("delete parks data:");
                    System.out.println("Park id : ");
                    int parkId = sc.nextInt();


                    String sql_11 = "delete from parks where p_id=?";
                    PreparedStatement pst_11 = con.prepareStatement(sql_11);
                    pst_11.setInt(1, parkId);
                    System.out.println("Record Updated: " + pst_11.executeUpdate());
                    break;


                case 12:
                    // exit
                    System.out.println("*****");
                    System.out.println("exit");
                    System.out.println("*****");
                    flag = 1;
                    break;


                default:
                    System.out.println("invalid choice");
                    System.out.println("try again");


            }
        }
    }
}



