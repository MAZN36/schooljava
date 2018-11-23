package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.s_area_code;

public class s_area_codeDAO {
	public List<s_area_code> finAll(int areaCode){
		String sql="select * from s_area_code where areaCode="+areaCode;
		ResultSet rs=DBUtil.executeQuery(sql);
		List<s_area_code> list=new ArrayList<s_area_code>();
			s_area_code model=null;
			try {
				while(rs.next()){
					model=new s_area_code(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					list.add(model);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
}
