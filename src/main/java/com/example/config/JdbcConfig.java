/*
 * class นี้ถ้าเป็นฐานข้อมูลดังๆ เช่น mysql,mariadb,mssql,oracle,postgresql,h2,sqllite 
 * ไม่จำเป็นต้องมี
 */
package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.dialect.JdbcDialect;
import org.springframework.data.jdbc.core.dialect.JdbcH2Dialect;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {

	@Override
	public JdbcDialect jdbcDialect(NamedParameterJdbcOperations operations) {
		// ขอยืม Dialect ของ H2 มาใช้แทน เนื่องจาก H2 สร้างคำสั่งระดับ ANSI SQL
		// และตัวคลาสสืบทอด interface JdbcDialect มาให้พร้อมใช้งานแล้ว ซึ่งเหมาะกับ firebird
		return JdbcH2Dialect.INSTANCE;
	}
}