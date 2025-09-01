package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import model.*;
import utility.DBconnection;

public class daoLogin {
	public boolean checkLogin(User user) {

		final String dbSchema = "Select*from users where username=? ";
		try (Connection con = DBconnection.getConnection()) {
//			
//			Create the statment 
			PreparedStatement pstmt = con.prepareStatement(dbSchema);
			pstmt.setString(1, user.getUsername());

//			execute the statment
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String hashedPass = rs.getString("password");
				String pass = user.getPassword();
				System.out.println(pass);
				System.out.println(BCrypt.checkpw(pass, hashedPass));

				if (BCrypt.checkpw(pass, hashedPass)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

//			close the statment

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
