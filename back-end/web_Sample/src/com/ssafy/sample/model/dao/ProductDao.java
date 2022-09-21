package com.ssafy.sample.model.dao;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDao {
	private DBUtil dbUtil = DBUtil.getInstance();
	
	public int insertDept(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into product(code,model,price) values(?,?,?)";
		try {
			// step2
			conn = dbUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			int rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt+" 행이 처리되었습니다.");
			return rowCnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(conn, pstmt);
		}
		return 0;
	}
	
	public Product selectProduct(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		String sql = "select code, model, price from product where code = ?";
		try {
			// step2
			conn = dbUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			// step5
			
			if (rs.next()) {
				product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(conn,pstmt,rs);
		}
		return product;
	}
	
	public List<Product> selectProducts(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		
		String sql = "select code, model, price from product";
		try {
			// step2
			conn = dbUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			rs = pstmt.executeQuery();
			
			// step5
			
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(conn,pstmt,rs);
		}
		return list;
	}
	
	public int modifyProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update product set model = ?, price = ? where code = ?";
        try {
            // step2
            conn = dbUtil.getConnection();

            // step3
            pstmt = conn.prepareStatement(sql);

            // step4
            pstmt.setString(1, product.getModel());
            pstmt.setInt(2, product.getPrice());
            pstmt.setString(3, product.getCode());
            int rowCnt = pstmt.executeUpdate();
            System.out.println("modify: " + rowCnt+" 행이 처리되었습니다.");
            return rowCnt;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtil.close(conn, pstmt);
        }

        return 0;
    }
	
	public int deleteProduct(String code) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete product from product where code = ?";
        try {
            // step2
            conn = dbUtil.getConnection();

            // step3
            pstmt = conn.prepareStatement(sql);

            // step4
           pstmt.setString(1,code);
            int rowCnt = pstmt.executeUpdate();
            System.out.println("delete : " + rowCnt+" 행이 처리되었습니다.");
            return rowCnt;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtil.close(conn, pstmt);
        }
        return 0;
    }
}
