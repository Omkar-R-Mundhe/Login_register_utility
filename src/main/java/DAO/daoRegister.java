package DAO;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.*;
import utility.DBconnection;

public class daoRegister {
	public void registerUser(registerUser user) {

		final String dbSchema = "Insert into users(username,email,password)Values(?,?,?)";
		try (Connection con = DBconnection.getConnection()) {
//			load the driver first

			System.out.println("The driver is loaded!");

//			get the connection

//			Create the statment 
			PreparedStatement pstmt = con.prepareStatement(dbSchema);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

//			execute the statment
			pstmt.executeUpdate();
			System.out.println("User is registered with db!");
//			close the statment
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
