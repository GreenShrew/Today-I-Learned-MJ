package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.Dbman;

public class BoardDao {

	private BoardDao() {}
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() { return itc; }
	
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> selectBoard() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql = "select * from board order by num desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum( rs.getInt("num") );
				bdto.setUserid( rs.getString("userid" ) );
				bdto.setPass( rs.getString("pass") );
				bdto.setEmail( rs.getString("email") );
				bdto.setTitle( rs.getString("title") );
				bdto.setContent( rs.getString("content") );
				bdto.setReadcount( rs.getInt("readcount") );
				bdto.setWritedate( rs.getTimestamp("writedate") );
				list.add(bdto);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return list;
	}
	
	
}
