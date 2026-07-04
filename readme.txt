-ทดสอสอบ spring data jdbc
-mariadb
-ทดสอบการ Insert และ Update ข้อมูลใน Product โดย primary key เราใช้ AUTO_INCREMENT
-ทดสอบการ Insert และ Update ข้อมูลใน CustOrder โดย primary key เรา generate เอง
-การสร้างฟิดล์แบบ camel case ในตาราง CustOrder เพื่อให้ spring data jdbc map ข้อมูลได้ถูกต้องซึ่งแปลงจาก camel case เป็น snake case โดยอัตโนมัติ
-การใช้ java-uuid-generator เพื่อสร้าง UUIDv7 ให้กับ primary key ของ CustOrder
-spring data jdbc ไม่รองรับ composite primary key ดังนั้นเราต้องสร้าง primary key ขึ้นมาเอง
---แนวทางปฏิบัติการว่างโครงสร้างโปรเจ็ค --- 
com.example.app
├── controller/       (รับ Request/Response จากภายนอก)
├── service/          (เขียน Business Logic ล้วนๆ)
├── repository/       (คุยกับ Database)
├── model/            (คลาสหลักของระบบ / Entity ที่ผูกกับตาราง)
├── dto/              (POJO ธรรมดา เอาไว้รับส่งข้อมูลกับหน้าเว็บเท่านั้น)
├── config/           (พวกไฟล์ตั้งค่าต่างๆ)
└── exception/        (ดักจับและจัดการ Error)
