package com.ezen.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.shop.dto.OrderVO;
import com.ezen.shop.dto.Paging;
import com.ezen.shop.dto.ProductVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Repository
public class AdminDao {

	private JdbcTemplate template;
	
	@Autowired  
	public AdminDao( ComboPooledDataSource dataSource ) {
		this.template = new JdbcTemplate(dataSource);
	}

	public int workerCheck(String workId, String workPwd) {
		int result = 0;
		
		String sql = "select pwd from worker where id=?";
		
		List<String> list = template.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String pwd = rs.getString("pwd");
				return pwd;
			}
		}, workId);
		
		if( list.size() == 0) result=-1;
		else if( workPwd.equals( list.get(0) ) ) result=1;
		else result = 0;		
		
		return result;
	}

	
	
	public List<ProductVO> productList( Paging paging, String key ) {
		// String sql = "select * from product";
		String sql = "select * from (   "
				+ " select * from ("
				+ " select rownum as rn, p.* from "
				+ " ((select * from product where name like '%'||?||'%' order by pseq desc) p )"
				+ " ) where rn>=?  "
				+ " ) where rn<=? ";
		
		List<ProductVO> list = template.query(sql , new RowMapper<ProductVO>(){
			@Override
			public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));      		
				pvo.setIndate(rs.getTimestamp("indate"));
    	    	pvo.setName(rs.getString("name"));   	
    	    	pvo.setPrice1(rs.getInt("price1"));
    	    	pvo.setPrice2(rs.getInt("price2"));   	    
    	    	pvo.setPrice3(rs.getInt("price3"));
    	    	pvo.setImage(rs.getString("image"));   	
    	    	pvo.setUseyn(rs.getString("useyn"));
    	        pvo.setBestyn(rs.getString("bestyn"));
				return pvo;
			}			
		}, key, paging.getStartNum(),  paging.getEndNum() );
		return list;
	}

	public int getAllCount(String tableName, String fieldName, String key) {
		String sql = "select count(*) as cnt from " + tableName 
				+ " where " + fieldName + " like '%'||?||'%' ";
		List<Integer> list = template.query(sql, new RowMapper<Integer>(){

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int count = rs.getInt("cnt");
				return count;
			}
		}, key);
		return list.get(0);
	}

	public void insertProduct(ProductVO pvo) {
		String sql = "insert into product( pseq, kind, name, price1, price2, price3, content, image) "
				+ " values( product_seq.nextVal, ? , ? , ? , ? , ? , ? , ? )";
		template.update(sql, pvo.getKind(), pvo.getName(), pvo.getPrice1(), pvo.getPrice2(), 
				pvo.getPrice3(), pvo.getContent(), pvo.getImage() );
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "update product set kind=? , useyn=? , name=? , price1=? , price2=?, "
				+ " price3=?, content=? , image=?, bestyn=? where pseq=? ";
		template.update(sql , pvo.getKind(), pvo.getUseyn(), pvo.getName(), pvo.getPrice1(), 
				pvo.getPrice2(), pvo.getPrice3(), pvo.getContent(), pvo.getImage(), 
				pvo.getBestyn(), pvo.getPseq() );
	}

	public List<OrderVO> orderList(Paging paging, String key) {
		String sql = "select * from ("
				+ " select * from ( "
				+ " select rownum as rn, o.* from "
				+ " ((select * from order_view where mname like '%'||?||'%'  order by result , odseq desc) o)"
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		List<OrderVO> list = template.query(sql, new RowMapper<OrderVO>() {
			@Override
			public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));				
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setId(rs.getString("id"));						
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setMname(rs.getString("mname"));		
				ovo.setZipnum(rs.getString("zip_num"));
				ovo.setAddress(rs.getString("address"));		
				ovo.setPhone(rs.getString("phone"));
				ovo.setPseq(rs.getInt("pseq"));					
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setPname(rs.getString("pname"));			
				ovo.setPrice2(rs.getInt("price2"));
				ovo.setResult(rs.getString("result"));
				return ovo;
			}
		} , key , paging.getStartNum() , paging.getEndNum());
		return list;
	}

	public void updateOrderResult(int odseq) {
		
		String sql = "Update order_detail set result='2' where odseq=?";
		template.update(sql, odseq);
		
	}

	
}

















