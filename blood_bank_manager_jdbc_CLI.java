import java.sql.*;
import java.util.Scanner;  

class vishnu_jdbc{  
	
	public static void main(String args[]){ 
		
		System.out.println("\n-------- WELCOME TO BLOOD BANK MANAGEMENT SYSTEM --------");
		Scanner sc = new Scanner(System.in);
		
		try{			
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","admin");   
			Statement stmt=con.createStatement(); 
			
			String str = "show databases";
			ResultSet res = stmt.executeQuery(str);
			int flag = 1;
			while(res.next()) {
				if(res.getString("Database").equalsIgnoreCase("BloodBank")) {
					flag = 0;
				}
			}
			if(flag == 1) {
				str = "create database BloodBank";
				stmt.executeUpdate(str);
			}			
			
			str = "use BloodBank";
			stmt.executeUpdate(str);
			
			str = "show tables";
			res = stmt.executeQuery(str);
			flag = 1;
			while(res.next()) {
				if(res.getString("Tables_in_BloodBank").equalsIgnoreCase("admin")) {
					flag  = 0;
				}
			}
			if(flag == 1) {
				str = "create table admin(username varchar(10), password varchar(10))";
				stmt.executeUpdate(str);
				str = "insert into admin values('admin', 'admin')";
				stmt.executeUpdate(str);
			}	
			
			str = "show tables";
			res = stmt.executeQuery(str);
			flag = 1;
			while(res.next()) {
				if(res.getString("Tables_in_BloodBank").equalsIgnoreCase("donor")) {
					flag  = 0;;
				}
			}
			if(flag == 1) {
				str = "create table donor(donor_id int, donor_name varchar(10), age varchar(20), gender varchar(20), blood_group varchar(5), height varchar(20), weight varchar(20), address varchar(50), phone_no varchar(20))";
				stmt.executeUpdate(str);
			}
			
			str = "show tables";
			res = stmt.executeQuery(str);
			flag = 1;
			while(res.next()) {
				if(res.getString("Tables_in_BloodBank").equalsIgnoreCase("seeker")) {
					flag  = 0;;
				}
			}
			if(flag == 1) {
				str = "create table seeker(id int, name varchar(10), address varchar(50), phone_no varchar(20))";
				stmt.executeUpdate(str);
			}
				
			
			while(true) {
								
				System.out.println("\n1) Admin Login");
				System.out.println("2) User Login");
				System.out.println("3) Exit");
				System.out.print("\nEnter your choice : ");
				
				int login = sc.nextInt();
				
				if(login == 1) {
					
					String username, password;
					
					System.out.print("Enter the username : ");
					username = sc.next();
					
					System.out.print("Enter the password : ");
					password = sc.next();
					
					str = "select * from admin";
					res = stmt.executeQuery(str);
					
					flag = 1;
					
					while(res.next()) {
						
						if(res.getString("username").equals(username) && res.getString("password").equals(password)) {
							
							System.out.println("\nSuccessfull login!");
							flag = 0;
							break;
						}
					}
					
					if(flag == 1){
						
						System.out.println("\nUser Not Found!");
						continue;
					}
					
					while(true) {
					
						System.out.println("\n1) Donor Details");
						System.out.println("2) Seeker Details");
						System.out.println("3) Blood Details");
						System.out.println("4) Create Admin");
						System.out.println("5) Show Admins");
						System.out.println("6) Exit Admin");
						System.out.print("\nEnter your choice : ");
						
						int admin = sc.nextInt();
						
						if(admin == 1) {
							
							
							System.out.println("\n1) View Donor details");
							System.out.println("2) Delete Donor details");
							System.out.print("Enter your choice : ");
							int choice = sc.nextInt();
							
							if(choice == 1) {
								int count = 0;
								str = "select * from donor";
								res = stmt.executeQuery(str);
								System.out.println("");
								while(res.next()) {
									System.out.println(res.getInt("donor_id") + " " + res.getString("donor_name") + " " + res.getInt("age") + " " + res.getString("gender") + " " + res.getString("blood_group") + " " + res.getString("height") + " " + res.getString("weight") + " " + res.getString("address") + " " + res.getString("phone_no"));
									count++;
								}
								if(count == 0) {
									System.out.println("\nNo Donors Available!");
								}else {
									System.out.println("\nTotally " + count + " Donors available!");
								}
								
							}else if(choice == 2) {
								
								str = "select count(*) as count from donor";
								res = stmt.executeQuery(str);
								res.next();
								int n1 = res.getInt("count");
								if(n1 == 0) {
									System.out.println("\nNo Donors available to delete the record");
									continue;
								}
								
								System.out.print("Enter the id of the donor to delete : ");
								String id = sc.next();
								StringBuilder build = new StringBuilder("delete from donor where donor_id = ");
								build.append(id);
								stmt.executeUpdate(build.toString());
								
								str = "select count(*) as count from donor";
								res = stmt.executeQuery(str);
								res.next();
								int n2 = res.getInt("count");
								
								if(n2 < n1) {
									
									System.out.println((n1 - n2) + " Records Successfully Deleted");
									
								}else {
									
									System.out.println("No Record Found!");
									
								}							
	//							
							}else{
								
								System.out.println("Incorrect Option! Try Again.");
								continue;
								
							}
							
						}else if(admin == 2) {						
							
							
							System.out.println("\n1. View Seeker details");
							System.out.println("2. Delete Seeker details");
							System.out.print("Enter the choice : ");
							int choice = sc.nextInt();
							
							if(choice == 1) {
								
								int count = 0;
								String fetch = "select * from seeker";
								res = stmt.executeQuery(fetch);
								System.out.println("");
								
								while(res.next()) {
									
									System.out.println(res.getInt("id") + " " + res.getString("name") + " "  + res.getString("address") + " " + res.getString("phone_no"));
									count++;
									
								}
								if(count == 0) {
									System.out.println("\nNo seekers available");
								}else {
									System.out.println("\nTotally " + count + " seekers are there.");
								}
								
							}else if(choice == 2) {
								
								str = "select count(*) from seeker";
								res = stmt.executeQuery(str);
								res.next();
								int n1 = res.getInt("count(*)");						
								
								System.out.print("Enter the id of the seeker to delete : ");
								String id = sc.next();
								StringBuilder build = new StringBuilder("delete from seeker where id = ");
								build.append(id);
								stmt.executeUpdate(build.toString());
								
								str = "select count(*) from seeker";
								res = stmt.executeQuery(str);
								res.next();
								int n2 = res.getInt("count(*)");
								
								if(n2 < n1) {
									System.out.println((n1 - n2) + " Records Successfully Deleted");
								}else {
									System.out.println("No Record Found!");
								}
								
							}else {
								System.out.println("Incorrect Option! Start from begining.");
								continue;
							}
							
						}else if(admin == 3){						
							
							
							System.out.println("\n1. Units of blood in each type");
							System.out.println("2. Diplay persons with their blood group");
							System.out.print("Enter the choice : ");						
							int option = sc.nextInt();
							
							if(option == 1) {
							
								str = "select blood_group, count(*) as count from donor group by blood_group";
								res = stmt.executeQuery(str);
								int count = 0;
								System.out.println("");
								while(res.next()) {
									System.out.println(res.getString("blood_group") + " - " + res.getString("count") + " " + "units of blood available");
									count++;
								}
								if(count == 0) {
									System.out.println("\nNo persons available!");
								}
								
							}else if(option == 2) {
								
								int count = 0;
								str = "select donor_name, blood_group from donor";
								res = stmt.executeQuery(str);
								System.out.println("");
								while(res.next()) {
									System.out.println(res.getString("donor_name") + " " + res.getString("blood_group"));
									count++;
								}
								if(count == 0) {
									System.out.println("\nNo persons available!");
								}else {
									System.out.println("\nTotally " + count + " persons available");
								}
								
							}else {
								
								System.out.println("Incorrect Option! Start from begining.");
								continue;
								
							}				
							
						}else if(admin == 4) {
							
	
							StringBuilder build = new StringBuilder("insert into admin values('");
							System.out.print("\nEnter the new username to create : ");
							str = sc.next();
							build.append(str);
							build.append("',");
							System.out.print("Enter the password : ");
							build.append("'");
							str = sc.next();
							build.append(str);
							build.append("')");
							stmt.executeUpdate(build.toString());
	//						System.out.println(build.toString());
							System.out.println("\nAdmin Successfully Created!");					
							
							
						}else if(admin == 5){
							
							str = "select * from admin";
							res = stmt.executeQuery(str);
							
							while(res.next()) {
								
								System.out.println(res.getString("username") + " " + res.getString("password"));
								
							}
								
						}else if(admin == 6) {
							System.out.println("\n" + username + " Logged Out");
							break;
							
						}else {
							
							System.out.println("Incorrect Option! Start from begining.");
							continue;
							
						}
					}
					
				}else if(login == 2) {
					
					while(true) {
					
						System.out.println("\n1.Donor");
						System.out.println("2.Seeker");
						System.out.println("3.Exit User Login");
						System.out.print("Enter your preference : ");					
						int user = sc.nextInt();
						StringBuilder build = new StringBuilder("insert into");
						
						if(user == 1) {
							
							build.append(" donor values(");
							
							System.out.println("\nEnter the required details : ");						
							
							System.out.print("donor id : ");
							build.append(sc.next());
							build.append(", ");
							
							System.out.print("donor name : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("donor age : ");
							build.append(sc.next());
							build.append(", ");
							
							System.out.print("donor gender : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("donor blood_group : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("donor height : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("donor weight : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("donor address : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("donor phone_no : ");
							build.append(sc.next());
							build.append(")");
							
							System.out.println("\nSuccessfully inserted!");
							stmt.executeUpdate(build.toString());					
							
						}else if(user == 2) {
							
							build.append(" seeker values(");
							
							System.out.println("\nEnter the required details : ");						
							
							System.out.print("seeker id : ");
							build.append(sc.next());
							build.append(", ");
							
							System.out.print("seeker name : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("seeker address : ");
							build.append("'");
							build.append(sc.next());
							build.append("', ");
							
							System.out.print("seeker phone_no : ");
							build.append(sc.next());
							build.append(")");
	
							System.out.println("\nSuccessfully inserted!");
							stmt.executeUpdate(build.toString());
							
						
						}else if(user == 3) {
							System.out.println("User Exited!");
							break;
						}else {						
							System.out.println("Incorrect Option! Enter again.");
							
						}
					
					}
					
				}else if (login == 3) {
					
					System.out.println("\nThank you for choosing the program!");
					break;
					
				}else {
					
					System.out.println("\nIncorrect Option!");
					continue;
					
				}
			}
		}
		
		catch(Exception e){
			
			System.out.println(e);
			
		}

		finally {
			
			sc.close();
			
		}
	}  
}  