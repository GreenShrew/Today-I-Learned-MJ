package com.ezen.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dto.WordSet;
import com.ezen.word.util.DataBaseManager;

public class WordDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Autowired
	DataBaseManager dbm;
	
//	public WordDao(DataBaseManager dbm) {
//		this.dbm = dbm;
//	}

	public void insert(WordSet wordSet) {
		
		String sql = "insert into wordset value(?, ?)";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wordSet.getWordKey());
			pstmt.setString(2, wordSet.getWordValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.close(con, pstmt, rs);
		}
		dbm.close(con, pstmt, rs);
	}

	public WordSet search(String kw) {
		
		return null;
	}
}
